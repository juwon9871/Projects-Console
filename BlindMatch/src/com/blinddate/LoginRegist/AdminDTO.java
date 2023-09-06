package com.blinddate.LoginRegist;

public class AdminDTO {
	private String adminId;
	private String adminPwd;
	private String phoneNum;
	private String auth;
	private String name;
	private String gender;
	
	public AdminDTO() {
		
	}
	
	public AdminDTO(String adminId, String adminPwd, String phoneNum, String auth, String name, String gender) {
		super();
		this.adminId = adminId;
		this.adminPwd = adminPwd;
		this.phoneNum = phoneNum;
		this.auth = auth;
		this.name = name;
		this.gender = gender;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "AdminDTO [adminId=" + adminId + ", adminPwd=" + adminPwd + ", phoneNum=" + phoneNum + ", auth=" + auth
				+ ", name=" + name + ", gender=" + gender + "]";
	}
	
	

}