package com.kh.delivery.controller;

import java.util.List;

import com.kh.delivery.model.dto.Restaurant;
import com.kh.delivery.model.service.RestaurantService;

public class RestaurantController {
	public List<Restaurant> findAllRest() {
		return new RestaurantService().findAllRest();
	}

	public Restaurant selectRest(String restNo) {
		return new RestaurantService().selectRest(restNo);
	}
}
