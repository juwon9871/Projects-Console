package com.daissso.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.daissso.DBConnection.DBConnect;



public class bookManageDAO {

	ArrayList<bookManageDTO> bookList = null;
	Scanner sc = new Scanner(System.in);

//======<1. 도서 등록 >======================================================
//======<관리자메뉴 출력>===========================================
	public void adminMenu() {
		int adminMenu;
		while (true) {
			System.out.println("==================================");
			System.out.println(" 1.도서등록  2.수정  3.조회  4.삭제  5.돌아가기    ");
			System.out.println("==================================");

			System.out.print(" ===== 원하시는 메뉴를 선택하세요 =====");

			adminMenu = sc.nextInt();
			sc.nextLine();
			if (adminMenu == 1) {
				// 1. 도서 등록
				adminBookpage();
			} else if (adminMenu == 2) {
				// 2. 도서 수정
				modifyPage();
			} else if (adminMenu == 3) {
				// 3. 도서 조회
				listViewPage();
			} else if ( adminMenu == 4 ) {
				// 4. 도서 삭제
				deletePage();
			} else if (adminMenu ==5) {
				break;
			} else {
				continue;
			}
		}
	}

//======<도서등록 기능>============================================
	public void adminBookpage() {
		String pno = null;
		String pname = null;
		String price = null;
		String publisher = null;
		String category = null;
		while (true) {
			System.out.print("도서 번호 :");
			pno = sc.nextLine();

			if (pno.equals("")) {
				continue;
			} else {
				break;
			}
		}

		while (true) {
			System.out.print(" 도서 이름 : ");
			pname = sc.nextLine();

			if (pname.equals("")) {
				continue;
			} else {
				break;
			}
		}

		while (true) {
			System.out.print(" 도서 가격 : ");
			price = sc.nextLine();

			if (price.equals("")) {
				continue;
			} else {
				break;
			}
		}

		while (true) {
			System.out.print(" 도서 출판사 : ");
			publisher = sc.nextLine();

			if (publisher.equals("")) {
				continue;
			} else {
				break;
			}
		}

		while (true) {
			System.out.print(" 도서 카테고리 : ");
			category = sc.nextLine();

			if (category.equals("")) {
				continue;
			} else {
				break;
			}
		}

		if (!pno.equals("") && !pname.equals("") && !price.equals("") && !publisher.equals("")
				&& !category.equals("")) {

			bookManageDTO aDto = new bookManageDTO(pno, pname, price, publisher, category);

			bookManageDAO aDao = new bookManageDAO();

			aDao.adminBookInsert(aDto);

		}

	}

	public int adminBookInsert(bookManageDTO aDto) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into booklist values(?,?,?,?,?)"; // ? : 바인딩변수

		// sql문 사용하려면 무조건 try-catch 사용해줘야함
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, aDto.getPno());
			pstmt.setString(2, aDto.getPname());
			pstmt.setString(3, aDto.getPrice());
			pstmt.setString(4, aDto.getPublish());
			pstmt.setString(5, aDto.getCategory());

			// executeUpdate() => 쿼리를 실행한 뒤, 적용된 행의 개수를 리턴(int type 리턴)
			result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("==== 등록 성공 ====");
			} else {
				System.out.println("==== 등록 실패 ====");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnect.close(conn, pstmt);
		}
		return result;
	}

//=======< 2. 도서 수정 > ===================================================
//=======< 수정할 도서번호 입력받는 페이지 >==============================
	public void modifyPage() {
		String pno = null;
		String price = null;

		// 책 리스트 한번 보여주고 그 중에 수정할 책 번호 입력받는다. => 우선 수정먼저 하고 리스트 보여주는거 짜기(조회처럼)
		System.out.println("도서 목록입니다. ");
		System.out.println(" ");
		ArrayList<bookManageDTO> bookList = new ArrayList<>();

		bookManageDAO aDao = new bookManageDAO();
		bookList = aDao.adminListView();

		if (bookList.isEmpty()) {
			System.out.println(" 자료가 존재하지 않습니다.");
		} else {
			System.out.println("도서번호 \t\t 책이름 \t\t 책가격 \t\t 출판사 \t\t 카테고리");
			System.out.println("============================================================================");

			for (int i = 0; i < bookList.size(); i++) {
				System.out.println(bookList.get(i).getPno() + "\t\t" + bookList.get(i).getPname() + "\t\t"
						+ bookList.get(i).getPrice() + "\t\t" + bookList.get(i).getPublish() + "\t\t"
						+ bookList.get(i).getCategory());
			}

		}

		while (true) {
			System.out.print("수정할 책 번호를 입력하세요: ");
			pno = sc.nextLine();

			if (pno.equals("")) {
				continue;
			} else {
				break;
			}
		}

		while (true) {
			System.out.print("수정할 가격을 입력해 주세요: ");
			price = sc.nextLine();

			if (price.equals("")) {
				continue;
			} else {
				break;
			}
		}

		if ((!pno.equals("")) && (!price.equals(""))) {
			bookManageDTO aDto = new bookManageDTO();
			aDto.setPno(pno);
			aDto.setPrice(price);

			adminModify(aDto);
			// ㄴ adminDAO 에 접근할건데 aDao라고 별칭을 붙여줬으니 aDao라고 써줄게
			// aDao에 접근해서 adminModify라는 함수를 실행해줄거야
			// 실행해줄건데 실행하기한 값은 aDto에서 가져올거야
		}
	}

