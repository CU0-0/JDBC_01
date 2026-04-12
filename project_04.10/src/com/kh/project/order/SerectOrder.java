package com.kh.project.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SerectOrder {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = """
				SELECT
					   ORDER_NO
					 , ORDER_DATE
					 , ADDRESS
					 , USER_NO
					 , PRODUCT_NO
				  FROM
					   \"ORDER\"
				 ORDER
				    BY
					   ORDER_NO DESC
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
				String orderNo = rset.getString("ORDER_NO");
				String orderDate = rset.getString("ORDER_DATE");
				String address = rset.getString("ADDRESS");
				String userNo = rset.getString("USER_NO");
				String productNo = rset.getString("PRODUCT_NO");
				
				System.out.println("주문번호 : " + orderNo
						+ ", 주문날짜 : " + orderDate
						+ ", 주소 : " + address
						+ ", 유저번호 : " + userNo
						+ ", 상품번호 : " + productNo);
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
