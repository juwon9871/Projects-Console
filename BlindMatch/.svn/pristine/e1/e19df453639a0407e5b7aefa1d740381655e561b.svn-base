package com.blinddate.matchingResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.blinddate.matchservice.UserDTO;
import com.blinddate.mainInterface.DBManager;

public class MatchingResultDAO {

	public String msuccess(String id) {

		String sql = "SELECT msuccess FROM usertable WHERE id = ?";
		UserDTO uDto = new UserDTO();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.getconnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				uDto.setId(rs.getString("msuccess"));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		return uDto.getId();
	}
	public String matching(String id) {
		
		String sql = "SELECT matching FROM usertable WHERE id = ?";
		UserDTO uDto = new UserDTO();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getconnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				uDto.setMatching(rs.getString("matching"));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		return uDto.getMatching();
	}

	public ArrayList<UserDTO> ptpResult(String id) {
		ArrayList<UserDTO> opList = new ArrayList<>();
		String sql = "SELECT name,age,addr,phoneNum FROM usertable WHERE id =?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getconnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				UserDTO uDto = new UserDTO();
				uDto.setName(rs.getString("name"));
				uDto.setAge(rs.getInt("age"));
				uDto.setAddr(rs.getString("addr"));
				uDto.setPhoneNum(rs.getString("phoneNum"));
				
				opList.add(uDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return opList;
	}
	public ArrayList<UserDTO> ptpResultSend(String id) {
		ArrayList<UserDTO> opList = new ArrayList<>();
		String sql = "SELECT name,age,addr,phoneNum FROM usertable WHERE msuccess =?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getconnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				UserDTO uDto = new UserDTO();
				uDto.setName(rs.getString("name"));
				uDto.setAge(rs.getInt("age"));
				uDto.setAddr(rs.getString("addr"));
				uDto.setPhoneNum(rs.getString("phoneNum"));
				
				opList.add(uDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return opList;
	}
}