//======<도서가격 수정 기능>==========================================
	public int adminModify(bookManageDTO aDto) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "UPDATE booklist SET price = ? WHERE pno = ? ";

		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, aDto.getPrice());
			pstmt.setString(2, aDto.getPno());

			result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("==== 수정에 성공 ====");
			} else {
				System.out.println("==== 수정 실패 ====");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnect.close(conn, pstmt);
		}
		return result;
	}

//=========== <3.도서 조회 > ==============================================
//=========== < 도서 목록 출력 > ================================
	public void listViewPage() {                                                                                                                   
		ArrayList<bookManageDTO> bookList = new ArrayList<>();

		bookList = adminListView();
		if (bookList.isEmpty()) {
			System.out.println(" 자료가 존재하지 않습니다.");
		} else {
			System.out.println("도서번호 \t\t 책이름 \t\t 책가격 \t\t 출판사 \t\t 카테고리");

			for (int i = 0; i < bookList.size(); i++) {
				System.out.println(bookList.get(i).getPno() + "\t\t" + bookList.get(i).getPname() + "\t\t"
						+ bookList.get(i).getPrice() + "\t\t" + bookList.get(i).getPublish() + "\t\t"
						+ bookList.get(i).getCategory());
			}

		}
	}
//==========< 도서 목록 조회 기능 >======================================
	public ArrayList<bookManageDTO> adminListView() {

		bookList = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM booklist ";

		try {
			conn = DBConnect.getConnection(); // -문을 열었고
			pstmt = conn.prepareStatement(sql); // -문 열고 sql문을 통해서 가져온 행들을 pstmt에 넣어줬고
			rs = pstmt.executeQuery(); // -pstmt에 있는 행들을 executeQuery()를 통해서
										// 테이블 형식으로 만들어주고 그 값을 rs에 저장.

			while (rs.next()) { // rs.next()를 사용해서 테이블에 접근해 커서 밑으로 내리기
				bookManageDTO aDto = new bookManageDTO(); // 공간을 만들어주고
				aDto.setPno(rs.getString("pno")); // 1. rs에 저장되어있는 값을 가져올건데 (db컬럼명에 접근해서 그곳에 저장되어있는 값인 pno를 가져온다)
													// 2. 1를 통해 가져온 값을 aDto에 보내줄거다.
				aDto.setPname(rs.getString("pname"));
				aDto.setPrice(rs.getString("Price"));
				aDto.setPublish(rs.getString("publish"));
				aDto.setCategory(rs.getString("category")); // 3.이렇게 한 행식 다 보내줬고,

				bookList.add(aDto); // 4.bookList에 더해줄거다 aDto에 저장된 값들을
									// => 한행씩 보내고 리스트로 받아온다. 반복문을 통해서
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnect.close(conn, pstmt, rs);
		}

		return bookList;
	}

//=====< 4.도서 삭제 > =========================================================
//=====< 삭제할 도서번호 입력받는 페이지 >==================================
	public void deletePage() {
		String pno = null;
		while (true) {
			System.out.println("돌아가시려면 end 를 입력하세요");
			System.out.println("삭제할 번호를 선택하세요 : ");
			pno = sc.nextLine();

			if (pno.equals("end")) {
				break;
			} 
			if (!pno.equals("")) {
				bookManageDTO aDto = new bookManageDTO();
				aDto.setPno(pno); // aDto에 접근해서 pno 값을 보내준다 위에서 받은 pno값을.

				bookManageDAO aDao = new bookManageDAO();
				adminDelete(aDto);
			} else {
				System.out.print(" 잘못 입력하셨습니다. 다시 입력해주세요 ");
				continue;
			}
		}
	}
//====== < 도서 삭제 기능 > ========================================
	public int adminDelete(bookManageDTO aDto) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "DELETE FROM booklist WHERE pno = ?";

		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, aDto.getPno());

			result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("==== 삭제 성공 ====");
			} else {
				System.out.println("==== 삭제 실패 ====");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnect.close(conn, pstmt);
		}

		return result;
	}

}
