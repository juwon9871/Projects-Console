package com.daissso.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@ 172.30.1.75:1521:xe";
			Connection con = DriverManager.getConnection(url, "scott", "1234");
			System.out.println("접속 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
