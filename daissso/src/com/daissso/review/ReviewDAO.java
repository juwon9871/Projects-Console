package com.daissso.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.daissso.jdbc.DBManager;

public class ReviewDAO {
	
	// insert 등록 메서드
	public int insertReview(ReviewDTO rDto) {
		
		int result = 0;
		
		// sql 등록
		
		String sql = "INSERT INTO review(no ,userid, rbook, rtitle, rtext) "
				   + "VALUES (re_seq.NEXTVAL, ?, ?, ?, ?)";
		
		// con, pstmt 객체 생성
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, rDto.getUserid());
			pstmt.setString(2, rDto.getRbook());
			pstmt.setString(3, rDto.getRtitle());
			pstmt.setString(4, rDto.getRtext());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
		
		return result;
	}
	
	public int updateReview(ReviewDTO upDto) {
		int result = 0;
		
		String sql = "UPDATE review SET rtitle = ?, rtext = ? WHERE no = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, upDto.getRtitle());
			pstmt.setString(2, upDto.getRtext());
			pstmt.setInt(3, upDto.getNo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
		
		return result;
	}

	public int deleteReview(ReviewDTO delDto) {
		int result = 0;
		
		String sql = "DELETE FROM review WHERE no = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, delDto.getNo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
		
		
		return result;
	}
	
	public ArrayList<ReviewDTO> selectReview(ReviewDTO sDto) {
		
		ArrayList<ReviewDTO> arr_Riview = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "SELECT no, rbook, rtitle, registered FROM review";
			
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ReviewDTO selDto = new ReviewDTO();
				
				selDto.setNo(rs.getInt("no"));
				selDto.setRbook(rs.getString("rbook"));
				selDto.setRtitle(rs.getString("rtitle"));
				selDto.setRegistered(rs.getString("registered"));
				
				arr_Riview.add(selDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
		return arr_Riview;
	}
	
	public ArrayList<ReviewDTO> selfReview(ReviewDTO sfDto) {
		
		ArrayList<ReviewDTO> arr_Riview = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "SELECT no, rbook, rtitle, registered FROM review WHERE userid = ?";
			
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, sfDto.getUserid());
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ReviewDTO selDto = new ReviewDTO();
				
				selDto.setNo(rs.getInt("no"));
				selDto.setRbook(rs.getString("rbook"));
				selDto.setRtitle(rs.getString("rtitle"));
				selDto.setRegistered(rs.getString("registered"));
				
				arr_Riview.add(selDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
		return arr_Riview;
	}
	
	public ReviewDTO review(int no) {
		ReviewDTO rDto = null;
		
		String sql = "SELECT rtitle, rtext, registered FROM review WHERE no = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				rDto = new ReviewDTO();
				
				rDto.setRtitle(rs.getString("rtitle"));
				rDto.setRtext(rs.getString("rtext"));
				rDto.setRegistered(rs.getString("registered"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
				
		return rDto;
	}
	
	public ArrayList<ReviewDTO> buyList(ReviewDTO bDto) {
		
		ArrayList<ReviewDTO> arr_buy = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "SELECT userid, book FROM user_table WHERE userid = (SELECT DISTINCT userid FROM review WHERE userid = ?)";
//					   + " FROM user_table"
//					   + " WHERE userid = (SELECT userid FROM review WHERE userid = ?)";
			
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, bDto.getUserid());
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ReviewDTO tDto = new ReviewDTO();
				
				tDto.setUserid(rs.getString("userid"));
				tDto.setRbook(rs.getString("book"));
				
				arr_buy.add(tDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
		return arr_buy;
	}
	
}
