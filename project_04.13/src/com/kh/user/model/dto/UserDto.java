package com.kh.user.model.dto;

public class UserDto {
	private String userNo;
	private String userName;
	private String userId;
	private String userPwd;
	private String firstDate;
	public UserDto() {
		super();
	}
	public UserDto(String userName, String userId, String userPwd, String firstDate) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userPwd = userPwd;
		this.firstDate = firstDate;
	}
	public UserDto(String userNo, String userName, String userId, String userPwd, String firstDate) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.userId = userId;
		this.userPwd = userPwd;
		this.firstDate = firstDate;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getFirstDate() {
		return firstDate;
	}
	public void setFirstDate(String firstDate) {
		this.firstDate = firstDate;
	}
	@Override
	public String toString() {
		return "UserDto [userNo=" + userNo + ", userName=" + userName + ", userId=" + userId + ", userPwd=" + userPwd
				+ ", firstDate=" + firstDate + "]";
	}
	
	
}
