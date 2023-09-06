package com.blinddate.matchservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.blinddate.matchservice.UserDTO;
import com.blinddate.mainInterface.DBManager;

public class AdminMatchDAO {

	ArrayList<UserDTO> userList = null;
	
// 어드민 매칭 신청한 고객이 기입한 이상형 나이 키 몸무게 뽑아오는 dao
	public UserDTO selUser(String id) {

		userList = new ArrayList<>();
		UserDTO uDto = null;
		String sql = "SELECT age,height,weight FROM userChoice WHERE  id =?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getconnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				uDto = new UserDTO();
				uDto.setAge(rs.getInt("age"));
				uDto.setHeight(rs.getInt("height"));
				uDto.setWeight(rs.getInt("weight"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return uDto;
	}
	public UserDTO selOpUser(String id) {
		
		userList = new ArrayList<>();
		UserDTO uDto = null;
		String sql = "SELECT age,height,weight FROM usertable WHERE  msuccess =?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getconnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				uDto = new UserDTO();
				uDto.setAge(rs.getInt("age"));
				uDto.setHeight(rs.getInt("height"));
				uDto.setWeight(rs.getInt("weight"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return uDto;
	}
	

	// 위 쿼리로 뽑아온 데이터를 조건으로 받고 고객의 정보를 유저테이블에서 다뽑아오는 dao
	
	public ArrayList<UserDTO> selAllUser(int age, int height, int weight, String name) {
		userList = new ArrayList<>();
		
		String sql = "SELECT * FROM usertable "
				+ "WHERE gender =(SELECT gender FROM userchoice WHERE id=?) "
				+ "AND age BETWEEN ? -5 AND ? +5 "
				+ "AND height BETWEEN ? -5 AND ? +5 "
				+ "AND weight BETWEEN ? -5 AND ? +5 "
				+ "AND mSuccess IS NULL";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getconnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setInt(3, age);
			pstmt.setInt(4, height);
			pstmt.setInt(5, height);
			pstmt.setInt(6, weight);
			pstmt.setInt(7, weight);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserDTO uDto = new UserDTO();
				uDto.setId(rs.getString("id"));
				uDto.setName(rs.getString("name"));
				uDto.setPhoneNum(rs.getString("phonenum"));
				uDto.setAge(rs.getInt("age"));
				uDto.setAddr(rs.getString("addr"));
				uDto.setCar(rs.getString("car"));
				uDto.setDrink(rs.getString("drink"));
				uDto.setGender(rs.getString("gender"));
				uDto.setHeight(rs.getInt("height"));
				uDto.setMbti(rs.getString("mbti"));
				uDto.setRel(rs.getString("rel"));
				uDto.setSmoke(rs.getString("smoke"));
				uDto.setWeight(rs.getInt("weight"));
				
				userList.add(uDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return userList;
	}
	public ArrayList<UserDTO> selOpUser(int age, int height, int weight, String name) {
		userList = new ArrayList<>();
		
		String sql = "SELECT * FROM usertable WHERE age=? AND height=? AND weight=? AND mSuccess =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getconnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, age);
			pstmt.setInt(2, height);
			pstmt.setInt(3, weight);
			pstmt.setString(4, name);
			rs = pstmt.executeQuery();
		;
			while (rs.next()) {
				UserDTO uDto = new UserDTO();
				uDto.setId(rs.getString("id"));
				uDto.setName(rs.getString("name"));
				uDto.setPhoneNum(rs.getString("phonenum"));
				uDto.setAge(rs.getInt("age"));
				uDto.setAddr(rs.getString("addr"));
				uDto.setCar(rs.getString("car"));
				uDto.setDrink(rs.getString("drink"));
				uDto.setGender(rs.getString("gender"));
				uDto.setHeight(rs.getInt("height"));
				uDto.setMbti(rs.getString("mbti"));
				uDto.setRel(rs.getString("rel"));
				uDto.setSmoke(rs.getString("smoke"));
				uDto.setWeight(rs.getInt("weight"));
				
				userList.add(uDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return userList;
	}
	//id의 정보 출력
	public ArrayList<UserDTO> selIdData(String id) {
		userList = new ArrayList<>();
		
		String sql = "SELECT * FROM userchoice WHERE id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getconnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				UserDTO uDto = new UserDTO();
				uDto.setAge(rs.getInt("age"));
				uDto.setAddr(rs.getString("addr"));
				uDto.setCar(rs.getString("car"));
				uDto.setDrink(rs.getString("drink"));
				uDto.setGender(rs.getString("gender"));
				uDto.setHeight(rs.getInt("height"));
				uDto.setMbti(rs.getString("mbti"));
				uDto.setRel(rs.getString("rel"));
				uDto.setSmoke(rs.getString("smoke"));
				uDto.setWeight(rs.getInt("weight"));
				
				userList.add(uDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return userList;
	}
	public ArrayList<UserDTO> selIdAddr(String id) {
		userList = new ArrayList<>();
		
		String sql = "SELECT addr FROM userchoice WHERE id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getconnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				UserDTO uDto = new UserDTO();
				uDto.setAddr(rs.getString("addr"));
				
				userList.add(uDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return userList;
	}
	// 관리자매칭일때 id 가져오는 dao
		public ArrayList<UserDTO> selUserId() {
			userList = new ArrayList<>();
			String sql = "SELECT id FROM userTable WHERE matching = 'a' AND mSuccess IS NULL";

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				conn = DBManager.getconnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					UserDTO uDto = new UserDTO();
					uDto.setId(rs.getString("id"));
					
					userList.add(uDto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			
			return userList;
		}
		
		

}
