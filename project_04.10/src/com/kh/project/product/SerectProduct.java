package com.kh.project.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SerectProduct {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = """
				SELECT
					   PRODUCT_NO
					 , PRODUCT_NAME
					 , PRODUCT_PRICE
					 , PRODUCT_DATE
				  FROM
					   \"product\"
				 ORDER
				    BY
					   PRODUCT_NO DESC
				""";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", 
												"C##SU", 
												"SU");
			System.out.println("연결성공!");
			
			stmt = conn.createStatement();
			System.out.println("a");
			
			rset = stmt.executeQuery(sql);
			System.out.println("b");
			
			while(rset.next()) {
				String productNo = rset.getString("PRODUCT_NO");
				String productName = rset.getString("PRODUCT_NAME");
				String productPrice = rset.getString("PRODUCT_PRICE");
				String productDate = rset.getString("PRODUCT_DATE");
				
				System.out.println("상품번호 : " + productNo
						+ ", 상품명 : " + productName
						+ ", 가격 : " + productPrice
						+ ", 등록일 : " + productDate);
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset != null && !rset.isClosed()) {
					rset.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}

	}

}
