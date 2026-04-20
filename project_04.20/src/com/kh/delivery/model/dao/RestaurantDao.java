package com.kh.delivery.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.model.dto.Restaurant;

public class RestaurantDao {

	public List<Restaurant> findAllRest(SqlSession session) {
		return session.selectList("restaurantMapper.findAllRest");
	}

}
