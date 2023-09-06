package com.blinddate.matchingResult;

import java.util.ArrayList;
import java.util.Scanner;

import com.blinddate.matchservice.UserDTO;
import com.blinddate.matchservice.AdminMatchDAO;
import com.blinddate.matchservice.PtopMatchDAO;

public class MatchingResult {
	public void matchingResult(String id) {
		
		MatchingResultDAO mDao = new MatchingResultDAO();
		Scanner sc = new Scanner(System.in);
		ArrayList<UserDTO> opList = new ArrayList<>();
		
		String msuccess =mDao.msuccess(id);	
		if(mDao.matching(id).equals("1")) {
			
			//ptop매칭 결과
			opList = mDao.ptpResultSend(id);
			if(opList.size()!=0) {
			System.out.println(id+"님 "+"매칭이 들어왔습니다.");
				System.out.println("이름\t나이\t전화번호\t\t주소");
				opList.forEach(opDataRe -> {
					System.out.println(opDataRe.getName()+"\t"+opDataRe.getAge()+"\t"
							+opDataRe.getPhoneNum()+"\t"+opDataRe.getAddr());
					System.out.println("====================");
					System.out.println("매칭을 수락하겠습니까? y/n");
					String matchCheck = sc.nextLine();
					if(matchCheck.equals("y")) {
						PtopMatchDAO pDao = new PtopMatchDAO();
						pDao.msuccess(id, msuccess);
						System.out.println("매칭이 완료 되었습니다.");
					}else if(matchCheck.equals("n")) {
						PtopMatchDAO pDao = new PtopMatchDAO();
						pDao.mfail(id);
						System.out.println("");
						System.out.println("다음에 더 좋은 인연을 찾으시길 바랍니다");
						System.out.println("");
					}else {
						System.out.println("");
						System.out.println("잘못 입력하셨습니다");
					}
				});		
			}else {
				System.out.println("매칭결과가 없습니다.");
			}
		}else if(mDao.matching(id).equals("r")) {
			//랜덤매칭 결과
			opList = mDao.ptpResultSend(id);
			if(opList.size()!=0) {
				
				System.out.println(id+"님 "+"매칭이 들어왔습니다.");
				System.out.println("이름");
				opList.forEach(opDataRe -> {
					System.out.println(opDataRe.getName());
					System.out.println("====================");
					System.out.println("매칭을 수락하겠습니까? y/n");
					String matchCheck = sc.nextLine();
					if(matchCheck.equals("y")) {
						PtopMatchDAO pDao = new PtopMatchDAO();
						pDao.msuccess(id, msuccess);
						System.out.println("매칭이 완료 되었습니다.");
						
					}else if(matchCheck.equals("n")) {
						System.out.println("");
						System.out.println("다음에 더 좋은 인연을 찾으시길 바랍니다");
						System.out.println("");
					}else {
						System.out.println("");
						System.out.println("잘못 입력하셨습니다");
					}
				});
			}else {
				System.out.println("매칭결과가 없습니다.");
			}
		}else if(mDao.matching(id).equals("a")) {
			AdminMatchDAO aDao = new AdminMatchDAO();
			UserDTO uDto = aDao.selOpUser(id);
			System.out.println(id+"님 "+"매칭 결과입니다.");
			ArrayList<UserDTO> userList2 = new ArrayList<>();

			System.out.println("이름\t전화번호\t\t성별\t나이\t키\t몸무게\t" + "주소\t\t차소유\t음주\t흡연\tmbti\t종교");
			userList2 = aDao.selOpUser(uDto.getAge(), uDto.getHeight(), uDto.getWeight(), id);

			userList2.forEach(userData -> {
				System.out.println(userData.getName() + "\t"
						+ userData.getPhoneNum() + "\t" + userData.getGender() + "\t" + userData.getAge()
						+ "\t" + userData.getHeight() + "\t" + userData.getWeight() + "\t"
						+ userData.getAddr() + "\t" + userData.getCar() + "\t" + userData.getDrink() + "\t"
						+ userData.getSmoke() + "\t" + userData.getMbti() + "\t" + userData.getRel());

			});
		}
		
		
	}
}
