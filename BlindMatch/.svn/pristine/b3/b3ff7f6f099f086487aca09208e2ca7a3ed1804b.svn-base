//package com.blinddate.LoginRegist;
//
//public class format {
//
//}
//package com.blinddate.LoginRegist;
//
//import java.util.Scanner;
//
//public class UsertableMain {
//
//	public void usertableMain() {
//		String inputNum = null;
//
//		String id = null;
//		String pwd = null;
//		String name = null;
//		String phoneNum = null;
//		String gender = null;
//		String pwdchk = null;
//		String UsertableId = null;
//		String UsertablePwd = null;
//		int result = 0;
//
//		Scanner sc = new Scanner(System.in);
//
//		while (true) {
//			System.out.println();
//			System.out.println();
//			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━♥ Blind match ♥━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ");
//			System.out.println(" ♡                                                          ♡             ");
//			System.out.println("♡            1.회원가입      2.로그인      3.ID / PW 찾기       ♡");
//			System.out.println(" ♡                                                          ♡");
//			System.out.println("♡            4.정보 수정    5.쿠폰 조회     6.메인 메뉴           ♡");
//			System.out.println(" ♡                                                          ♡");
//			System.out.println("♡-♡-♡-♡-♡-♡-♡-♡-♡- 원하시는 기능의 번호를 입력하세요 -♡-♡-♡-♡-♡-♡-♡-♡-♡");
//			System.out.println();
//
//			inputNum = sc.nextLine();
////회원가입 기능으로 가자
//			if (inputNum.equals("1")) {
//				while (true) {
//					System.out.print("♡    ━━━━━♥━━━━━>    I  D  :  ");
//					id = sc.nextLine();
//
//					if (id.equals("")) {
//						System.out.println("♡                                                       ♡");
//						System.out.println("♡                ※아이디 입력은 필수입니다.※                  ♡");
//						System.out.println("♡                                                       ♡");
//
//						continue;
//					} else {
//						while (true) {
//							System.out.println("♡                                                       ♡");
//							System.out.println("♡          당신이 입력한 ID는   " + id + "   입니다     ♡");
//							System.out.print("♡          아이디가 맞습니까? y / n   ");
//							String correction = sc.nextLine();
//
//							if (correction.equals("y")) {
//								break;
//							} else if (correction.equals("n")) {
//								System.out.println("");
//								System.out.print("♡    ━━━━━♥━━━━━>    I  D  :  ");
//								id = sc.nextLine();
//								continue;
//							} else {
//								System.out.println("♡                                                       ♡");
//								System.out.print("♡    ━━━━━♥━━━━━>    I  D  :  ");
//								System.out.println("♡                                                       ♡");
//								continue;
//							}
//						}
//						break;
//					}
//				}
//
//				while (true) {
//					while (true) {
//						System.out.println("♡                                                       ♡");
//						System.out.print("♡    ━━━━━♥━━━━━> Password :  ");
//						pwd = sc.nextLine();
//
//						if (pwd.equals("")) {
//							System.out.println("♡                   ※비밀번호 입력은 필수입니다.※              ♡");
//
//							continue;
//						} else {
//							break;
//						}
//					}
//					
//					System.out.print("♡    ━━━━━♥━━━━━> Password  확인 :  ");
//					pwdchk = sc.nextLine();
//					if (pwd.equals(pwdchk)) {
//						System.out.println("♡                                                       ♡");
//						System.out.println("♡             ✔ 비밀번호가 일치합니다                        ♡");
//						System.out.println("♡                                                       ♡");
//
//						break;
//					} else {
//						System.out.println("♡                                                       ♡");
//						System.out.println("♡        ※비밀번호가 일치하지 않습니다. 다시 확인해주세요※          ♡");
//					}
//				}
//
//				while (true) {
//					System.out.println("♡                                                       ♡");
//					System.out.print("♡    ━━━━━♥━━━━━> 이름 :  ");
//					name = sc.nextLine();
//
//					if (name.equals("")) {
//						continue;
//					} else {
//						while (true) {
//							System.out.println("♡                                                       ♡");
//							System.out.println("♡        입력한 이름은 " + name + "        ♡");
//							System.out.print("♡        이름이 맞습니까? y / n   ");
//							String correction = sc.nextLine();
//
//							if (correction.equals("y")) {
//								break;
//							} else if (correction.equals("n")) {
//								System.out.print("♡    ━━━━━♥━━━━━> 이름 :  ");
//								name = sc.nextLine();
//								continue;
//							} else {
//								System.out.print("♡    ━━━━━♥━━━━━> 이름 :  ");
//								continue;
//							}
//						}
//						break;
//					}
//				}
//
//				while (true) {
//					System.out.print("♡    ━━━━━♥━━━━━> 전화번호 :  ");
//					phoneNum = sc.nextLine();
//
//					if (phoneNum.equals("")) {
//						continue;
//					} else {
//						while (true) {
//							System.out.println("");
//							System.out.println("♡          당신이 입력한 전화번호는  " + phoneNum + "  입니다          ♡");
//							System.out.print("♡          전화번호가 맞습니까? y / n   ");
//							String correction = sc.nextLine();
//
//							if (correction.equals("y")) {
//								break;
//							} else if (correction.equals("n")) {
//								System.out.println("");
//								System.out.print("♡    ━━━━━♥━━━━━> 전화번호 :  ");
//								phoneNum = sc.nextLine();
//								continue;
//							} else {
//								System.out.println("");
//								System.out.print("♡    ━━━━━♥━━━━━> 전화번호 :  ");
//								continue;
//							}
//						}
//						break;
//					}
//				}
//
//				while (true) {
//					System.out.println("");
//					System.out.print("♡          성별을 입력해주세요   1.m   2.f ");
//					inputNum = sc.nextLine();
//					if (inputNum.equals("1")) {
//						gender = "m";
//						break;
//					} else if (inputNum.equals("2")) {
//						gender = "f";
//						break;
//					} else {
//						continue;
//					}
//				}
//
//				if (!id.equals("") && !pwd.equals("") && !name.equals("") && !phoneNum.equals("")
//						&& !gender.equals("")) {
//					// UsertableDTO 객체 생성
//					UsertableDTO sDto = new UsertableDTO();
//					sDto.setId(id);
//					sDto.setPwd(pwd);
//					sDto.setName(name);
//					sDto.setPhoneNum(phoneNum);
//					sDto.setGender(gender);
//					// UsertableDTO sDto = new UsertableDTO(id, pwd, name, phone,gender);
//
//					// UsertableDAO 객체 생성
//					UsertableDAO sDao = new UsertableDAO();
//
//					// Usertable 등록 메서드 호출
//					result = sDao.insertSignin(sDto);
//
//					if (result > 0) {
//						System.out.println();
//						System.out.println("♡          정상 등록 되었습니다.          ♡");
//						System.out.println();
//					} else {
//						System.out.println();
//						System.out.println("♡          등록 실패 했습니다.          ♡");
//						System.out.println();
//					}
//
//				}
//				
//				//로그인 기능
//			} else if (inputNum.equals("2")) {
//				while (true) {
//					System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━ Log In ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
//					System.out.println("♡           ♡");
//					System.out.print("♡    ━━━━━♥━━━━━>    I  D  :  ");
//					UsertableId = sc.nextLine();
//					System.out.println("");
//					System.out.print("♡    ━━━━━♥━━━━━> Password :  ");
//					UsertablePwd = sc.nextLine();
//
//					if (UsertableId.equals("")) {
//						System.out.println("*****************아이디를 입력해주세요*****************");
//						System.out.println("                  ( ⁰▱⁰)!!  ( ⁰▱⁰)!!                  ");
//						System.out.println("");
//						System.out.println("");
//						continue;
//					}
//
//
//					if (UsertablePwd.equals("")) {
//						System.out.println("*****************비밀번호를 입력해주세요*****************");
//						System.out.println("                  ( ⁰▱⁰)!!  ( ⁰▱⁰)!!                  ");
//						System.out.println("");
//						System.out.println("");
//						System.out.println("");
//						continue;
//					} else {
//						break;
//					}
//				}
//
//				if (!UsertableId.equals("") && !UsertablePwd.equals("")) {
//					UsertableDAO sDao = new UsertableDAO();
//					result = sDao.UsertableCheck(UsertableId, UsertablePwd);
//
//					if (result == -1) {
//						boolean ftSwitch = true;
//						System.out.println();
//						System.out.println("**************아이디 비밀번호가 일치하지 않습니다**************");
//						System.out.println();
//
//						while (ftSwitch) {
//							System.out.print("♡    ━━━━━♥━━━━━>    I  D  :  ");
//							UsertableId = sc.nextLine();
//							
//							if (UsertableId.equals("")) {
//								continue;
//							} else {
//								result = sDao.UsertableCheck(UsertableId, UsertablePwd);
//								if (result == -1) {
//									continue;
//								}
//							}
//							ftSwitch = false;
//						}
//					}
//
//					if (result == 0) {
//						boolean ftSwitch = true;
//
//						System.out.println("*****************아이디 비밀번호를 확인해주세요*****************");
//						System.out.println("                  ( ⁰▱⁰)!!  ( ⁰▱⁰)!!                  ");
//
//						while (ftSwitch) {
//							System.out.print("♡    ━━━━━♥━━━━━> ID :  ");
//							UsertableId = sc.nextLine();
//							System.out.print("♡    ━━━━━♥━━━━━> Password :  ");
//							UsertablePwd = sc.nextLine();
//							if(UsertableId.equals("")) {
//								System.out.println("1234");
//								continue;
//							}
//							if (UsertablePwd.equals("")) {
//								continue;
//							} else {
//								result = sDao.UsertableCheck(UsertableId, UsertablePwd);
//
//								if (result == 0) {
//									continue;
//								}
//							}
//						}
//						ftSwitch = false;
//					}
//					if (result == 1) {
//						System.out.println();
//						System.out.println("===<" + UsertableId + "님 반갑습니다" + ">===");
//						System.out.println();
//					}
//
//				}
//			} else if (inputNum.equals("3")) {
//				break;
//			} else {
//				System.out.println(); // 개행
//				System.out.println("                    메뉴를 확인해주세요(˘･_･˘)");
//				System.out.println(); // 개행
//				continue;
//			}
//
//		}
//		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
//
//	}
//}