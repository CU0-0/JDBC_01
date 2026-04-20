package com.kh.delivery.model.dto;

import java.sql.Date;

public class DeliMember {
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String address;
	private Date enrollDate;
	
	public DeliMember(String memberId, String memberPw, String memberName) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
	}

	public DeliMember() {
		super();
	}
	
	public DeliMember(int memberNo, String memberId, String memberPw, String memberName, String address,
			Date enrollDate) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.address = address;
		this.enrollDate = enrollDate;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "DeliMember [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw
				+ ", memberName=" + memberName + ", address=" + address + ", enrollDate=" + enrollDate + "]";
	}
	
	
	
}
