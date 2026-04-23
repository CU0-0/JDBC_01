package com.kh.delivery.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	public static SqlSession getSqlSession() {
		
		SqlSession sqlSession = null;
		
		String config = "mybatis-config.xml";
		
		try {
			InputStream stream = Resources.getResourceAsStream(config);
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSession;
	}
	public static Connection getConnection() {
		
		try {
			Properties prop = new Properties();
			
			prop.load(new FileInputStream("resources/connection.properties"));
			
			Connection conn =
			DriverManager.getConnection(prop.getProperty("URL")
								   	  , prop.getProperty("USERNAME")
									  , prop.getProperty("PASSWORD"));
		conn.setAutoCommit(false);
		
		return conn;
		
		} catch (SQLException e) {
		e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
