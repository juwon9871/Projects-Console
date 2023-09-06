package com.daissso.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.daissso.DBConnection.DBConnect;
import com.daissso.admin.bookManageDAO;
import com.daissso.review.ReviewMain;


public class daissoMemberDAO {

	Scanner sc = new Scanner(System.in);
	bookManageDAO bMDAO = new bookManageDAO();
	ReviewMain rM = new ReviewMain();
	public void firstMenu() {
		while (true) {
			System.out.println("================================");
			System.out.println("1.회원가입  2.로그인  3.후기게시판  4.관리자 ");
			System.out.println("5.종료");
			System.out.println("================================");

			int inputMenu = sc.nextInt();
			sc.nextLine();

			if (inputMenu == 1) {
				joinMember();
			} else if (inputMenu == 2) {
				// 로그인 페이지
				loginPage();
			} else if (inputMenu == 3) {
				rM.mainReview();
			} else if (inputMenu == 4) {
				// 관리자 로그인
				while (true) {
					if (loginPage() == 1) {
						bMDAO.adminMenu();
						break;
					} else {
						break;
					}
				}
			} else if (inputMenu == 5) {
				break;
			} else {
				System.out.println("다시 입력해주세요");
				continue;
			}
		}
		sc.close();
	}

	public int insertMember(daissoMemberDTO dmDto) {
		// 유저 등록 메소드

		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "INSERT INTO daissoMember VALUES(?,?,?)";

		try {
			con = DBConnect.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, dmDto.getUserId());
			pstmt.setString(2, dmDto.getUserPwd());
			pstmt.setString(3, dmDto.getUserName());

			result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("===========================");
				System.out.println("====== 정상등록 되었습니다 =====");
				System.out.println("===========================");
			} else {
				System.out.println("===========================");
				System.out.println("====== 등록실패 하였습니다 =====");
				System.out.println("===========================");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnect.close(con, pstmt);
		}
		return result;
	}

	public void joinMember() {
		// 유저 등록

		String userId = null;
		String userPwd = null;
		String userName = null;

		while (true) {
			while (true) {
				System.out.println("종료하시려면 end 를 입력하세요");
				System.out.print("사용할 아이디를 입력하세요 >>> ");
				userId = sc.nextLine();

				if (userId.equals("")) {
					System.out.println("아이디는 필수 입력 항목입니다.");
					continue;
				} else {
					break;
				}

			}
			if (userId.equals("end"))
				break;

			while (true) {
				System.out.println("종료하시려면 end 를 입력하세요");
				System.out.print("사용할 비밀번호를 입력하세요 >>> ");
				userPwd = sc.nextLine();

				if (userPwd.equals("")) {
					System.out.println("비밀번호는 필수 입력 항목입니다.");
					continue;
				} else {
					break;
				}
			}
			if (userPwd.equals("end"))
				break;

			while (true) {
				System.out.println("종료하시려면 end 를 입력하세요");
				System.out.print("사용자 이름을 입력하세요 >>> ");
				userName = sc.nextLine();

				if (userName.equals("")) {
					System.out.println("이름은 필수 입력 항목입니다.");
					continue;
				} else {
					break;
				}
			}
			if (userName.equals("end"))
				break;

			if (!userId.equals("") && !userPwd.equals("") && !userName.equals("")) {
				daissoMemberDTO dmDto = new daissoMemberDTO(userId, userPwd, userName);

				int result = insertMember(dmDto);
				if (result > 0) {
					break;
				} else {
					continue;
				}
			}
		}
	}

	public int loginPage() {
		// 로그인페이지 출력
		String userId = null;
		String userPwd = null;
		int result = 0;

		while (true) {
				System.out.println("종료하시려면 end 를 입력하세요");
//				sc.nextLine();
				System.out.print("아이디를 입력하세요 >>> ");
				userId = sc.nextLine();

				if (userId.equals("end")) {
					break;
				} else if (userId.equals("")) {
					System.out.println("공백일 수 없습니다.");
					continue;
				}
			
			while (true) {
				System.out.print("비밀번호를 입력하세요 >>> ");
				userPwd = sc.nextLine();
				if (userPwd.equals("")) {
					System.out.println("비밀번호는 공백일 수 없습니다.");
					continue;
				}
				break;
			}
			daissoMemberDTO dmDto = new daissoMemberDTO(userId, userPwd);
			if (loginMember(dmDto) == 0) {
				System.out.println("아이디와 비밀번호를 다시 확인해주세요");
				continue;
			} else {
				result = 1;
				break;
			}
		}
		return result;
	}

	public int loginMember(daissoMemberDTO dmDto) {
		// 로그인시 아이디와 비밀번호 일치하는지 확인하는 메소드
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT userPwd FROM daissoMember WHERE userId=?";
		int result = 0;

		try {

			con = DBConnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dmDto.getUserId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String dbPwd = rs.getString("userPwd");
				if (dbPwd.equals(dmDto.getUserPwd())) {
					System.out.println(dmDto.getUserId() + " 님 반갑습니다!");
					result = 1;
				} else {
					result = 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnect.close(con, pstmt, rs);
		}
		return result;
	}

}
