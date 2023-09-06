package com.daissso.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.daissso.DBConnection.DBConnect;




public class daisssoDAO {
	
	public int insertMember(daisssoDTO dDto) {
		
		int result  = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into daissoMember_pr values(?,?,?)";
		
		try {
			conn = DBConnect.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dDto.getId());
			pstmt.setString(2, dDto.getPwd());
			pstmt.setString(3, dDto.getName());
			
			result = pstmt.executeUpdate(); 
			// executeUpdate =>여기 써놓은 쿼리문을 db에서 실행해주는 명령어 . 얘가 정상 실행되면1 아니면0
			// result에 저장하는 이유. 쿼리문의 실행 결과를 확인하기위해서
			
			if(result >0) {
				System.out.println("등록성공");
				
				
				
			}else {
				System.out.println("등록실패");
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnect.close(conn, pstmt);
		}
		return result;
	}

	
	
	
	
	
}
