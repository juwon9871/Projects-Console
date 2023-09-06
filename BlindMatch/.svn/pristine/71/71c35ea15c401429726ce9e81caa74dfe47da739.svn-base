package com.blinddate.matchservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.blinddate.mainInterface.DBManager;

public class UserChoiceDAO {
	// 이상형 테이블에 어드민 매칭 신청 아이디 입력
	ArrayList<UserDTO> uChoice = null;
	
	public String checkId(String id) {
		String sql = "SELECT id FROM userchoice where id=?";
		String checkId = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.getconnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				 checkId = rs.getString("id");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);

		}

		return checkId;
	}

	public int insertUserChoice(String id) {
		int result = 0;

		String sql = "INSERT INTO userChoice(id) " + "VALUES(?)";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.getconnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1,id);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
		return result;
	}

	// 입력된 아이디에서 이상형 정보를 테이블에 업데이트
	public int updateUserChoice(UserDTO uDto) {
		int result = 0;

		String sql = "UPDATE userChoice SET age=?, height =?,weight=?,addr=?,mbti=?,car=?,drink=?,smoke=?,rel=? ";
		// + "WHERE id =?";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.getconnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, uDto.getAge());
			pstmt.setInt(2, uDto.getHeight());
			pstmt.setInt(3, uDto.getWeight());
			pstmt.setString(4, uDto.getAddr());
			pstmt.setString(5, uDto.getMbti());
			pstmt.setString(6, uDto.getCar());
			pstmt.setString(7, uDto.getDrink());
			pstmt.setString(8, uDto.getSmoke());
			pstmt.setString(9, uDto.getRel());
			// pstmt.setString(10, uDto.getId());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
		return result;
	}

	public int matchSuccess(String id,String mSuccess) {
		int result = 0;
		
		String sql = "UPDATE userTable SET mSuccess =? where  id =? ";
		// + "WHERE id =?";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.getconnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, mSuccess);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
		return result;
	}



}
