package com.blinddate.LoginRegist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.blinddate.mainInterface.DBManager;

public class UsertableDAO {
	   
	   ArrayList<UsertableDTO> UsertableList = null;

	   // Usertable 등록 메서드
	   public int insertSignin(UsertableDTO aDto) {
	      // Usertable 회원 등록 성공 여부 확인
	      int result = 0;
	      // 회원정보 SQL
	      String sql = "INSERT INTO Usertable(ID,PWD,name,phoneNum,gender,auth) "
	               + "VALUES(?,?,?,?,?, 'USER')";
	      Connection con = null;
	      PreparedStatement pstmt = null;

	      try {
	         con = DBManager.getconnection();
	         pstmt = con.prepareStatement(sql);
	         
	         pstmt.setString(1, aDto.getId());
	         pstmt.setString(2, aDto.getPwd());
	         pstmt.setString(3, aDto.getName());
	         pstmt.setString(4, aDto.getPhoneNum());
	         pstmt.setString(5, aDto.getGender());
	         result = pstmt.executeUpdate();
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         DBManager.close(con, pstmt);
	      }
	      return result;
	   }

	   // 로그인
	   public int UsertableCheck(String UsertableId, String UsertablePwd) {
	      String sql = "SELECT pwd "
	               + "FROM usertable "
	               + "WHERE id = ?";

	      // 관리자가 id가 존재하지 않을 경우
	      int result = -1;

	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;

	      try {
	         conn = DBManager.getconnection();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, UsertableId);

	         rs = pstmt.executeQuery();
	         if (rs.next()) {
	            // id가 존재하지만 비밀번호가 불일치 할 경우
	            result = 0;
	            String dbPwd = rs.getString("pwd");

	            if (dbPwd.equals(UsertablePwd)) {
	               // id가 존재하고 미밀번호도 일치한 경우
	               result = 1;
	            }
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         DBManager.close(conn, pstmt, rs);
	      }

	      return result;
	   }

	   // Usertable 목록 취득
	   public ArrayList<UsertableDTO> selAllUsertable() {
	      UsertableList = new ArrayList<>() ;
	      
	      // Usertable 목록 취득 sql
	      String sql = "SELECT * "
	            + "FROM usertable ";
	      
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      try {
	         conn = DBManager.getconnection();
	         pstmt = conn.prepareStatement(sql);
	         
	         rs = pstmt.executeQuery();
	         
	         while (rs.next()) {
	            UsertableDTO mDto = new UsertableDTO();
	            mDto.setId(rs.getString("Id"));
	            mDto.setPwd(rs.getString("pwd"));
	            mDto.setName(rs.getString("name"));
	            mDto.setPhoneNum(rs.getString("phoneNum"));
	            mDto.setGender(rs.getString("gender"));
	            
	            UsertableList.add(mDto);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         DBManager.close(conn, pstmt, rs);
	      }
	      return UsertableList;
	   }



	}
