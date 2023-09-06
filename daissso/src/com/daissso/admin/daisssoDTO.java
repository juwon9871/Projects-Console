package com.daissso.admin;

public class daisssoDTO {

	private String id;
	private String pwd;
	private String name;
	//여기까지 만들고 밑에는 다 자동완성	
	
	
	public daisssoDTO() {
		
	}
	
	
	//using Fields
	public daisssoDTO(String id, String pwd, String name) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}


	
	
	//Getters and Setters
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	
	//toString()
	@Override
	public String toString() {
		return "daisssoDTO [id=" + id + ", pwd=" + pwd + ", name=" + name + "]";
	}
		

	
}
