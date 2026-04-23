package com.kh.delivery.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.model.dto.Restaurant;

public class RestaurantDao {
	private Properties prop = new Properties();
	public List<Restaurant> findAllRest(SqlSession session) {
		return session.selectList("restaurantMapper.findAllRest");
	}

	public Restaurant selectRest(Connection conn, int restNo) {
		Restaurant rest = null;
		try(PreparedStatement pstmt
				= conn.prepareStatement(prop.getProperty("selectRest"))){
			pstmt.setInt(1,  restNo);
			try(ResultSet rset = pstmt.executeQuery()){
				if(rset.next()) {
					rest = new Restaurant(rset.getInt("REST_NO"),
										rset.getString("REST_NAME"),
										rset.getString("CATEGORY"),
										rset.getString("MIN_PRICE"),
										rset.getString("DELIVERY_FEE")); 
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return rest;
	}

}
