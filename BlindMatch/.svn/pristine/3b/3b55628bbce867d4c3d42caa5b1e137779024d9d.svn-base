package com.blinddate.payment;

import java.util.Scanner;

public class Payment {
	public Payment() {
		String name = null; // 사용자이름
		String id = null; // 사용자ID
		String pwd = null; // 사용자PW
		int pay = 20000; // 1회권 가격
		int monthlyPay = 100000; // 구독권 가격

		PaymentDAO pDao = new PaymentDAO();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println(
		               "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━♥ 결제 ♥━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ");
		         System.out.println("♡                                                                ♡");
		         System.out.println("♡                                                                ♡");
		         System.out.println("♡     1. 이용권 구매하기     2.해지     3.청약철회     4.메뉴로 돌아가기     ♡");
		         System.out.println("♡                                                                ♡");
		         System.out.println("♡                                                                ♡");
		         System.out.println("♡-♡-♡-♡-♡-♡-♡-♡-♡-♡-♡ 원하시는 기능의 번호를 입력하세요 ♡-♡-♡-♡-♡-♡-♡-♡-♡-♡-♡");
			int inputNum = sc.nextInt();

			if (inputNum == 1) {
				int result = 0;

				 System.out.println(
		                  "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━♥ 결제 ♥━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ");
		            System.out.println("♡              이용권 구매 페이지입니다             ♡");
		            System.out.println(" ♡                                            ♡");
		            System.out.println("♡             1. 구독권   2. 일회권              ♡");
		            System.out.println(" ♡                                            ♡");
		            System.out.println("♡-♡-♡-♡-♡-♡ 원하시는 기능의 번호를 입력하세요 ♡-♡-♡-♡-♡-♡");

				int inputMenuNum = sc.nextInt();
				sc.nextLine();

				if (inputMenuNum == 1) {
					System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━♥ 결제 ♥━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			        System.out.println("♡               구독형 구매페이지입니다             ♡");
			        System.out.println(" ♡                                            ♡");
					pDao.accountNotice();
					System.out.println(" ♡              1개월 구독형 :" + monthlyPay + "             ♡");
					while (true) {
				        System.out.print("♡                 ID를 입력해주세요               ♡");
						id = sc.nextLine();
						if (id.equals("")) {
							continue;
						} else {
							break;
						}
					}

					while (true) {
				        System.out.print(" ♡               비밀번호를 입력해주세요             ♡");
						pwd = sc.nextLine();
						if (pwd.equals("")) {
							continue;
						} else {
							break;
						}
					}

					while (true) {
				        System.out.print("♡                이름를 입력해주세요               ♡");

						name = sc.nextLine();
			            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━♥ 결제 ♥━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			            System.out.println();
			            System.out.println();
						if (name.equals("")) {
							continue;
						} else {
							break;
						}
					}
					if (!id.equals("") && !pwd.equals("") && !name.equals("")) {
						PaymentDTO pDto = new PaymentDTO();
						pDto.getId();
						pDto.getPwd();
						pDto.getName();
						result = pDao.userCheck(id, pwd);

						if (result == -1) {
							System.out.println("");
							System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━♥ 존재하지 않는 ID 입니다 ♥━━━━━━━━━━━━━━━━━━━━━━━━");
							System.out.println("");
							continue;
						}

						if (result == 0) {

							System.out.println();
							System.out.println("━━━━━━━━━━━━━━━━━━━━━━♥ 비밀번호가 일치하지 않습니다 ♥━━━━━━━━━━━━━━━━━━━━━━");
							System.out.println();
							continue;
						}
						pDao.insertPaymentCheck(id, pwd, name);
						try {
							int haveCoupon = pDao.discountCoupon(id, pwd);
							if (haveCoupon != 0) {
								System.out.println("    ━━━━━━━━━━━━━━━━━━━━━━♥        쿠폰을 적용 시키시겠습니까?      ♥━━━━━━━━━━━━━━━━━━━━━━");
								System.out.println();
								System.out.println("    ━━━━━━━━━━━━━━━━━━━━━━♥         1. 사용  2. 미사용          ♥━━━━━━━━━━━━━━━━━━━━━━");
								int inputNumCoupon = sc.nextInt();
								if (inputNumCoupon == 1) {
									System.out.println("    ━━━━━━━━━━━━━━━━━━━━━━♥     결제 금액은 " +(  monthlyPay
											*  ((float)(100 - haveCoupon) / 100)) + "           ♥━━━━━━━━━━━━━━━━━━━━━━");
								} else {
									System.out.println("    ━━━━━━━━━━━━━━━━━━━━━━♥        결제 금액은 " + monthlyPay + "        ♥━━━━━━━━━━━━━━━━━━━━━━");
								}
							}
							
						} catch (Exception e) {
e.printStackTrace();						}
						pDao.insertPayment(id, pwd, name);
					}
				}

					if (inputMenuNum == 2) {
						System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━♥ 결제 ♥━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
				        System.out.println("♡               일회권 구매페이지입니다             ♡");
				        System.out.println(" ♡                                            ♡");
						pDao.accountNotice();
						System.out.println(" ♡              일회권 구매형 :" + pay + "             ♡");
						while (true) {
					        System.out.print("♡                 ID를 입력해주세요               ♡");
							id = sc.nextLine();
							if (id.equals("")) {
								continue;
							} else {
								break;
							}
						}

						while (true) {
					        System.out.print(" ♡               비밀번호를 입력해주세요             ♡");
							pwd = sc.nextLine();
							if (pwd.equals("")) {
								continue;
							} else {
								break;
							}
						}

						while (true) {
					        System.out.print("♡                이름를 입력해주세요               ♡");

							name = sc.nextLine();
				            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━♥ 결제 ♥━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
				            System.out.println();
				            System.out.println();
							if (name.equals("")) {
								continue;
							} else {
								break;
							}
						}
						if (!id.equals("") && !pwd.equals("") && !name.equals("")) {
							PaymentDTO pDto = new PaymentDTO();
							pDto.getId();
							pDto.getPwd();
							pDto.getName();
							result = pDao.userCheck(id, pwd);

							if (result == -1) {
								System.out.println("");
								System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━♥ 존재하지 않는 ID 입니다 ♥━━━━━━━━━━━━━━━━━━━━━━━━");
								System.out.println("");
								continue;
							}

							if (result == 0) {

								System.out.println();
								System.out.println("━━━━━━━━━━━━━━━━━━━━━━♥ 비밀번호가 일치하지 않습니다 ♥━━━━━━━━━━━━━━━━━━━━━━");
								System.out.println();
								continue;
							}
							pDao.insertPaymentCheck(id, pwd, name);
							
							int haveCoupon = pDao.discountCoupon(id, pwd);

							if (haveCoupon != 0) {
								System.out.println("    ━━━━━━━━━━━━━━━━━━━━━━♥ 쿠폰을 적용 시키시겠습니까?        ♥━━━━━━━━━━━━━━━━━━━━━━");
								System.out.println();
								System.out.println("    ━━━━━━━━━━━━━━━━━━━━━━♥   1. 사용  2. 미사용           ♥━━━━━━━━━━━━━━━━━━━━━━");
								int inputNumCoupon = sc.nextInt();
								if (inputNumCoupon == 1) {


									System.out.println("    ━━━━━━━━━━━━━━━━━━━━━━♥     결제 금액은 : " + ( pay
											* ((float)(100 - haveCoupon) / 100)) + "     ♥━━━━━━━━━━━━━━━━━━━━━━") ;
								} else {
									System.out.println("    ━━━━━━━━━━━━━━━━━━━━━━♥      결제 금액은 : " + pay + "       ♥━━━━━━━━━━━━━━━━━━━━━━");
								}
							} else {
								System.out.println("결제 금액은 : " + pay);
							}
							pDao.insertPayment(id, pwd, name);
						}
					}
				
			} else if (inputNum == 2) {
				System.out.println("┏━━━━━━━━━━━━━━━━━━━♥ 계약해지 페이지입니다 ♥━━━━━━━━━━━━━━━━━━━┓");
				sc.nextLine();
				while (true) {
					System.out.print("♡                 ID를 입력해주세요               ♡");
					id = sc.nextLine();
					if (id.equals("")) {
						continue;
					} else {
						break;
					}
				}
				while (true) {
					System.out.print(" ♡               비밀번호를 입력해주세요             ♡");
					pwd = sc.nextLine();
					if (pwd.equals("")) {
						continue;
					} else {
						break;
					}
				}
				while (true) {
					System.out.print("♡                이름를 입력해주세요               ♡");
					name = sc.nextLine();
					System.out.println();
					System.out.println("┗━━━━━━━━━━━━━━━━━━━♥ 계약해지 페이지입니다 ♥━━━━━━━━━━━━━━━━━━━┛");
					if (name.equals("")) {
						continue;
					} else {
						break;
					}
				}
				if (!id.equals("") && !pwd.equals("") && !name.equals("")) {
					PaymentDTO pDto = new PaymentDTO();
					pDto.getId();
					pDto.getPwd();
					pDto.getName();

					pDao.payTermination(id, pwd, name);
				}
			} else if (inputNum == 3) {
				// 청약철회 페이지입니다.
				pDao.contractWithdrawl();

			} else if (inputNum == 4) {
				break;
			}

		}
	}
}
