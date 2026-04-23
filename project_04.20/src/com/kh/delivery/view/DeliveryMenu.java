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
			case "2" : selectRest(); break;
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
								+", 최소주문금액 : " + rest.getMinPrice()
								+", 배달비 : " + rest.getDeliveryFee()	);
			}
		}
	}

	private void selectRest() {
		System.out.println("가계 목록 상세보기 서비스 입니다.");
		findAllRest();
		System.out.println("상세보기를 원하시는 가계번호를"
				+ " 입력해주세요 > ");
		String restNo = sc.nextLine();
		Restaurant rest = mc.selectRest(restNo);
		
		if(rest != null) {
			System.out.println("가게 번호" + rest.getRestNo());
			System.out.println("---------------------------------");
			System.out.println("가계이름 : "+ rest.getRestName());
			System.out.println("=================================");
			System.out.println("카테고리 : " + rest.getCategory());
			System.out.println("---------------------------------");
			System.out.println("최소주문금액 : " + rest.getMinPrice());
			System.out.println("---------------------------------");
			System.out.println("배달비 : " + rest.getDeliveryFee());
			System.out.println("=================================");
		}else {
			System.out.println("존재하지 않는 가계 번호입니다");
		}
		
	}
	
	
	
	
	
	
	
}
