package com.blinddate.matchservice;

import java.util.ArrayList;
import java.util.Scanner;

public class RandMatch {

	public String ranMatch(String id) {

		Scanner sc = new Scanner(System.in);
		String inputNum = null;
		UserDAO uDao = new UserDAO();
		UserDTO mNDto = uDao.myName(id);
		RandMatchDAO rDao = new RandMatchDAO();
		PtopMatchDAO pDao = new PtopMatchDAO();
		UserDTO sDto = rDao.selChk(id);
		while (true) {
			System.out.println("");
			System.out.println("┌──────────♥♡♥♡ Random Matching ♡♥♡♥──────────┐");
			System.out.println("♡                   "+ "                          ♡ ");
			System.out.println(" ♡           랜덤매칭은 더욱 넓은 지역과            ♡");
			System.out.println("♡           자유로운 조건 속에서 시작됩니다!          ♡");
			System.out.println(" ♡      접점이 없던 상대! 이또한 인연 아니겠어요?!     ♡");
			System.out.println("♡       1. 랜덤매칭 시작!    2. 돌아가기            ♡");
			System.out.println("");
			System.out.print("♥───♥───>    ");
			inputNum = sc.nextLine();

			if (inputNum.equals("1")) {
				System.out.println("");
				System.out.println("───────────ㆍ Random Matching ㆍ──────────────────────────────────────"+" ♡");
				System.out.println("   ♡              ♡             ♡                     ♡          ");
				System.out.println("\t" + mNDto.getName() + "님의 원하는 이성 프로필은 ♡              ♡");
				System.out.println("성별\t나이\t키\t몸무게\t주소");
				System.out.print(sDto.getGender() + "\t" + sDto.getAge() + "\t");
				System.out.print(sDto.getHeight() + "\t" + sDto.getWeight() + "\t" + sDto.getAddr());

				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("┌──────♡ Random Matching ♡───♡───♡───┐");
				System.out.println("");
				System.out.println("       원하는 이성의 프로필을 찾고 있습니다");
				System.out.println("            잠시 기다려주세요");

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
				while (true) {
					ArrayList<UserDTO> radList = rDao.randMat(sDto);
					if (radList.size() != 0) {
						System.out.println("");
						System.out.println("───────────ㆍ Random Matching ㆍ──────────────────────────────────────"+" ♡");
						System.out.println("");
						System.out.println("     " + mNDto.getName() + "님께 알맞는 이성을 소개합니다!");
						System.out.println("");


						
						radList.forEach(userList -> {
							
							System.out.println(userList.getName());
						});
						
						radList.forEach(userList -> {
							System.out.println("");
							System.out.println(userList.getName());
							System.out.println("    매칭을 보내겠습니까? ─♥─> 'y'/'n'");
							String nameSearch = sc.nextLine();
							
							if(nameSearch.equals("y")) {
								pDao.msuccess(id, userList.getId());
								System.out.println("");
								System.out.println("────────ㆍ Random Matching ㆍ─────────────────────"+" ♡");
								System.out.println("");
								System.out.println("       매칭을 보냈습니다");
								System.out.println("      소중한 인연을 만들 수 있도록");
								System.out.println("      저희 Blind Match 팀은 항상 응원합니다!");
								System.out.println("      뒤로 돌아가시려면 Enter Key를 눌려주세요");
								String enter = sc.nextLine();
							}else if(nameSearch.equals("n")) {
							}else {
							}

						});

						break;

					} else {
						System.out.println("");
						System.out.println(mNDto.getName() + "님께서 원하는 이성이 아쉽게도 없습니다 ㅠㅠ");
						System.out.println("이성정보 수정 후 다시 시도해주세요");
						System.out.println("");
						break;
					}
				} // 안쪽 while문

			} else if (inputNum.equals("2")) {
				break;
			}

		} // 바깥 while문

		return "ranMatch";
	}

}
