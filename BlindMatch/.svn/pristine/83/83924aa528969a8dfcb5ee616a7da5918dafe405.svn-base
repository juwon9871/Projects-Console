package com.blinddate.event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.blinddate.mainInterface.DBManager;
import com.blinddate.matchservice.UserDTO;

public class CouponDAO {

	ArrayList<CouponDTO> couponList = null;

	public int insertCoupon(CouponDTO cDto) {
		int result = 0;
		String sql = "INSERT INTO coupon(couponNo,couponDate,couponDiscount) VALUES(?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getconnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cDto.getCouponNo());
			pstmt.setString(2, cDto.getCouponDate());
			pstmt.setInt(3, cDto.getCouponDiscount());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public UserDTO selCoupon(String date) {
		UserDTO uDto = new UserDTO();
		String sql = "SELECT couponNo, couponDiscount FROM coupon WHERE couponDate = ?";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.getconnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, date);

			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				uDto.setCouponNo(rs.getString("couponNo"));
				uDto.setCouponDiscount(rs.getInt("couponDiscount"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return uDto;
	}

	public int updateCoupon(UserDTO uDto, String id) {
		int result = 0;
		String sql = "UPDATE usertable set couponNo =?, couponDiscount=? WHERE id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = DBManager.getconnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, uDto.getCouponNo());
			pstmt.setInt(2, uDto.getCouponDiscount());
			pstmt.setString(3, id);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);

		}
		return result;
	}
	
}
