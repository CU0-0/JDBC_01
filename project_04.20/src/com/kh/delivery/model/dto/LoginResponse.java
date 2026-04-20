package com.kh.delivery.model.dto;

public class LoginResponse {

	
	private String memberId;
	private String memberName;
	public LoginResponse() {
		super();
	}
	public LoginResponse(String memberId, String memberName) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	@Override
	public String toString() {
		return "LoginResponse [memberId=" + memberId + ", memberName=" + memberName + "]";
	}
		
		
	


}
