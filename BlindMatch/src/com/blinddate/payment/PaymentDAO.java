package com.blinddate.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.blinddate.mainInterface.DBManager;

public class PaymentDAO {
	// List 객체 선언
	ArrayList<PaymentDTO> PaymentList = null;
	Scanner sc = new Scanner(System.in);

	String name;
	String id;
	String pwd;
	int pay;
	int monthlyPay;
	String payCheck;
	String payDate;
	String coupon;
	String adminAccount;

	public void accountNotice() {
		String noticeAccount = "356-0468-4005-13";
		System.out.println("♡           입금하실 계좌 " + noticeAccount + "       ♡");
	}

	public int insertPaymentCheck(String id, String pwd, String name) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;

		try {
			String sql = "SELECT paycheck FROM USERTABLE WHERE id=? AND pwd=? AND name=?";
			con = DBManager.getconnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String paycheck = rs.getString("paycheck");
				if (paycheck.equals("Y")) {
					result = -1;
					break;
				} else {
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int insertPayment(String id, String pwd, String name) {
		PaymentList = new ArrayList<>();
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DBManager.getconnection();
			String sql = "UPDATE usertable SET paycheck='Y' WHERE id=? AND pwd=? AND name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			result = pstmt.executeUpdate();
			con = DBManager.getconnection();
			sql = "UPDATE usertable SET paydate=SYSDATE WHERE id=? AND pwd=? AND name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			result = pstmt.executeUpdate();
//			insertPaymentCheck(id, pwd, name);
			if (result > 0) {
				System.out.println("");
				System.out.println("    ━━━━━━━━━━━━━━━━━━━━━━♥     결제 완료     ♥━━━━━━━━━━━━━━━━━━━━━━");
				System.out.println("");
			} else {
//				insertPaymentCheck(id, pwd, name);
				System.out.println("");
				System.out.println("    ━━━━━━━━━━━━━━━━━━━━━━♥     결제 실패     ♥━━━━━━━━━━━━━━━━━━━━━━");
				System.out.println("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<PaymentDTO> payTermination(String id, String pwd, String name) {
		PaymentList = new ArrayList<>();
		int result = 0;
		PaymentDTO pDto = new PaymentDTO();
		String sql = "SELECT PAYCHECK FROM USERTABLE WHERE ID=? AND PWD=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.getconnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				pDto.setPayCheck(rs.getString("PAYCHECK"));

				if (pDto.getPayCheck().equals("Y")) {
					sql = "UPDATE USERTABLE SET PAYCHECK = 'N' WHERE ID=? AND PWD=? AND NAME=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, pwd);
					pstmt.setString(3, name);
					result = pstmt.executeUpdate();
					if (result > 0) {
						String sql2 = "UPDATE USERTABLE SET PAYDATE='' WHERE ID=? AND PWD=? AND NAME=?";
						pstmt = con.prepareStatement(sql2);
						pstmt.setString(1, id);
						pstmt.setString(2, pwd);
						pstmt.setString(3, name);
						pstmt.executeUpdate();
						System.out.println("");
						System.out.println("    ━━━━━━━━━━━━━━━━━━━━━━♥ 해지 완료 ♥━━━━━━━━━━━━━━━━━━━━━━");
						System.out.println("");
					} else {
						System.out.println("");
						System.out.println("    ━━━━━━━━━━━━━━━━━━━━━━♥ 해지 실패 ♥━━━━━━━━━━━━━━━━━━━━━━");
						System.out.println("");
					}
				} else {
					System.out.println("");
					System.out.println("    ━━━━━━━━━━━━━━━━━━━━━━♥ 해지 실패 ♥━━━━━━━━━━━━━━━━━━━━━━");
					System.out.println("");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return PaymentList;
	}

	public void contractWithdrawl() {
		PaymentList = new ArrayList<>();
		PaymentDTO pDto = new PaymentDTO();
		System.out.println();
		System.out.println();
		System.out.println("    ━━━━━━━━━━━━━━━━━━━━━━♥ 청약철회는 결제후 7일이 지나면 불가합니다 ♥━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println();
		System.out.println();
		while (true) {
			System.out.print("♡                 ID를 입력해주세요               ♡");
			System.out.println();
			System.out.println();
			id = sc.nextLine();
			if (id.equals("")) {
				continue;
			} else {
				break;
			}
		}
		while (true) {
			System.out.print(" ♡               비밀번호를 입력해주세요             ♡");
			System.out.println();
			System.out.println();
			pwd = sc.nextLine();
			if (pwd.equals("")) {
				continue;
			} else {
				break;
			}
		}
		while (true) {
			System.out.print("♡                이름를 입력해주세요               ♡");
			name = sc.nextLine();
			if (name.equals("")) {
				continue;
			} else {
				break;
			}
		}

		if (!id.equals("") && !pwd.equals("") && !name.equals("")) {
			pDto.getId();
			pDto.getPwd();
			pDto.getName();
		}

		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			con = DBManager.getconnection();
			String sql = "SELECT TO_DATE(SYSDATE) - TO_DATE(paydate) AS drawdate FROM USERTABLE WHERE id=? AND pwd=? AND name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String drawDate = rs.getString("drawdate");
				if (Integer.parseInt(drawDate) > 7) {
					System.out.println("    ━━━━━━━━━━━━━━━━━━━━━━♥ 청약철회가 불가합니다 ♥━━━━━━━━━━━━━━━━━━━━━━");
					System.out.println();
				} else {
					con = DBManager.getconnection();
					sql = "UPDATE USERTABLE SET PAYCHECK='N' WHERE id=? AND pwd=? AND name=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, pwd);
					pstmt.setString(3, name);

					int result1 = pstmt.executeUpdate();

					if (result1 > 0) {
						String sql2 = "UPDATE USERTABLE SET PAYDATE='' WHERE ID=? AND PWD=? AND NAME=?";
						pstmt = con.prepareStatement(sql2);
						pstmt.setString(1, id);
						pstmt.setString(2, pwd);
						pstmt.setString(3, name);
						pstmt.executeUpdate();
						System.out.println();
						System.out.println();
						System.out.println(
								"    ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━♥ 청약철회 되었습니다 ♥━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
						System.out.println();
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int discountCoupon(String id, String pwd) {
		int discountRate = 0;

		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			con = DBManager.getconnection();

			String sql = "SELECT COUPONNO FROM USERTABLE WHERE id=? AND pwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			String notCoupon = null;
			while (rs.next()) {
				notCoupon = rs.getString("COUPONNO");
				if (notCoupon == null) {
					System.out.println();
					System.out.println("━━━━━━━━━━━━━━━━━━━━━━♥  보유한 쿠폰이 없습니다. ♥━━━━━━━━━━━━━━━━━━━━━━");
					System.out.println();
				} else {
					System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━♥  보유중인 쿠폰 목록입니다  ♥━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
					System.out.println("┃                                                           ┃");
					System.out.println("┃                        " + notCoupon + "                             ┃");
					System.out.println("┃                                                           ┃");
					System.out.println(
							"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
					System.out.println();
				}
			}
			if (notCoupon != null) {
				sql = "SELECT COUPONDISCOUNT FROM USERTABLE WHERE COUPONNO=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, notCoupon);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					discountRate = rs.getInt("COUPONDISCOUNT");

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return discountRate;
	}

	public String applyCoupon(String haveCoupon) {
		String discountRate = null;
		PaymentDAO pDao = new PaymentDAO();

		pDao.discountCoupon(id, pwd);
		return discountRate;
	}

	public int userCheck(String id, String pwd) {
		String sql = "SELECT pwd FROM usertable WHERE id=?";

		int result = -1;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.getconnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = 0;
				String dbPwd = rs.getString("pwd");

				if (dbPwd.equals(pwd)) {
					result = 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return result;
	}
}