package com.blinddate.matchservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.blinddate.mainInterface.DBManager;

public class RandMatchDAO {

	public UserDTO selChk(String id) {

		UserDTO sDto = null;
		String sql = "SELECT * FROM userchoice WHERE id = ? ";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.getconnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if(rs.next()){
				
				sDto = new UserDTO();
				
				sDto.setId(rs.getString("id"));
				sDto.setAge(rs.getInt("age"));
				sDto.setAddr(rs.getString("addr"));
				sDto.setHeight(rs.getInt("height"));
				sDto.setWeight(rs.getInt("weight"));
				sDto.setGender(rs.getString("gender"));
				sDto.setCar(rs.getString("car"));
				sDto.setDrink(rs.getString("drink"));
				sDto.setMbti(rs.getString("mbti"));
				sDto.setRel(rs.getString("rel"));
				sDto.setSmoke(rs.getString("smoke"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return sDto;

	}



	
	public ArrayList<UserDTO> randMat(UserDTO sDto) {
		// result값 초기화
		ArrayList<UserDTO> rdList = null;
		rdList = new ArrayList<>();
		// con, pstmt, rs 객체 생성
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// match 조건 sql
			String sql = "SELECT name, id " 
			           + "FROM usertable " 
					   + "WHERE age BETWEEN ? -5 AND ? +5 " 
					   + "AND height BETWEEN ? -5 AND ? +5 " 
			           + "AND weight BETWEEN ? -5 AND ? +5 "
					   + "AND gender = ?"
					   + "AND addr LIKE ?"
					   + "AND matching = 'r' ";

			con = DBManager.getconnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, sDto.getAge());
			pstmt.setInt(2, sDto.getAge());
			pstmt.setInt(3, sDto.getHeight());
			pstmt.setInt(4, sDto.getHeight());
			pstmt.setInt(5, sDto.getWeight());
			pstmt.setInt(6, sDto.getWeight());
			pstmt.setString(7, sDto.getGender());
			pstmt.setString(8, "%시%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				UserDTO iDto = new UserDTO();
				iDto.setName(rs.getString("name"));
				iDto.setId(rs.getString("id"));
				
				rdList.add(iDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		return rdList;
	}

	
	
	
}
