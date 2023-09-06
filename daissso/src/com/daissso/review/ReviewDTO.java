package com.daissso.review;

public class ReviewDTO {
	int no;
	String userid;
	String rbook;
	String rtitle;
	String rtext;
	String registered;
	
	public ReviewDTO() {
	}
	
	public ReviewDTO(String userid) {
		super();
		this.userid = userid;
	}

	public ReviewDTO(int no, String userid, String rbook, String rtitle, String rtext, String registered) {
		super();
		this.no = no;
		this.userid = userid;
		this.rbook = rbook;
		this.rtitle = rtitle;
		this.rtext = rtext;
		this.registered = registered;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRbook() {
		return rbook;
	}

	public void setRbook(String rbook) {
		this.rbook = rbook;
	}

	public String getRtitle() {
		return rtitle;
	}

	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}

	public String getRtext() {
		return rtext;
	}

	public void setRtext(String rtext) {
		this.rtext = rtext;
	}

	public String getRegistered() {
		return registered;
	}

	public void setRegistered(String registered) {
		this.registered = registered;
	}

	@Override
	public String toString() {
		return "ReviewDTO [no=" + no + ", userid=" + userid + ", rbook=" + rbook + ", rtitle=" + rtitle + ", rtext="
				+ rtext + ", registered=" + registered + "]";
	}

	
}