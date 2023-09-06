package com.blinddate.matchservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.blinddate.mainInterface.DBManager;

public class UserDAO {


	// updateUserInfo 등록 메서드
	public int updateUserInfo(UserDTO uDto) {
		int result = 0;

		// update 등록 sql
		String sql = "UPDATE usertable SET age =?, height = ?" + ", weight = ?, mbti = ?, car = ?"
				+ ", rel = ?, drink = ?, smoke = ?, addr = ?, matching =? " + "WHERE id = ?";

		// conn, pstmt 객체 생성
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.getconnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, uDto.getAge());
			pstmt.setInt(2, uDto.getHeight());
			pstmt.setInt(3, uDto.getWeight());
			pstmt.setString(4, uDto.getMbti());
			pstmt.setString(5, uDto.getCar());
			pstmt.setString(6, uDto.getRel());
			pstmt.setString(7, uDto.getDrink());
			pstmt.setString(8, uDto.getSmoke());
			pstmt.setString(9, uDto.getAddr());
			pstmt.setString(10, uDto.getMatching());
			pstmt.setString(11, uDto.getId());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}

		return result;
	} // updateUserInfo 메서드 괄호

	// updateChoiceInfo 등록 메서드
	public int updateChoiceInfo(UserDTO cDto) {
		// 리턴값
		int result = 0;

		// 상대정보 update 등록 sql
		String sql = "UPDATE userchoice SET age =?, height = ?" + ", weight = ?, mbti = ?, car = ?"
				+ ", rel = ?, drink = ?, smoke = ?, gender = ?, addr = ? " + "WHERE id = ?";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.getconnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cDto.getAge());
			pstmt.setInt(2, cDto.getHeight());
			pstmt.setInt(3, cDto.getWeight());
			pstmt.setString(4, cDto.getMbti());
			pstmt.setString(5, cDto.getCar());
			pstmt.setString(6, cDto.getRel());
			pstmt.setString(7, cDto.getDrink());
			pstmt.setString(8, cDto.getSmoke());
			pstmt.setString(9, cDto.getGender());
			pstmt.setString(10, cDto.getAddr());
			pstmt.setString(11, cDto.getId());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}

		return result;
	} 
	
	public UserDTO myName(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDTO mNDto = null;
		String sql = "SELECT name FROM usertable WHERE id = "
				   + "(SELECT id FROM userchoice WHERE id = ?)";
		
		try {
			con = DBManager.getconnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				mNDto = new UserDTO();
				mNDto.setName(rs.getString("name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mNDto;
	}
	
	public int upMsuccess(String msuccess, String id) {
		int result = 0;

		// update 등록 sql
		String sql = "UPDATE usertable SET msuccess = ? WHERE id = ?";

		// conn, pstmt 객체 생성
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.getconnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, msuccess);
			pstmt.setString(2, id);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}

		return result;
	}
	
	
	
} // DAO class 종료
