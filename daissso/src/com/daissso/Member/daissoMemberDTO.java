package com.daissso.Member;

public class daissoMemberDTO {
	private String userId;
	private String userPwd;
	private String userName;
	
	public daissoMemberDTO() {

	}
	
	public daissoMemberDTO(String userId, String userPwd) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
	}

	public daissoMemberDTO(String userId, String userPwd, String userName) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "daissoMemberDTO [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + "]";
	}
	
	
}
