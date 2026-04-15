package com.kh.member.model.service;

import java.sql.Connection;

import static com.kh.keeper.common.JdbcTemplate.*;
import com.kh.member.exception.DuplicateMemberldException;
import com.kh.member.exception.MemberldToLargeException;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.dto.MemberDto;

public class MemberService {

	public boolean idCheck(String memberId) {
		Connection conn = getConnection();
		boolean result = new MemberDao().idCheck(conn, memberId);
		close(conn);
		return result;
	}

	public int signUp(MemberDto member) {
		// verynicekhmember202604141626hahahohohehehihi
		// 길이체크 정도?
		if(member.getMemberId().length() > 30) {
			throw new MemberldToLargeException("아이디가 너무 길어요");
		}
		
		// 모든 검사를 다 넘어갔다고 가정
		Connection conn = getConnection();
		
		MemberDao md = new MemberDao();
		if(md.idCheck(conn, member.getMemberId())){
			throw new DuplicateMemberldException("중복 아이디입니다");
		}
		int result = md.signUp(conn, member);
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		
		return result;
	}

}
