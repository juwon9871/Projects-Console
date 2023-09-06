package com.blinddate.FindUser;

import java.util.Scanner;

public class FindUser {

	public void FindUserId() {
		Scanner sc = new Scanner(System.in);
		String id = null;
		String name = null;
		String pwd = null;
		String phoneNum = null;
		String findusermenu = null;
		int result = 0;

		while (true) {

			while (true) {
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ 아이디비번 찾기 ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");

				// id, pw 둘다 일치하면 로그인 성공
				// @@로그인을 한 상태에서는 또 로그인이 안되게끔 설정해야함@@
				// 로그인을 해야 기능 사용(1이면 서비스기능 가능, 1이면 로그인기능 불가 식으로)
				System.out.println("♡                                                         ♡");
				System.out.println("♡        1. 아이디 찾기    2. 비번 찾기     3. 이전 메뉴          ♡");
				System.out.println("♡                                                         ♡");
				System.out.println("♡-♡-♡-♡-♡-♡-♡-♡-♡ 원하시는 기능의 번호를 입력하세요 ♡-♡-♡-♡-♡-♡-♡-♡-♡");
				findusermenu = sc.nextLine();
				
				System.out.println("♡");
				// 아이디 찾기 메뉴로 이동
				if (findusermenu.equals("1")) {
					System.out.println("아이디 찾는 페이지입니다.");
					while (true) {
						System.out.print("♡ 이름을 입력하세요 : ");
						name = sc.nextLine();
						if (name.equals("")) {
							System.out.println("이름 입력은 필수입니다.");
							continue;
						} else {
							break;
						}
					}
					while (true) {
						System.out.println("핸드폰번호를 입력하세요");
						phoneNum = sc.nextLine();
						if (phoneNum.equals("")) {
							System.out.println(" *핸드폰번호 입력은 필수입니다.");
							continue;
						} else {
							System.out.println(
									"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
							break;
						}
					}
					if (!name.equals("") && !phoneNum.equals("")) {
						System.out.println("이름이랑 폰번이 둘다 입력은 됐어");
						FindUserDAO fDao = new FindUserDAO();
						result = fDao.namePhoneNumCheck(name, phoneNum);

						if (result == -1) {
							boolean ftSwitch = true;

							while (ftSwitch) {
								System.out.println();
								System.out.println("=====< 회원정보가 존재하지 않습니다. >=====");
								System.out.println();
								System.out.println("이름을 다시 입력해주세요");
								name = sc.nextLine();
								System.out.println("핸드폰 번호를 다시 입력해주세요");
								phoneNum = sc.nextLine();
								if (name.equals("") || phoneNum.equals("")) {
									continue;
								} else {
									result = fDao.namePhoneNumCheck(name, phoneNum);

									if (result == -1) {
										continue;
									}
								}
								ftSwitch = false;
							}
						}
						if (result == 0) {
							boolean ftSwitch = true;

							System.out.println();
							System.out.println("=====< 회원정보가 존재하지 않습니다(핸드폰번호) >====");
							System.out.println();

							while (ftSwitch) {
								System.out.println("이름을 다시 입력해주세요");
								name = sc.nextLine();
								System.out.println("핸드폰번호를 다시 입력해주세요");
								phoneNum = sc.nextLine();

								if (phoneNum.equals("") || name.equals("")) {
									continue;
								} else {
									result = fDao.namePhoneNumCheck(name, phoneNum);

									if (result == 0) {
										continue;
									}
								}
								ftSwitch = false;
							}
						}

						if (result == 1) {
							// id를 찾는 메소드를 호출.
							System.out.println("찾으신 아이디는 : " + fDao.findId(name, phoneNum));

						}
						break;

					}
				}
				// 비번 찾기 메뉴로 이동
				else if (findusermenu.equals("2")) {

					while (true) {
						System.out.print("아이디를 입력하세요 : ");
						id = sc.nextLine();
						if (id.equals("")) {
							System.out.println(" *ID 입력은 필수입니다.");
						} else {
							break;
						}
					}
					while (true) {
						System.out.println("핸드폰번호를 입력하세요 : ");
						phoneNum = sc.nextLine();
						if (phoneNum.equals("")) {
							System.out.println(" *핸드폰번호 입력은 필수입니다.");
						} else {
							break;
						}
					}

					if (!id.equals("") && !phoneNum.equals("")) {
						System.out.println("아이디 폰번이 둘다 입력은 됐어");
						FindUserDAO fuDAO = new FindUserDAO();
						result = fuDAO.idPhoneNumCheck(id, phoneNum);
						sc.nextLine();

						if (result == -1) {
							boolean ftSwitch = true;
							System.out.println();
							System.out.println("=====< 회원정보가 존재하지 않습니다. >=====");
							System.out.println();
							while (ftSwitch) {
								System.out.println("ID를 다시 입력해주세요");
								id = sc.nextLine();
								System.out.println("핸드폰번호를 다시 입력해주세요");
								phoneNum = sc.nextLine();

								if (id.equals("") || phoneNum.equals("")) {
									continue;
								} else {
									result = fuDAO.idPhoneNumCheck(id, phoneNum);
									if (result == -1) {
										continue;
									}
								}
								ftSwitch = false;
							}
						}

						if (result == 0) {
							boolean ftSwitch = true;

							System.out.println();
							System.out.println("=====< 회원정보가 존재하지 않습니다(핸드폰번호) >====");
							System.out.println();

							while (ftSwitch) {
								System.out.println("아이디를 다시 입력해주세요");
								id = sc.nextLine();
								System.out.println("핸드폰번호를 다시 입력해주세요");
								phoneNum = sc.nextLine();

								if (phoneNum.equals("") || id.equals("")) {
									continue;
								} else {
									result = fuDAO.idPhoneNumCheck(id, phoneNum);

									if (result == 0) {
										continue;
									}
								}
								ftSwitch = false;
							}
						}

						if (result == 1) {
							// 비번 찾는 메소드를 호출.
							System.out.println("찾으신 비밀번호는 : " + fuDAO.findpwd(id, phoneNum));

						}
						break;
					}
				} else if (findusermenu.equals("3")) {
					break;
				} else {
					System.out.println("");
					System.out.println("                    메뉴를 확인해주세요(˘･_･˘)");
					System.out.println("");
					continue;
				}
			}
			break;
		}
	}
}
