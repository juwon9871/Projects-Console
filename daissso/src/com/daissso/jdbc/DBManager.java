package com.daissso.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBManager {

	// 인스턴스 주소를 저장하기 위한 참조 변수
		private static Connection con;

		// Connction 관련 정보 상수
		private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
		private static final String URL = "jdbc:oracle:thin:@ 172.30.1.75:1521:xe";
		private static final String USER = "scott";
		private static final String PASS = "1234";

		// 생성자
		// 은닉화(private 걸어서)
		private DBManager() {

		}

		public static Connection getConnection() {
			con = null;
			if (con == null) {
				try {
					Class.forName(DRIVER);
					con = DriverManager.getConnection(URL, USER, PASS);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return con;
		}

		// select를 수행한 후 리소스 해제를 위한 메서드
		public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
			try {
				if (rs != null) {
					try {
						rs.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// insert, update, delete를 수행한 후 리소스 해제를 위한 메서드
		public static void close(Connection con, PreparedStatement pstmt) {
			try {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				if (con != null) {
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
}
