package com.kh.member.model.service;

import java.sql.Connection;

import com.kh.keeper.common.JdbcTemplate;
import com.kh.member.exception.MemberldToLargeException;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.dto.MemberDto;

public class MemberService {

	public boolean idCheck(String memberId) {
		Connection conn = JdbcTemplate.getConnection();
		boolean result = new MemberDao().idCheck(conn, memberId);
		JdbcTemplate.close(conn);
		return result;
		
		
	}

	public void signUp(MemberDto member) {
		
		// verynicekhmember202604141626hahahohohehehihi
		// 길이체크 정도?
		if(member.getMemberId().length() > 30) {
			throw new MemberldToLargeException("아이디가 너무 길어요");
		}
		  
		
	}

}
