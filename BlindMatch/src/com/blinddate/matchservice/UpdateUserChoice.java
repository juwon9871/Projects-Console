package com.blinddate.matchservice;

import java.util.Scanner;

public class UpdateUserChoice {

	public String UpdateUserChoice(String userId) {
		
		// 출력받기
					Scanner sc = new Scanner(System.in);
					
					// 메뉴 선택 변수 초기화
					String inputNum = null;

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

					int result = 0;
						
						while (true) {
							System.out.println("");
							System.out.println("┌──────♡ 상대 성별기입 ♡───♡───♡───┐");
							System.out.println("                                ");
							System.out.println("     원하는 상대방의 성별을 입력하세요");
							System.out.println("       남자를 원하면─♥─>  1번");
							System.out.println("       여자를 원하면─♥─>  2번");
							System.out.println("");
							System.out.print("♥───♥───>    ");
							gender = sc.nextLine();
							if (gender.equals("")) {
								continue;
							} else if (gender.equals("1")) {
								gender = "m";
								break;
							} else if (gender.equals("2")) {
								gender = "f";
								break;
							} else {
								System.out.println("");
								System.out.println("┌──────♡ 상대 정보기입 ♡───♡───♡───┐");
								System.out.println("                                ");
								System.out.println("        성별을 잘못 입력하셨습니다");
								System.out.println("");
								continue;
							}
						}
						
						while (true) {
							System.out.println("");
							System.out.println("┌──────♡ 상대 지역기입 ♡───♡───♡───┐");
							System.out.println("                                ");
							System.out.println("    원하는 상대방의 거주지를 입력하세요");
							System.out.println("              OO시 까지");
							System.out.println("");
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
							System.out.println("┌──────♡ 상대 나이기입 ♡───♡───♡───┐");
							System.out.println("                                ");
							System.out.println("      원하는 상대방의 나이를 입력하세요");
							System.out.println("");
							System.out.print("♥───♥───>    ");
							age = sc.nextInt();
							sc.nextLine();
							if (age < 20) {
								System.out.println("");
								System.out.println("┌──────♡ 상대 정보기입 ♡───♡───♡───┐");
								System.out.println("                                ");
								System.out.println("            성인만 가능합니다.");
								System.out.println("");

								continue;
							} else if (age > 45) {
								System.out.println("");
								System.out.println("┌──────♡ 상대 정보기입 ♡───♡───♡───┐");
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
							System.out.println("┌──────♡ 상대 키 기입 ♡───♡───♡───┐");
							System.out.println("                                ");
							System.out.println("      원하는 상대방의 키를 입력하세요");
							System.out.println("");
							System.out.print("♥───♥───>    ");
							height1 = sc.nextDouble();
							sc.nextLine();
							height = (int)height1;
							if (height == 0) {
								continue;
							} else if (height < 150) {
								System.out.println("");
								System.out.println("┌──────♡ 상대 정보기입 ♡───♡───♡───┐");
								System.out.println("                                ");
								System.out.println("            최소키는 150입니다");
								System.out.println("");
								continue;
							} else if (height > 200) {
								System.out.println("");
								System.out.println("┌──────♡ 상대 정보기입 ♡───♡───♡───┐");
								System.out.println("                                ");
								System.out.println("           최대키는 200입니다");
								System.out.println("");
								continue;
							} else {
								break;
							}
						}

						while (true) {
							System.out.println("");
							System.out.println("┌──────♡ 상대 몸무게 기입 ♡───♡───♡───┐");
							System.out.println("                                ");
							System.out.println("      원하는 상대방의 몸무게를 입력하세요");
							System.out.println("");
							System.out.print("♥───♥───>    ");
							weight1 = sc.nextDouble();
							sc.nextLine();
							weight = (int)weight1;
							if (weight == 0) {
								System.out.println("");
								System.out.println("┌──────♡ 상대 정보기입 ♡───♡───♡───┐");
								System.out.println("                                ");
								System.out.println("           잘못 입력하셨습니다.");
								System.out.println("");
								continue;
							} else if (weight < 35 || weight > 150) {
								System.out.println("");
								System.out.println("┌──────♡ 상대 정보기입 ♡───♡───♡───┐");
								System.out.println("                                ");
								System.out.println("       35~150kg 사이로 입력해주세요");
								System.out.println("");
							} else {
								break;
							}
						}

						while (true) {
							System.out.println("");
							System.out.println("┌──────♡ 상대 mbti기입 ♡───♡───♡───┐");
							System.out.println("                                ");
							System.out.println("   원하는 상대방의 MBTI를 입력하세요");
							System.out.println("            상관이 없다면");
							System.out.println("       Enter Key를 입력하십시오");
							System.out.println("");
							System.out.print("♥───♥───>    ");
							mbti = sc.nextLine();
							if (mbti.equals("")) {
								break;
							} else if (mbti.equals("istj") || mbti.equals("istp") || mbti.equals("isfj") || mbti.equals("isfp")
									|| mbti.equals("infj") || mbti.equals("intj") || mbti.equals("infp") || mbti.equals("intp")
									|| mbti.equals("estj") || mbti.equals("esfp") || mbti.equals("enfp") || mbti.equals("entp")
									|| mbti.equals("esfj") || mbti.equals("estp") || mbti.equals("enfj") || mbti.equals("entj")) {
								break;
							} else {
								System.out.println("");
								System.out.println("┌──────♡ 상대 정보기입 ♡───♡───♡───┐");
								System.out.println("                                ");
								System.out.println("            잘못 입력하셨습니다.");
								System.out.println("");
								continue;
							}
						}

						while (true) {
							System.out.println("");
							System.out.println("┌──────♡ 상대 차 유무 ♡───♡───♡───┐");
							System.out.println("                                ");
							System.out.println("  원하는 상대방의 자동차유무를 입력하세요");
							System.out.println("         차O ─♥─> 'y' ");
							System.out.println("         차X ─♥─> 'n' ");
							System.out.println("         상관이 없다면 ");
							System.out.println("   Enter Key를 입력하십시오");
							System.out.println("");
							System.out.print("♥───♥───>    ");
							car = sc.nextLine();
							if (car.equals("")) {
								break;
							} else if (car.equals("y") || car.equals("n")) {
								break;
							} else {
								System.out.println("");
								System.out.println("┌──────♡ 상대 정보기입 ♡───♡───♡───┐");
								System.out.println("                                ");
								System.out.println("          다시 입력해 주세요.");
								System.out.println("");
								continue;
							}
						}

						while (true) {
							
							System.out.println("");
							System.out.println("┌──────♡ 상대 종교 기입 ♡───♡───♡───┐");
							System.out.println("                                ");
							System.out.println("       상대방의 종교를 입력하세요");
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
								System.out.println("");
								System.out.println("┌──────♡ 상대 정보기입 ♡───♡───♡───┐");
								System.out.println("                                ");
								System.out.println("           잘못 입력하셨습니다.");
								System.out.println("");
								continue;
							}
						}

						while (true) {
							System.out.println("");
							System.out.println("┌──────♡ 상대 음주 유무 ♡───♡───♡───┐");
							System.out.println("                                ");
							System.out.println("    원하는 상대방의 음주유무를 입력하세요");
							System.out.println("            술O ─♥─> 'y' ");
							System.out.println("            술X ─♥─> 'n' ");
							System.out.println("             상관이 없다면");
							System.out.println("       Enter Key를 입력하십시오");
							System.out.print("♥───♥───>    ");
							drink = sc.nextLine();
							if (drink.equals("")) {
								break;
							} else if (drink.equals("y") || drink.equals("n")) {
								break;
							} else {
								System.out.println("");
								System.out.println("┌──────♡ 상대 정보기입 ♡───♡───♡───┐");
								System.out.println("                                ");
								System.out.println("           잘못 입력하셨습니다.");
								System.out.println("");
								continue;
							}
						}

						while (true) {
							System.out.println("");
							System.out.println("┌──────♡ 상대 흡연 유무 ♡───♡───♡───┐");
							System.out.println("                                ");
							System.out.println("   원하는 상대방의 흡연유무를 입력하세요");
							System.out.println("           흡연자 ─♥─> 'y' ");
							System.out.println("           비흡연자 ─♥─> 'n' ");
							System.out.println("             상관이 없다면");
							System.out.println("        Enter Key를 입력하십시오");
							System.out.print("♥───♥───>    ");
							smoke = sc.nextLine();
							if (smoke.equals("")) {
								break;
							} else if (smoke.equals("y") || smoke.equals("n")) {
								break;
							} else {
								System.out.println("");
								System.out.println("┌──────♡ 상대 정보기입 ♡───♡───♡───┐");
								System.out.println("                                ");
								System.out.println("           잘못 입력하셨습니다.");
								System.out.println("");
								continue;
							}
						}

						// DTO 객체 생성
						UserDTO cDto = new UserDTO();
						cDto.setAge(age);
						cDto.setAddr(addr);
						cDto.setCar(car);
						cDto.setDrink(drink);
						cDto.setGender(gender);
						cDto.setHeight(height);
						cDto.setId(id);
						cDto.setMbti(mbti);
						cDto.setRel(rel);
						cDto.setSmoke(smoke);
						cDto.setWeight(weight);
//						cDto.setId(userId);
						// DAO 객체 생성
						UserDAO uDao = new UserDAO();
					
						// 등록 메서드 호출
						result = uDao.updateChoiceInfo(cDto);
						

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

		
		return "updateUserChoice";
		
	}
}
