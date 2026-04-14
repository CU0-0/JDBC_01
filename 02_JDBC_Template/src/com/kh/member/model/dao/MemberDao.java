package com.kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {

	public boolean idCheck(Connection conn, String memberId) {
		String sql = """
						SELECT
							COUNT(*)
						FROM
							JDBC_MEMBER
						WHERE
							MEMBER_ID = ?
					""";
		try(PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1,  memberId);
			ResultSet rset = pstmt.executeQuery();
			rset.next();
			return rset.getInt("COUNT(*)") > 0 ? true : false;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
