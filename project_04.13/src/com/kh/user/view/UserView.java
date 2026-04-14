package com.kh.user.view;

import java.util.List;
import java.util.Scanner;

import com.kh.user.controller.UserController;
import com.kh.user.model.dto.UserDto;

public class UserView {
	private Scanner sc = new Scanner(System.in);
	private UserController userController = new UserController();

	public void mainMenu() {
		
		while(true) {
			System.out.println("--- 유저 관리 프로그램 ---");
			System.out.println("1. 유저 추가하기");
			System.out.println("2. 유저 전체조회하기");
			System.out.println("3. 유저 정보변경하기");
			System.out.println("4. 유저 삭제하기");
			System.out.println("5. 유저 아이디로 검색하기");
			System.out.println("6. 유저 이름 키워드로 검색하기");
			System.out.println("9. 프로그램 종료하기");
			System.out.println("메뉴를 선택해주세요 > ");
			String menu = sc.nextLine();
			
			switch (menu) {
			case "1" : save(); break;
			case "2" : findAll(); break;
			case "3" : update(); break;
			case "4" : delete(); break;
			case "5" : findById(); break;
			case "6" : findByKeyword(); break;
			case "9" : sc.close(); return;
			default : System.out.println("없는 메뉴입니다.");
			}
		}
	}

	private void save() {
		System.out.println("유저 추가하기");
		System.out.println("유저 이름을 입력하세요 > ");
		String userName = sc.nextLine();
		System.out.println("유저 아이디을 입력하세요 > ");
		String userId = sc.nextLine();
		System.out.println("유저 비밀번호을 입력하세요 > ");
		String userPwd = sc.nextLine();
		System.out.println("첫가입일을 입력하세요 > ");
		String firstDate = sc.nextLine();
		
		int result = userController.save(userName, userId, userPwd, firstDate);
		
		if(result > 0) {
			System.out.println("유저 추가에 성공했습니다.");
		}else {
			System.out.println("유저 추가에 실패했습니다.");
		}
	}		
	
	private void findAll() {
		System.out.println("\n유저 전체 조회하기");
		
		List<UserDto> list = userController.findAll();
		
		System.out.println("\n조회된 유저 수는 총 " + list.size() + "개 입니다.");
		if(list.isEmpty()) {
			System.out.println("조회결과가 존재하지 않습니다.");
		}else {
			
			for(UserDto sd : list) {
				System.out.println("=============================");
				System.out.print("번호 : " + sd.getUserId() + ", ");
				System.out.print("종이름 : " + sd.getUserName() + ", ");
				System.out.print("종분류 : " + sd.getUser());
				System.out.println();
			}
		}
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
