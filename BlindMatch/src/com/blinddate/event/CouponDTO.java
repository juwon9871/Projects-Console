package com.blinddate.event;

public class CouponDTO {
	private String couponNo;
	private String couponDate;
	private int couponDiscount;
	
	public CouponDTO() {
		
	}

	public CouponDTO(String couponNo, String couponDate, int couponDiscount) {
		super();
		this.couponNo = couponNo;
		this.couponDate = couponDate;
		this.couponDiscount = couponDiscount;
	}

	public String getCouponNo() {
		return couponNo;
	}

	public void setCouponNo(String couponNo) {
		this.couponNo = couponNo;
	}

	public String getCouponDate() {
		return couponDate;
	}

	public void setCouponDate(String couponDate) {
		this.couponDate = couponDate;
	}

	public int getCouponDiscount() {
		return couponDiscount;
	}

	public void setCouponDiscount(int couponDiscount) {
		this.couponDiscount = couponDiscount;
	}

	@Override
	public String toString() {
		return "CouponDTO [couponNo=" + couponNo + ", couponDate=" + couponDate + ", couponDiscount=" + couponDiscount
				+ "]";
	}
	
}
