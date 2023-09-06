package com.blinddate.event;

import java.util.Scanner;

public class Coupon {
	public Coupon() {
		// TODO admin 계정을 동적으로 받는 처리 불러오기
		String couponNo = null;
		String couponDate = null;
		int couponDiscount = 0;
		int result = 0;

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("1.쿠폰 등록 2.돌아가기 ");
			System.out.println("=========================");
			int inputNum = sc.nextInt();

			if (inputNum == 1) {
				while(true) {
					System.out.println("쿠폰을 등록 하시겠습니까? y/n");
					String check = sc.nextLine();
					
					if(check.equals("y")) {
						while (true) {
							System.out.println("쿠폰번호를 등록하세요: ");
							System.out.println("");
							couponNo = sc.nextLine();

							if (couponNo.equals("")) {
								continue;
							} else {
								break;
							}
						}
						while (true) {
							System.out.println("쿠폰사용기한을 등록하세요 :");
							couponDate = sc.nextLine();

							if (couponDate.equals("")) {
								continue;
							} else {
								break;
							}
						}
						while (true) {
							System.out.println("쿠폰 할인률을 등록하세요 :");
							couponDiscount = sc.nextInt();

							if (couponDiscount == 0) {
								continue;
							} else {
								break;
							}
						}

						if (!couponNo.equals("") && !couponDate.equals("") && couponDiscount != 0) {
							CouponDTO cDto = new CouponDTO(couponNo, couponDate, couponDiscount);
							CouponDAO cDao = new CouponDAO();

							result = cDao.insertCoupon(cDto);
							if (result > 0) {
								System.out.println();
								System.out.println("정상 등록 되었습니다.");
								System.out.println();
							} else {
								System.out.println();
								System.out.println("등록이 실패했습니다.");
								System.out.println();

							}

						}
						break;
					}else if(check.equals("n")) {
						break;
					}else {
						continue;
					}
				}
				

			} else if(inputNum==2) {
				break;
			}else {
				continue;
			}

		}

	}

}
