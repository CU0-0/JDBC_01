package com.kh.project.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertProduct {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("PRODUCT_NO를 입력해주세요 > ");
		String productNo = sc.nextLine();
		System.out.println("PRODUCT_NAME을 입력해주세요 > ");
		String productName = sc.nextLine();
		System.out.println("PRODUCT_PRICE을 입력해주세요 > ");
		String productPrice = sc.nextLine();
		System.out.println("PRODUCT_DATE을 입력해주세요 > ");
		String productDate = sc.nextLine();
		
		String sql = "INSERT INTO product VALUES('테스트', '테스트', '테스트', SYSDATE)";
		
		sql = "INSERT INTO product VALUES('" + productNo + "',"
								   + "'"  + productName + "',"
								   + "'"  + productPrice + "',"
								   + "'"  + productDate + "')";
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO \"product\" VALUES(");
		sb.append("'" + productNo + "',");
		sb.append("'" + productName + "',");
		sb.append("'" + productPrice + "',");
		sb.append("SYSDATE)");
		sql = sb.toString();
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 등록!");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", 
							"C##SU", 
							"SU");
			System.out.println("연결성공!");
			
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			System.out.println("a");
			
			result = stmt.executeUpdate(sql);
			System.out.println("b");
			
			if(result > 0) {
				conn.commit();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
