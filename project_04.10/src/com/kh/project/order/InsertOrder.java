package com.kh.project.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertOrder {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("ORDER_NO를 입력해주세요 > ");
		String orderNo = sc.nextLine();
		System.out.println("ORDER_DATE을 입력해주세요 > ");
		String orderDate = sc.nextLine();
		System.out.println("ADDRESS을 입력해주세요 > ");
		String address = sc.nextLine();
		System.out.println("USER_NO을 입력해주세요 > ");
		String userNo = sc.nextLine();
		System.out.println("PRODUCT_NO을 입력해주세요 > ");
		String productNo = sc.nextLine();
		
		String sql = "INSERT INTO ORDER VALUES('테스트', SYSDATE, '테스트', '테스트', '테스트')";
		
		sql = "INSERT INTO ORDER VALUES('" + orderNo + "',"
								   + "'"  + orderDate + "',"
								   + "'"  + address + "',"
								   + "'"  + userNo + "',"
								   + "'"  + productNo + "')";
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO \"ORDER\" VALUES(");
		sb.append("'" + orderNo + "',");
		sb.append("SYSDATE,");
		sb.append("'" + address + "',");
		sb.append("'" + userNo + "',");
		sb.append("'" + productNo + "')");
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
