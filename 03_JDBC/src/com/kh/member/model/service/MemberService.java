package com.kh.member.model.service;

import java.sql.Connection;
import java.util.List;

import static com.kh.keeper.common.JdbcTemplate.*;
import com.kh.member.exception.DuplicateMemberldException;
import com.kh.member.exception.MemberldToLargeException;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.dto.BoardDto;
import com.kh.member.model.dto.LoginResponse;
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

	public LoginResponse login(MemberDto member) {
		
		Connection conn = getConnection();
		// 1. INSERT를 먼저하고 SELECT를한다.
		// 2. SELECT를 먼저하고,INSERT를 한다.
		
		// int result = new MemberDao().insertCheck(conn, member);
		/*
		LoginResponse lr = new MemberDao().login(conn, member);
		if(lr != null) {
			new MemberDao();
		}
		*/
		
		LoginResponse lr = new MemberDao().login(conn, member);
		// 로그인 성공시 lr => memberId, memberName필드에 값이 있는 객체의 주소값
		// 로그인 실패시 lr => null
		if(lr != null) {
			int result = new MemberDao().loginCheck(conn, member.getMemberId());
			if(result > 0) {
				commit(conn);
			}
		}
		close(conn);
		return lr;
	}

	public int selectInsertCount(String memberId) {
		Connection conn = getConnection();
		
		int result = new MemberDao().selectInsertCount(conn, memberId);
		
		close(conn);
		
		return result;
	}

	public int insertBoard(BoardDto board) {
		Connection conn = getConnection();
		
		int result = new MemberDao().insertBoard(conn, board);
		
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		
		return result;
		
	}

	public List<BoardDto> selectBoardList() {
		Connection conn = getConnection();
		List<BoardDto> boards = new MemberDao().selectBoardList(conn);
		close(conn);
		return boards;
		
		
		
	}

	public BoardDto selectBoard(String boardNo) {
		Connection conn = getConnection();
		BoardDto board = new MemberDao()
							.selectBoard(conn, Integer.parseInt(boardNo));
		close(conn);
		return board;
		
	}

	
	
	
	
	
	
	
	
	
}
