package com.kh.delivery.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.delivery.common.Template;
import com.kh.delivery.model.dao.RestaurantDao;
import com.kh.delivery.model.dto.Restaurant;

public class RestaurantService {
	public List<Restaurant> findAllRest() {
		SqlSession session = Template.getSqlSession();
		
		List<Restaurant> rests = new RestaurantDao().findAllRest(session);
		
		session.close();
		
		return rests;
	}
}
