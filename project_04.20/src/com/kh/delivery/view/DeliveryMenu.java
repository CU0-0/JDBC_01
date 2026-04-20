package com.kh.delivery.view;

import java.util.List;
import java.util.Scanner;

import com.kh.delivery.controller.RestaurantController;
import com.kh.delivery.model.dto.Restaurant;

public class DeliveryMenu {
	
	private Scanner sc = new Scanner(System.in);
	private RestaurantController mc = new RestaurantController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("주문 시스템에 오신걸 환영합니다");
			System.out.println("1. 전체 가계 목록");
			System.out.println("2. 가계 목록 상세 보기");
			System.out.println("3. 카테고리 별 검색");
			System.out.println("4. 로그인 화면");
			System.out.println("9. 프로그램 종료");
			String menu = sc.nextLine();
			
			switch(menu) {
			case "1" : findAllRest(); break;
			case "2" :  break;
			case "3" :  break;
			case "4" :  break;
			case "9" : sc.close(); return;
			
			}
		}
	}

	private void findAllRest() {
		System.out.println("가계 전체 조회 서비스입니다.");
		List<Restaurant> rests = mc.findAllRest();
		
		if(rests.isEmpty()) {
			System.out.println("조회 결과가 존재하지 않습니다.");
		}else {
			for(Restaurant rest : rests) {
				System.out.println("가계번호 : " + rest.getRestNo()
								+", 가계이름 : " + rest.getRestName( )
								+", 카테고리 : " + rest.getCategory()
								+", 최소주문 : " + rest.getMinPrice()
								+", 배달비 : " + rest.getDeliveryFee()	);
			}
		}
	}

	
	
	
	
	
	
	
}
