package com.blinddate.matchservice;

import java.util.Scanner;


public class UpdateUserTable {
			public String UpdateUserTable(String userId) {
			// 출력받기
			Scanner sc = new Scanner(System.in);
			
			// 메뉴 선택 변수 초기화

			// 정보기입 변수 초기화
			String id = userId;
			int age = 0;
			int height = 0;
			int weight = 0;
			double height1 = 0;
			double weight1 = 0;
			String mbti = null;
			String car = null;
			String rel = null;
			String drink = null;
			String smoke = null;
			String gender = null;
			String addr = null;
			String couponNo=null;
			String name = null;
			String phoneNum = null;
			String matching = null;
			String msuccess = null;
			int couponDiscount = 0;
			int result = 0;



				
				while (true) {
					System.out.println("");
					System.out.println("┌──────♡ 본인 주소기입 ♡───♡───♡───┐");
					System.out.println("                                 ");
					System.out.println("    본인의 거주지─♥─>  OO시 OO구 까지  ");
					System.out.println("                              ");
					System.out.print("♥───♥───>    ");
					addr = sc.nextLine();
					if (addr.equals("")) {
						continue;
					} else {
						break;
					}
				}

				while (true) {
					System.out.println("");
					System.out.println("┌──────♡ 본인 나이기입 ♡───♡───♡───┐");
					System.out.println("                                 ");
					System.out.println("       본인의 나이─♥─>   25       ");
					System.out.println("                                 ");
					System.out.print("♥───♥───>    ");
					age = sc.nextInt();
					sc.nextLine();
					if (age < 20) {
						System.out.println("");
						System.out.println("┌──────♡ 본인 정보기입 ♡───♡───♡───┐");
						System.out.println("                                ");
						System.out.println("            성인만 가능합니다.");
						System.out.println("");
						continue;
					} else if (age > 45) {
						System.out.println("");
						System.out.println("┌──────♡ 본인 정보기입 ♡───♡───♡───┐");
						System.out.println("                                ");
						System.out.println("         45세까지만 이용가능합니다");
						System.out.println("");
						continue;
					} else {
						break;
					}
				}

				while (true) {
					System.out.println("");
					System.out.println("┌──────♡ 본인 키 기입 ♡───♡───♡───┐");
					System.out.println("                                 ");
					System.out.println("         본인의 키를 입력하세요.     ");
					System.out.println("");
					System.out.print("♥───♥───>    ");
					height1 = sc.nextDouble();
					sc.nextLine();
					height = (int)height1;
					if (height == 0) {
						continue;
					} else if (height < 150) {
						System.out.println("   ");
						System.out.println("┌──────♡ 본인 정보기입 ♡───♡───♡───┐");
						System.out.println("   ");
						System.out.println("          최소 150이상이여야 합니다.");
						System.out.println("");
						continue;
					} else if (height > 200) {
						System.out.println("   ");
						System.out.println("┌──────♡ 본인 정보기입 ♡───♡───♡───┐");
						System.out.println("   ");
						System.out.println("          200 이하이여야 합니다.");
						System.out.println("");
						continue;
					} else {
						break;
					}
				}

				while (true) {
					System.out.println("   ");
					System.out.println("┌──────♡ 본인 몸무게기입 ♡───♡───♡───┐");
					System.out.println("   ");
					System.out.println("        본인의 몸무게를 입력하세요.          ");
					System.out.println("");
					System.out.print("♥───♥───>    ");
					weight1 = sc.nextDouble();
					sc.nextLine();
					weight = (int)weight1;
					if (weight == 0) {
						System.out.println("");
						System.out.println("┌──────♡ 본인 정보기입 ♡───♡───♡───┐");
						System.out.println("                                ");
						System.out.println("           잘못 입력하셨습니다.");
						System.out.println("");
						continue;
					} else if (weight < 35 || weight > 150) {
						System.out.println("");
						System.out.println("┌──────♡ 본인 정보기입 ♡───♡───♡───┐");
						System.out.println("                                ");
						System.out.println("       35~150kg 사이로 입력해주세요");
						System.out.println("");
					} else {
						break;
					}
				}

				while (true) {
					System.out.println("   ");
					System.out.println("┌──────♡ 본인 mbti기입 ♡───♡───♡───┐");
					System.out.println("   ");
					System.out.println("        본인의 MBTI를 입력하세요");
					System.out.println("              intp");
					System.out.println("              estj");
					System.out.println("");
					System.out.print("♥───♥───>    ");
					mbti = sc.nextLine().toLowerCase();
					if (mbti.equals("")) {
						continue;
					} else if (mbti.equals("istj") || mbti.equals("istp") || mbti.equals("isfj") || mbti.equals("isfp")
							|| mbti.equals("infj") || mbti.equals("intj") || mbti.equals("infp") || mbti.equals("intp")
							|| mbti.equals("estj") || mbti.equals("esfp") || mbti.equals("enfp") || mbti.equals("entp")
							|| mbti.equals("esfj") || mbti.equals("estp") || mbti.equals("enfj") || mbti.equals("entj")) {
						break;
					} else {
						System.out.println("   ");
						System.out.println("┌──────♡ 본인 정보기입 ♡───♡───♡───┐");
						System.out.println("   ");
						System.out.println("          잘못 입력하셨습니다.");
						System.out.println("");
						continue;
					}
				}

				while (true) {
					System.out.println("   ");
					System.out.println("┌──────♡ 본인 차 유무 ♡───♡───♡───┐");
					System.out.println("   ");
					System.out.println("        본인의 자동차유무를 입력하세요");
					System.out.println("         자차가 있다─♥─> 'y' ");
					System.out.println("         자차가 없다─♥─> 'n' ");
					System.out.println("");
					System.out.print("♥───♥───>    ");
					car = sc.nextLine();
					if (car.equals("")) {
						continue;
					} else if (car.equals("y") || car.equals("n")) {
						break;
					} else {
						System.out.println("   ");
						System.out.println("┌──────♡ 본인 정보기입 ♡───♡───♡───┐");
						System.out.println("   ");
						System.out.println("          다시 입력해 주세요.");
						System.out.println("");

						continue;
					}
				}

				while (true) {
					System.out.println("   ");
					System.out.println("┌──────♡ 본인 종교기입 ♡───♡───♡───┐");
					System.out.println("   ");
					System.out.println("        본인의 종교를 입력하세요");
					System.out.println("          기독교면─♥─> 1번");
					System.out.println("          천주교면─♥─> 2번");
					System.out.println("          불교면─♥─> 3번 ");
					System.out.println("          무교면─♥─> 4번");
					System.out.println("");
					System.out.print("♥───♥───>    ");
					rel = sc.nextLine();

					if (rel.equals("")) {
						continue;
					} else if (rel.equals("1")) {
						rel = "christian";
						break;
					} else if (rel.equals("2")) {
						rel = "catholic";
						break;
					} else if (rel.equals("3")) {
						rel = "buddihsm";
						break;
					} else if (rel.equals("4")) {
						rel = "none";
						break;
					} else {
						System.out.println("   ");
						System.out.println("┌──────♡ 본인 정보기입 ♡───♡───♡───┐");
						System.out.println("   ");
						System.out.println("           잘못된 정보입니다.");
						System.out.println("");
						continue;
					}
				}

				while (true) {
					System.out.println("   ");
					System.out.println("┌──────♡ 본인 음주기입 ♡───♡───♡───┐");
					System.out.println("   ");
					System.out.println("        본인의 음주유무를 입력하세요");
					System.out.println("        술을 마신다─♥─> 'y' ");
					System.out.println("           안마신다─♥─> 'n' ");
					System.out.println("");
					System.out.print("♥───♥───>    ");
					drink = sc.nextLine().toLowerCase();
					if (drink.equals("")) {
						continue;
					} else if (drink.equals("y") || drink.equals("n")) {
						break;
					} else {
						System.out.println("   ");
						System.out.println("┌──────♡ 본인 정보기입 ♡───♡───♡───┐");
						System.out.println("   ");
						System.out.println("            다시 입력해 주세요.");
						System.out.println("");
						continue;
					}
				}

				while (true) {
					System.out.println("   ");
					System.out.println("┌──────♡ 본인 흡연 유무 ♡───♡───♡───┐");
					System.out.println("   ");
					System.out.println("        본인의 흡연유무를 입력하세요");
					System.out.println("          흡연자─♥─> 'y' ");
					System.out.println("         비흡연자─♥─> 'n' ");
					System.out.println("");
					System.out.print("♥───♥───>    ");
					smoke = sc.nextLine().toLowerCase();
					if (smoke.equals("")) {
						continue;
					} else if (smoke.equals("y") || smoke.equals("n")) {
						break;
					} else {
						System.out.println("   ");
						System.out.println("┌──────♡ 본인 정보기입 ♡───♡───♡───┐");
						System.out.println("   ");
						System.out.println("           다시 입력해 주세요.");
						System.out.println("");
						continue;
					}
				}
				while (true) {
					System.out.println("   ");
					System.out.println("┌──────♡ 본인 정보기입 ♡───♡───♡───┐");
					System.out.println("");
					System.out.println("         원하는 매칭을 선택하세요");
					System.out.println("  1. 1:1매칭   2. 랜덤매칭  3. 관리자매칭");
					System.out.println("");
					System.out.print("♥───♥───>    ");
					matching = sc.nextLine();
					if (matching.equals("1")) {
						matching = "1";
						break;
					} else if (matching.equals("2")) {
						matching = "r";
						break;
					} else if (matching.equals("3")) {
						matching = "a";
								break;
					} else {
						System.out.println("   ");
						System.out.println("┌──────♡ 본인 정보기입 ♡───♡───♡───┐");
						System.out.println("   ");
						System.out.println("           다시 입력해 주세요.");
						System.out.println("");
						continue;
					}
				}

				// DTO 객체 생성
				UserDTO uDto = new UserDTO(id, age, height, weight, mbti, car, rel, drink, smoke, gender, addr, name, phoneNum, matching, msuccess, couponNo, couponDiscount);
				UserDAO uDao = new UserDAO();

				// 등록 메서드 호출
				result = uDao.updateUserInfo(uDto);

				if (result > 0) {
					System.out.println("   ");
					System.out.println("┌──────♡ 본인 정보기입 ♡───♡───♡───┐");
					System.out.println("♡                                ♡ ");
					System.out.println(" ♡           완료되었습니다.           ♡ ");
					System.out.println("♡   ♡         ♡           ♡      ♡ ");
					System.out.println(" ♡      ♡           ♡         ♡   ♡ ");
					System.out.println("   ");
				} else {
					System.out.println("   ");
					System.out.println("┌──────♡ 본인 정보기입 ♡───♡───♡───┐");
					System.out.println("                                 ");
					System.out.println("              실패했습니다.            ");
					System.out.println("");
					System.out.println("   ");
				}

			
			return "updateUser";
}
}
