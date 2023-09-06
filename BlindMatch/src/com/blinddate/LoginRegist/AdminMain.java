package com.blinddate.LoginRegist;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminMain {

	public String adminMain() {
		String inputNum = null;

		String id = null;
		String pwd = null;
		String name = null;
		String phoneNum = null;
		String gender = null;

		String adminId = null;
		String adminpwd = null;
		int result = 0;

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println();
			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━♥ Blind match ♥━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ");
			System.out.println(" ♡                                                          ♡             ");
			System.out.println("♡         1.관리자 등록      2.관리자 로그인      3.메뉴 돌아가기   ♡");
			System.out.println(" ♡                                                          ♡");
			System.out.println("♡         4.관리자 목록보기                                    ♡");
			System.out.println(" ♡                                                          ♡");
			System.out.println("♡-♡-♡-♡-♡-♡-♡-♡-♡- 원하시는 기능의 번호를 입력하세요 -♡-♡-♡-♡-♡-♡-♡-♡-♡");
			System.out.println();
			inputNum = sc.nextLine();

			if (inputNum.equals("1")) {
				// 유효성 체크
				while (true) {
					System.out.print("♡    ━━━━━♥━━━━━>  Admin  I  D  :  ");
					id = sc.nextLine();

					if (id.equals("")) {
						continue;

					} else {
						while (true) {
							System.out.println("♡                                                       ♡");
							System.out.println("♡          당신이 입력한 ID는   " + id + "   입니다     ♡");
							System.out.print("♡          아이디가 맞습니까? y / n   ");
							String correction = sc.nextLine();

							if (correction.equals("y")) {
								break;
							} else if (correction.equals("n")) {
								System.out.print("♡    ━━━━━♥━━━━━>  Admin  I  D  :  ");
								id = sc.nextLine();
								continue;
							} else {
								System.out.print("♡    ━━━━━♥━━━━━>  Admin  I  D  :  ");
								continue;
							}
						}
						break;
					}
				}
				while (true) {
					System.out.println("♡                                                       ♡");
					System.out.print("♡    ━━━━━♥━━━━━>  Admin Password :  ");
					pwd = sc.nextLine();

					if (pwd.equals("")) {
						System.out.println("♡                   ※비밀번호 입력은 필수입니다.※              ♡");
						continue;

					} else {
						break;
					}
				}

				while (true) {
					System.out.println("♡                                                       ♡");
					System.out.print("♡    ━━━━━♥━━━━━> 이름 :  ");
					name = sc.nextLine();

					if (name.equals("")) {
						continue;
					} else {
						while (true) {
							System.out.println("♡                                                       ♡");
							System.out.println("♡        입력한 이름은 " + name + "        ♡");
							System.out.print("♡        이름이 맞습니까? y / n   ");
							String correction = sc.nextLine();

							if (correction.equals("y")) {
								break;
							} else if (correction.equals("n")) {
								System.out.print("♡    ━━━━━♥━━━━━> 이름 :  ");
								name = sc.nextLine();
								continue;
							} else {
								System.out.print("♡    ━━━━━♥━━━━━> 이름 :  ");
								continue;
							}
						}
						break;
					}
				}

				while (true) {
					System.out.print("♡    ━━━━━♥━━━━━> 전화번호 :  ");
					phoneNum = sc.nextLine();

					if (phoneNum.equals("")) {
						continue;

					} else {
						while (true) {
							System.out.println("");
							System.out.println("♡          당신이 입력한 전화번호는  " + phoneNum + "  입니다          ♡");
							System.out.print("♡          전화번호가 맞습니까? y / n   ");
							String correction = sc.nextLine();

							if (correction.equals("y")) {
								break;
							} else if (correction.equals("n")) {
								System.out.println("");
								System.out.print("♡    ━━━━━♥━━━━━> 전화번호 :  ");
								phoneNum = sc.nextLine();
								continue;
							} else {
								continue;
							}
						}
						break;
					}

				}

				while (true) {
					System.out.println("");
					System.out.print("♡          성별을 입력해주세요   1.m   2.f ");
					inputNum = sc.nextLine();
					if (inputNum.equals("1")) {
						gender = "m";
						break;
					} else if (inputNum.equals("2")) {
						gender = "f";
						break;
					} else {
						continue;
					}

				}

				if (!id.equals("") && !pwd.equals("") && !name.equals("") && !phoneNum.equals("")
						&& !gender.equals("")) {
					// AdminDTO 객체 생성
					AdminDTO aDto = new AdminDTO();
					aDto.setAdminId(id);
					aDto.setPhoneNum(phoneNum);
					aDto.setAdminPwd(pwd);
					aDto.setGender(gender);
					aDto.setName(name);

					// AdminDAO 객체 생성
					AdminDAO aDao = new AdminDAO();

					// Admin 등록 메서드 호출
					result = aDao.insertAdmin(aDto);

					if (result > 0) {
						System.out.println();
						System.out.println("♡          정상 등록 되었습니다.          ♡");
						System.out.println();
					} else {
						System.out.println();
						System.out.println("♡          등록 실패 했습니다.          ♡");
						System.out.println();
					}

				}
			} else if (inputNum.equals("2")) {
				while (true) {
					System.out.print("♡    ━━━━━♥━━━━━>   Admin I  D  :  ");
					adminId = sc.nextLine();

					if (adminId.equals("")) {
						continue;
					} else {
						break;
					}
				}

				while (true) {
					System.out.print("♡    ━━━━━♥━━━━━> Password :  ");
					adminpwd = sc.nextLine();

					if (adminpwd.equals("")) {
						continue;
					} else {
						break;
					}
				}

				if (!adminId.equals("") && !adminpwd.equals("")) {
					AdminDAO aDao = new AdminDAO();
					result = aDao.adminCheck(adminId, adminpwd);

					if (result == -1) {
						boolean ftSwitch = true;
						System.out.println();
						System.out.println("━━━━━♥━━━━━> 존재하지 않은 ID입니다. <━━━━━♥━━━━━");
						System.out.println();

						while (ftSwitch) {
							System.out.print("♡    ━━━━━♥━━━━━>   Admin I  D  :  ");
							adminId = sc.nextLine();

							if (adminId.equals("")) {
								continue;
							} else {
								result = aDao.adminCheck(adminId, adminpwd);

								if (result == -1) {
									continue;
								}
							}
							ftSwitch = false;
						}
					}

					if (result == 0) {

						System.out.println();
						System.out.println("━━━━━♥━━━━━> 비밀번호가 일치하지 않습니다. <━━━━━♥━━━━━");
						System.out.println();

						while (true) {
							System.out.print("♡    ━━━━━♥━━━━━> Password :  ");
							adminpwd = sc.nextLine();

							if (adminpwd.equals("")) {
								continue;
							} else {
								result = aDao.adminCheck(adminId, adminpwd);

								if (result == 0) {
									continue;
								}
								break;
							}
						}
					}
					if (result == 1) {
						System.out.println();
						System.out.println("━━━━━♥━━━━━>" + adminId + "님 반갑습니다" + "<━━━━━♥━━━━━");
						System.out.println();
						break;
					}

				}
			} else if (inputNum.equals("3")) {
				break;
			} else if (inputNum.equals("4")) {
				ArrayList<AdminDTO> adminList = new ArrayList<>();
				AdminDAO mDao = new AdminDAO();
				adminList = mDao.selAllAdmin();

				if (adminList.isEmpty()) { // Admin 정보가 존재하지 않을 경우 처리
					System.out.println("━━━━━♥━━━━━> Admin 정보가 존재하지 않습니다 <━━━━━♥━━━━━");
					System.out.println();
				} else { // Admin 정보가 존재 할 경우 처리
					System.out.println("아이디\t비밀번호\t\t전화번호\t\t");
					for (int i = 0; i < adminList.size(); i++) {
						System.out.println(adminList.get(i).getAdminId() + "\t\t" + adminList.get(i).getAdminPwd()
								+ "\t\t" + adminList.get(i).getPhoneNum() + "\t\t");
					}
				}
			} else {
				System.out.println(); // 개행
				System.out.println("                    메뉴를 확인해주세요(˘･_･˘)");
				System.out.println(); // 개행
				continue;
			}
			break;
		}
		id = adminId;
		return id;
	}
}
