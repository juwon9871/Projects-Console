package com.blinddate.matchservice;

import java.util.ArrayList;
import java.util.Scanner;

public class PtopMatch {

	public String ptpMatch(String id) {

		Scanner sc = new Scanner(System.in);
		String msuccess = null;
		RandMatchDAO rDao = new RandMatchDAO();
		UserDTO sDto = rDao.selChk(id);
		UserDAO uDao = new UserDAO();
		UserDTO mNDto = uDao.myName(id);
		String correction = sc.nextLine();
		int result = uDao.upMsuccess(msuccess, id);

		while (true) {
			System.out.println("");
			System.out.println("┌──────────♥♡♥♡ 1 : 1 매칭 ♡♥♡♥──────────┐");
			System.out.println("♡                   "+ "                    ♡ ");
			System.out.println(" ♡      원하는 이성과 1:1 매칭메뉴입니다         ♡ ");
			System.out.println("♡       소중한 인연을 만들 기회를 잡으세요!      ♡ ");
			System.out.println(" ♡      저희가 최선을 다해 연결시켜드립니다!       ♡ ");
			System.out.println("♡                   "+ "                    ♡ ");
			System.out.println(" ♡        1. 매칭 시작    2.돌아가기          ♡");
			System.out.println("");
			System.out.print("♥───♥───>    ");
			String inputNum = sc.nextLine();

			if (inputNum.equals("1")) {
				System.out.println("");
				System.out.println("───────────ㆍ 1 : 1 매칭 ㆍ─────────────────────────────────────────────"+" ♡");
				System.out.println("   ♡              ♡             ♡                     ♡          ");
				System.out.println("\t" + mNDto.getName() + "님의 원하는 이성 프로필은 ♡              ♡");
				System.out.print("성별\t나이\t키\t몸무게\t주소\tmbti\t차\t");
				System.out.println("종교\t음주\t흡연");
				System.out.print(sDto.getGender() + "\t" + sDto.getAge() + "\t");
				System.out.print(sDto.getHeight() + "\t" + sDto.getWeight() + "\t" + sDto.getAddr() + "\t"+sDto.getMbti() + "\t");
				if (sDto.getCar() == null) {
					System.out.print("상관없음" + "\t");

				} else {
					System.out.print(sDto.getCar() + "\t");
				}
				if (sDto.getRel() == null) {
					System.out.print("상관없음" + "\t");
				} else {
					System.out.print(sDto.getRel() + "\t");
				}
				if (sDto.getDrink() == null) {
					System.out.print("상관없음" + "\t");
				} else {
					System.out.println(sDto.getDrink() + "\t");
				}
				if (sDto.getSmoke() == null) {
					System.out.println("상관없음");
				} else {
					System.out.println(sDto.getSmoke());
				}
				System.out.println("");
				System.out.println("┌──────♡ 1:1 매칭 ♡───♡───♡───┐");
				System.out.println("");
				System.out.println("        이대로 진행 하시려면 1번");
				System.out.println("        되돌아가서 수정하려면 2번");
				System.out.println("              눌러주세요");
				System.out.print("♥───♥───>    ");
				inputNum = sc.nextLine();

				if (inputNum.equals("1")) {
					System.out.println("");
					System.out.println("┌──────♡ 1:1 매칭 ♡───♡───♡───┐");
					System.out.println("");
					System.out.println("   원하는 이성의 프로필을 찾고 있습니다");
					System.out.println("          기다려주세요");
					for (int i = 4; i > 0; i--) {
						if(i == 2 || i == 4) {
							System.out.print("   ♥\t");
						} else {
							System.out.print("   ♡\t");
						}
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							e.printStackTrace();

						}

					}
					PtopMatchDAO pDao = new PtopMatchDAO();
					ArrayList<UserDTO> selList = pDao.ptpMat(sDto);

					while (true) {
						if (selList.size() != 0) {
							System.out.println("");
							System.out.println("");
							System.out.println("───────────ㆍ 1 : 1 매칭 ㆍ─────────────────────────────────────────────"+" ♡");
							System.out.println("");
							System.out.println("        " + mNDto.getName() + "님께 알맞는 이성이 있습니다");
							System.out.println("");
							System.out.println("    매칭을 보내겠습니까? ─♥─> 'y'/'n'");
							correction = sc.nextLine();
							
							if (correction.equals("y")) {
								
								System.out.println("");
								System.out.println("이름\t\t나이\t\t거주지\t\t연락처");
								selList.forEach(userList -> {
									System.out.println(userList.getName() + "\t\t" + userList.getAge() + "\t\t"
											+ userList.getAddr() + "\t" + userList.getPhoneNum());
									
									pDao.msuccess(id, userList.getId());
									pDao.msuccess(userList.getId(), id);
									for (int j = 3; j > 0; j--) {
										try {
											Thread.sleep(1000);
										} catch (Exception e) {
											e.printStackTrace();
											
										}
										
									}
									
								});
								System.out.println("");
								System.out.println("───────────ㆍ 1 : 1 매칭 ㆍ───────────────────────"+" ♡");
								System.out.println("");
								System.out.println("            매칭을 보냈습니다");
								System.out.println("       소중한 인연을 만들 수 있도록");
								System.out.println("   저희 Blind Match 팀은 항상 응원합니다!");
								System.out.println("   뒤로 돌아가시려면 Enter Key를 눌려주세요");
								inputNum = sc.nextLine();
								break;
								
							} else if (correction.equals("n")) {
								
								System.out.println("");
								System.out.println("다음에 더 좋은 인연을 찾으시길 바랍니다");
								System.out.println("");
								break;
							} else {
								System.out.println("");
								System.out.println("잘못 입력하셨습니다");
								continue;
							}
							
						} else {
							System.out.println("");
							System.out.println(mNDto.getName() + "님께서 원하는 이성이 아쉽게도 없습니다 ㅠㅠ");
							System.out.println("이성정보 수정 후 다시 시도해주세요");
							System.out.println("");
							break;
							
						}
					} // while문
					

				} else if (inputNum.equals("2")) {
					break;
				}

			} else if (inputNum.equals("2")) {
				break;
			}
			break;
		}
		return "ptpMatch";

	}
}
