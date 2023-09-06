package com.blinddate.LoginRegist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.blinddate.mainInterface.DBManager;

public class AdminDAO {

	ArrayList<AdminDTO> adminList = null;

	public int insertAdmin(AdminDTO aDto) {
		int result = 0;

		String sql = "INSERT INTO userTable(ID,PWD,name,phonenum,auth,gender) VALUES(?,?,?,?,'admin',?)";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBManager.getconnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, aDto.getAdminId());
			pstmt.setString(2, aDto.getAdminPwd());
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

	public int adminCheck(String adminId, String adminPwd) {
		String sql = "SELECT pwd " + "FROM usertable " + "WHERE id = ?";

		int result = -1;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getconnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminId);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 0;
				String dbPwd = rs.getString("pwd");

				if (dbPwd.equals(adminPwd)) {
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

	public ArrayList<AdminDTO> selAllAdmin() {
		adminList = new ArrayList<>();

		String sql = "SELECT * " + "FROM usertable WHERE auth='admin'";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getconnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				AdminDTO mDto = new AdminDTO();
				mDto.setAdminId(rs.getString("ID"));
				mDto.setAdminPwd(rs.getString("pwd"));
				mDto.setPhoneNum(rs.getString("phoneNum"));

				adminList.add(mDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return adminList;
	}

}