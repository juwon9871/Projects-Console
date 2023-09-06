// DTO는 저장소. 값을 가져오기도하고 저장된 값을 보내주기도 한다. 
// 검문소? 보안을 하기에 보낼 애들을 검문해서 밖으로 보내준다. 
// 보안,은닉화 하기위해 쓴다.

package com.daissso.admin;

public class bookManageDTO {

	private String pno; 		//책번호
	private String pname;		//책이름
	private String price;		//가격
	private String publish;		//출판사
	private String category;	//카테고리
	
	public bookManageDTO() {
		
	}
	
	//using Fields
	public bookManageDTO(String pno, String pname, String price, String publish, String category) {
		super();
		this.pno = pno;
		this.pname = pname;
		this.price = price;
		this.publish = publish;
		this.category = category;
	}


	//Getters and Setters
	public String getPno() {
		return pno;
	}

	public void setPno(String pno) { // set:받아오는것 (dto 기준)
		this.pno = pno;
	}

	public String getPname() { //get : 보내주는것 . 보내줬으니  return값 존재(dto기준)
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	//toString()
	@Override
	public String toString() {
		return "adminDTO [pno=" + pno + ", pname=" + pname + ", price=" + price + ", publish=" + publish + ", category="
				+ category + "]";
	}
	
	
	
	
	

}
