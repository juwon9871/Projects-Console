package com.blinddate.matchservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.xml.bind.DataBindingException;

import com.blinddate.mainInterface.DBManager;
public class PtopMatchDAO {
	//
	ArrayList<UserDTO> userList = null;

	public int msuccess(String id, String msuccess) {
		int result = 0;
		String sql = "UPDATE usertable SET msuccess =? WHERE id =?";
		
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
		}finally {
			DBManager.close(con, pstmt);
		}
		return result;
	}
	public int mfail(String id) {
		int result = 0;
		String sql = "UPDATE usertable SET msuccess ='' WHERE id =?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.getconnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt);
		}
		return result;
	}

	

	
	public ArrayList<UserDTO> ptpMat(UserDTO sDto) {
		// result값 초기화
		userList = new ArrayList<>();
		// con, pstmt, rs 객체 생성
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// match 조건 sql
			String sql = "SELECT name, age, addr, phonenum, id " + "FROM usertable " + "WHERE age BETWEEN ? -3 AND ? +3 "
					+ "AND height BETWEEN ? -5 AND ? +5 " + "AND weight BETWEEN ? -5 AND ? +5 " + "AND gender = ?"
					+ "AND addr LIKE ?" + "AND matching = '1' " + "AND rownum = 1 ";

			con = DBManager.getconnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, sDto.getAge());
			pstmt.setInt(2, sDto.getAge());
			pstmt.setInt(3, sDto.getHeight());
			pstmt.setInt(4, sDto.getHeight());
			pstmt.setInt(5, sDto.getWeight());
			pstmt.setInt(6, sDto.getWeight());
			pstmt.setString(7, sDto.getGender());
			pstmt.setString(8, sDto.getAddr() + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				UserDTO iDto = new UserDTO();
				iDto.setName(rs.getString("name"));
				iDto.setAge(rs.getInt("age"));
				iDto.setAddr(rs.getString("addr"));
				iDto.setPhoneNum(rs.getString("phonenum"));
				iDto.setId(rs.getString("id"));
				userList.add(iDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return userList;
	}

}
