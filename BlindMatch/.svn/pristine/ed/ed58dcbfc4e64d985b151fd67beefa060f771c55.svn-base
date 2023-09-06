package com.blinddate.matchservice;

import java.util.ArrayList;
import java.util.Scanner;

import com.blinddate.matchservice.UserDTO;

public class AdminMatch {
	public AdminMatch() {

		Scanner sc = new Scanner(System.in);

		ArrayList<UserDTO> userList = new ArrayList<>();
		AdminMatchDAO aDao = new AdminMatchDAO();
		UserChoiceDAO uDao = new UserChoiceDAO();

		userList = aDao.selUserId();

		while (true) {
			System.out.println("=========<관리자 매칭>=========");
			System.out.println("1.매칭 신청자 2. 매칭 3. exit");
			String inputNum = sc.nextLine();
			if (inputNum.equals("1")) {

				System.out.println("아이디");
				userList.forEach(userIdList -> {
					System.out.println(userIdList.getId());
				});

			} else if (inputNum.equals("2")) {
				while (true) {
					System.out.print("매칭할 id를 입력하세요 :");
					String inputId = sc.nextLine();
					UserDTO uDto = aDao.selUser(inputId);

					try {

						ArrayList<UserDTO> userList1 = new ArrayList<>();

						System.out.println("원한는 조건: \t\t성별\t나이\t키\t몸무게\t" + "주소\t\t차소유\t음주\t흡연\tmbti\t종교");
						userList1 = aDao.selIdData(inputId);

						userList1.forEach(idData -> {
							System.out.println("\t\t\t" + idData.getGender() + "\t" + idData.getAge() + "\t"
									+ idData.getHeight() + "\t" + idData.getWeight() + "\t" + idData.getAddr() + "\t"
									+ idData.getCar() + "\t" + idData.getDrink() + "\t" + idData.getSmoke() + "\t"
									+ idData.getMbti() + "\t" + idData.getRel());

						});
						ArrayList<UserDTO> userList2 = new ArrayList<>();

						System.out.println("ID\t이름\t전화번호\t\t성별\t나이\t키\t몸무게\t" + "주소\t\t차소유\t음주\t흡연\tmbti\t종교");
						userList2 = aDao.selAllUser(uDto.getAge(), uDto.getHeight(), uDto.getWeight(), inputId);

						userList2.forEach(userData -> {
							System.out.println(userData.getId() + "\t" + userData.getName() + "\t"
									+ userData.getPhoneNum() + "\t" + userData.getGender() + "\t" + userData.getAge()
									+ "\t" + userData.getHeight() + "\t" + userData.getWeight() + "\t"
									+ userData.getAddr() + "\t" + userData.getCar() + "\t" + userData.getDrink() + "\t"
									+ userData.getSmoke() + "\t" + userData.getMbti() + "\t" + userData.getRel());

						});

					} catch (Exception e) {
						e.printStackTrace();
					}
					
					while (true) {

						System.out.println("매칭 시키겠습니까? Y/N");
						System.out.print("=====>");
						String matchFinal = sc.next();

						if (matchFinal.equals("y")) {
							while(true) {
								System.out.println("상대방 id를 입력하세요:");
								String opponent = sc.nextLine();
								if(inputId.equals(opponent)) {
									System.out.println("잘못된 정보입니다.");
									continue;
									
								}else if(opponent.equals("")) {
									System.out.println("공백입니다.");
									continue;
								}
								else {
									uDao.matchSuccess(inputId, opponent);
									uDao.matchSuccess(opponent, inputId);
									System.out.println("매칭성공!");
									break;
								}
							}
							
						} else if (matchFinal.equals("n")) {
							uDao.matchSuccess(inputId, null);
							break;
						} else {
							continue;
						}
					}
					break;
				}
			} else if (inputNum.equals("3")) {
				break;
			} else {
				continue;
			}
		}
	}
}
