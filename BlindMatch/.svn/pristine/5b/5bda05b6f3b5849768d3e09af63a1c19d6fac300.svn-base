package com.blinddate.mainInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Singleton 패턴 : 인스턴스를 하나만 만들어서 사용하는 방법

public class DBManager {

	// 인스턴스 주소를 저장하기 위해 참조 변수를 하나 만들기
	private static Connection conn;

	// Connection 관련 정보 상수. 여기서만 사용할 수 있게
	private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String URL = "jdbc:oracle:thin:@172.30.1.29:1521:xe";
	private final static String USER = "BlindMatch";
	private final static String PASS = "qkrdudwls486";

	// 생성자 만들기
	// 은닉화
	private DBManager() {

	}

	public static Connection getconnection() {
		conn = null;
		if (conn == null) {
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USER, PASS);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;

	}

	// select를 수행한 후 리소스 해제를 위한 메서드
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();

				}
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	// insert, update, delete를 수행한 후 해제를 위한 메서드
	public static void close(Connection conn, PreparedStatement pstmt) {

	}
}
