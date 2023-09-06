package com.daissso.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnect {
	private static Connection con;
	private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String URL = "jdbc:oracle:thin:@ 172.30.1.75:1521:xe";
	private final static String USER = "scott";
	private final static String PASSWORD = "1234";
	
	
private DBConnect() {
		
	}
	
	public static Connection getConnection() {
		con = null;
		
		// 프로그램을 실행할때 첫생성만 해주는 로직?
				if (con == null) {
					try {
						Class.forName(DRIVER);
						con = DriverManager.getConnection(URL, USER, PASSWORD);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				return con;
	}
	
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
					pstmt.clearBatch();
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
	
	// INSERT UPDATE DELETE를 수행 후 리소스 해제
	public static void close(Connection con, PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				try {
					pstmt.clearBatch();
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
