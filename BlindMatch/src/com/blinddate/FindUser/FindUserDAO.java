package com.blinddate.FindUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.blinddate.mainInterface.DBManager;

public class FindUserDAO {
	// 객체 선언
	Scanner sc = new Scanner(System.in);
	ArrayList<FindUserDTO> FindUserList = null;

//	String id;
//	String pwd;
//	String name;
//	String phoneNum;

	
//가입된 이름, 폰번인지 확인하기
	public int namePhoneNumCheck(String name, String phoneNum) {
		String sql = "SELECT phoneNum FROM USERTABLE WHERE name=?";

		int result = -1;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.getconnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 0;
				String dbphoneNum = rs.getString("phoneNum");

				if (dbphoneNum.equals(phoneNum)) {
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
	//아이디 찾기
	public String findId(String name, String phoneNum) {
		String getUserId = null;

		String sql = "SELECT id FROM USERTABLE WHERE name=? AND phoneNum=?";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.getconnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				getUserId = rs.getString("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return getUserId;
	}

	
	//아이디 폰번호 체크
	public int idPhoneNumCheck(String id, String phoneNum) {
		String sql = "SELECT phoneNum FROM usertable where id=?";
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
				String dbphoneNum = rs.getString("phoneNum");

				if (dbphoneNum.equals(phoneNum)) {
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
	//비밀번호 찾기
	public String findpwd(String id, String phoneNum) {
		String getUserpwd = null;
		
	String sql = "SELECT pwd FROM usertable where id = ? and phoneNum = ?";

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		con = DBManager.getconnection();
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, phoneNum);
		rs= pstmt.executeQuery();
		
		while(rs.next()) {
			
			getUserpwd = rs.getString("pwd");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	return getUserpwd;
	}
	
	
	// 객체 선언
//	ArrayList<FindUserDTO> findList = null;
	// 아이디 찾기 메서드
//	public int findId(FindUserDTO fuDto) {
//		
//		
//		int result = 0;
//		//아이디 찾기 sql
//		String sql = "SELECT id FROM usertable where name = ?, phoneNum = ?";
//		
//	      Connection con = null;
//	      PreparedStatement pstmt = null;
//	      ResultSet rs = null;
//				
//	      try {
//	    	  con = DBManager.getconnection();
//	          pstmt = con.prepareStatement(sql);
//	          
//	          pstmt.setString(1, name);
//	          pstmt.setString(2, phoneNum);
//	          rs= pstmt.executeQuery();
//	          
//	          while(rs.next()) {
//	             findId = rs.getString("id");
//	          }
//	          System.out.println(finderId);
//		} catch (Exception e) {
//		}
//	}
}
