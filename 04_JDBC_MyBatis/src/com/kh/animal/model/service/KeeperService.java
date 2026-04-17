package com.kh.animal.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.animal.common.Template;
import com.kh.animal.model.dao.KeeperDao;
import com.kh.animal.model.dto.KeeperDto;

public class KeeperService {
	
	// 시간!
	// 쿼리 실행시간 0.1ms
	// +
	// 네트워크 왕복(Round Trip) / 자바서버 / DB서버
	//								->
	//								<-
	//						0.5 ~ 2ms -> 수십ms
	// +
	// SQL파싱 + 실행계획 수립 -> DB가 SQL받아서 분석하는 비용
	// +
	// 커넥션 점유 -> 쿼리가 전부 끝날때까지 커넥션을 계속 붙잡고있어야함
	
	// 시나리오 : 사육사가 100명 정도
	// 한번에 사육사 + 사육사 담당 동물목록 조회 => DB커넥션 풀 20개
	
	public List<KeeperDto> selectKeeperAndAnimals() {
		SqlSession session = Template.getSqlSession();
		/*
		// 쿼리 1번 - 사육사 전체조회
		List<KeeperDto> keepers = new KeeperDao().selectKeeperList(session);
		
		// 쿼리 N번 - 각 사육사마다 동물 목록 조회
		for(KeeperDto keeper : keepers) {
			List<AnimalDto> animals =
					new KeeperDao().selectAnimalList(session, keeper.getKeeperId());
			keeper.setAnimals(animals);
		}
		*/
		List<KeeperDto> keepers = new KeeperDao().findKeeperAndAnimals(session);
		session.close();
		
		return keepers;
	}

	public void abc() {
		// 해야할 일

		// SELECT
		// 1번 Conneciton및 PreparedStatement역할을 수행하는 SqlSession을 받아오기
		// 2번 Controller에서 전달받은 값 + session객체 DAO로 전달하고 결과 받아오기
		// 3번 자원반납
		// 4번 결과 반환
		
		// DML
		// 1번 Connection및 PreparedStatement역할 수행하는 Sqlsession을 받아오기
		// 2번 Controller에서 전달받은 값 + session객체 DAO로 전달하고 결과 받아오기
		// 3번 트랜잭션처리
		// 4번 자원반납
		// 5번 결과반환
	}

	public List<KeeperDto> selectKeeperByCondition(Map<String, String> arguments) {
		SqlSession session = Template.getSqlSession();
		
		List<KeeperDto> keepers = new KeeperDao().selectKeeperByCondition(session, arguments);
		
		session.close();

		return keepers;
	}
	
	
	
	
	
	
	
}
