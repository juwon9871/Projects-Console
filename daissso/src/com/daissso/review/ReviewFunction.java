package com.daissso.review;

import java.util.ArrayList;
import java.util.Scanner;

public class ReviewFunction {
	public String reviewInsert() {
		
		// 변수 초기화 및 선언, 객체 생성
		Scanner sc = new Scanner(System.in);
		
		int result = 0;
		String id = null;
		String book = null;
		String bookName = null;
		String title = null;
		String text = null;
		
		
		while (true) {
			System.out.println();
			System.out.println("되돌아가려면 '2'를 입력하시고");
			System.out.print("등록 하시려면 아이디를 입력하세요 >>> ");
			id = sc.nextLine();
			
			if (id.equals("2")) {
				break;
			}
			ArrayList<ReviewDTO> bList = new ArrayList<>();
			ReviewDAO sDao = new ReviewDAO();
			ReviewDTO sDto = new ReviewDTO();
			sDto.setUserid(id);
			bList = sDao.buyList(sDto);
			if (bList.size() == 0) {
				System.out.println("구매한 책이 없습니다.");
				break;
			} else {
				System.out.println("아이디 : " + sDto.getUserid());
				for (int i = 0; i < bList.size(); i++) {
					bList.get(i).getUserid();
					bList.get(i).getRbook();
					System.out.println();
					System.out.println("책제목 : " + bList.get(i).getRbook());
				}
			}
			
			
			System.out.println();
			System.out.print("책의 제목을 입력하세요 >>> ");
			book = sc.nextLine();
			
			
			for (int i = 0; i < bList.size(); i++) {
				bookName = bList.get(i).getRbook();
				
				if (book.equals(bookName)) {
					break;
				}
			}
			
			if (book.equals(bookName)) {
				System.out.println();
				System.out.print("후기 제목을 입력하세요 >>> ");
				title = sc.nextLine();
				
				System.out.println();
				System.out.print("후기의 자세한 내용을 입력하세요 >>> ");
				text = sc.nextLine();
				
				ReviewDTO rDto = new ReviewDTO();
				rDto.setUserid(id);
				rDto.setRbook(book);
				rDto.setRtitle(title);
				rDto.setRtext(text);
				
				ReviewDAO rDao = new ReviewDAO();
				
				result = rDao.insertReview(rDto);
				
				if (result > 0) {
					System.out.println();
					System.out.println("후기가 등록되었습니다.");
					System.out.println();
					break;
				} else {
					System.out.println();
					System.out.println("후기 등록 실패했습니다.");
					System.out.println();
					continue;
				}
				
			} else {
				System.out.println();
				System.out.println("잘못입력했습니다.");
				continue;
			}
			
			
		}
		return "reviewInsert";
	} // Insert 중괄호
	
	public String reviewUpdate() {
		
		// 변수 초기화 및 선언, 객체 생성
				Scanner sc = new Scanner(System.in);
				
				int result = 0;
				int no = 0;
				int num =0;
				String id = null;
				String title = null;
				String text = null;
				String userInputNum = null;
		
		while (true) {
			System.out.println();
			System.out.print("아이디를 입력하세요 >>> ");
			id = sc.nextLine();
			
			ArrayList<ReviewDTO> selfList = new ArrayList<>();
			ReviewDAO selDao = new ReviewDAO();
			ReviewDTO sfDto = new ReviewDTO();
			sfDto.setUserid(id);
			selfList = selDao.selfReview(sfDto);
			if (selfList.size() == 0) {
				System.out.println();
				System.out.println("등록하신 후기가 없습니다.");
				continue;
			} else if (id.equals(sfDto.userid)) {
				for (int i = 0; i < selfList.size(); i++) {
					selfList.get(i).getNo();
					selfList.get(i).getRbook();
					selfList.get(i).getRtitle();
					selfList.get(i).getRegistered();
					System.out.println();
					System.out.println("──────────────────────────────────────────────────────────────────────────────♡");
					System.out.println("\t│번호 : " + selfList.get(i).getNo() + "│" + "\t│구매한 책: " + selfList.get(i).getRbook() + "│" + "\t\t│제목 : " + selfList.get(i).getRtitle() + "│" + "\t│등록일" + selfList.get(i).getRegistered() + "│");
					System.out.println("──────────────────────────────────────────────────────────────────────────────♡");
					System.out.println();
				}
				
			}
			System.out.println();
			System.out.println("수정할 후기 번호를 입력하세요");
			System.out.println("되돌아가려면 Enter Key를 입력해주세요");
			System.out.print(" >>> ");
			userInputNum = sc.nextLine();
			
			if (userInputNum.equals("")) {
				continue;
			} else {
				try {
					no = Integer.parseInt(userInputNum);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			for (int i = 0; i < selfList.size(); i++) {
				num = selfList.get(i).getNo();
				
				if (no == num) {
					break;
				}
			}
			if (no == num) {
				System.out.println();
				System.out.print("제목을 다시 써주세요 >>> ");
				title = sc.nextLine();
				
				System.out.println();
				System.out.println("내용을 다시 써주세요 >>> ");
				text = sc.nextLine();
				
				ReviewDTO upDto = new ReviewDTO();
				upDto.setNo(no);
				upDto.setRtitle(title);
				upDto.setRtext(text);
				ReviewDAO upDao = new ReviewDAO();
				
				result = upDao.updateReview(upDto);
				
				if (result > 0) {
					System.out.println("수정하여 등록 되었습니다.");
					break;
				} else {
					System.out.println("등록 실패했습니다.");
					continue;
				}
			} else {
				System.out.println("번호를 잘못입력했습니다.");
				continue;
			}
			
			
		} // 2번 입력 while 문
		return "reviewUpdate";
	} // Update 중괄호
	
	public String reviewSelect() {
		
		// 변수 초기화 및 선언, 객체 생성
		Scanner sc = new Scanner(System.in);
		
		int no = 0;
		int num =0;
		int reviewNum = 4;
		int page = 1;
		int inputPage = 0;
		String userInputNum = null;
		String userInput = null;
		
		while (true) {
			System.out.println();
			ArrayList<ReviewDTO> selList = new ArrayList<>();
			ReviewDTO sDto = new ReviewDTO();
			ReviewDAO sDao = new ReviewDAO();
			selList = sDao.selectReview(sDto);
			
			for (int i = 0; i < selList.size(); i++) {
				selList.get(i).getNo();
				selList.get(i).getRbook();
				selList.get(i).getRtitle();
				selList.get(i).getRegistered();
				System.out.println("──────────────────────────────────────────────────────────────────────────────♡");
				System.out.println("\t번호 : "+ selList.get(i).getNo() + "\t\t 책 제목 : " + selList.get(i).getRbook() + "\t\t 후기제목 : " + selList.get(i).getRtitle() 
						+ "\t 등록일 : " + selList.get(i).getRegistered());
				System.out.println("──────────────────────────────────────────────────────────────────────────────♡");
				if (i == reviewNum) {
					System.out.println("다음 페이지의 번호를 누르면 페이지가 넘어갑니다. ");
					System.out.println("전 페이지의 번호를 누르면 페이지가 전으로 넘어갑니다. ");
					System.out.println("0을 누르면 끝납니다.");
					System.out.print("현재 페이지는" + page +" 페이지 입니다. ");
					inputPage = sc.nextInt();
					sc.nextLine();
					page +=1;
					if (inputPage == 1) {
						i = 0;
						page = 1;
						reviewNum = 4;
						continue;
					} else if (inputPage == page) {
							reviewNum += 5;
							continue;
					} else if (inputPage == page-2) {
						i -= 5;
						page -= 2;
						reviewNum -= 5;
						continue;
					} else if (inputPage == 0) {
						break;
					} else {
						System.out.println("잘못입력했습니다.");
						break;
					}
				}
			}
			System.out.println();
			System.out.println("자세히 보시려면");
			System.out.println("번호를 눌려주세요");
			System.out.println("되돌아가려면 Enter Key를 입력해주세요");
			System.out.print(" >>> ");
			userInputNum = sc.nextLine();
			
			if (userInputNum.equals("")) {
				break;
			} else {
				try {
					no = Integer.parseInt(userInputNum);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				for (int i = 0; i < selList.size(); i++) {
					num = selList.get(i).getNo();
					
					if (no == num) {
						break;
					}
				}
				
				if (no == num) {
					
					ReviewDAO nDao = new ReviewDAO();
					ReviewDTO nDto = nDao.review(no);
					nDto.setNo(no);
					
					System.out.println("──────────────────────────────────────────────────────────────────────────────♡");
					System.out.println("제목\t\t등록일");
					System.out.println(nDto.getRtitle() + "\t\t" + nDto.getRegistered());
					System.out.println();
					System.out.println("내용");
					for (int i = 0; i < nDto.getRtext().length(); i++) {
						System.out.print(nDto.getRtext().charAt(i));
						if (i >= 20) {
							if (i % 40 == 0) {
								System.out.println();
							}
						}
					}
					System.out.println();
					System.out.println("──────────────────────────────────────────────────────────────────────────────♡");
					System.out.println();
					while (true) {
						System.out.println("되돌아가시려면 Enter Key를 눌려주세요");
						userInput = sc.nextLine();
						
						if (userInput.equals("")) {
							break;
						} else {
							System.out.println("잘못입력했습니다.");
							continue;
						}
					}
				} else {
					System.out.println();
					System.out.println("잘못입력하셨습니다.");
					System.out.println();
				}
			}
			
		} // 3번 입력 while 문
		
		
		return "reviewSelect";
	} // Select 중괄호
	
	public String reviewDelete() {
		
		// 변수 초기화 및 선언, 객체 생성
		Scanner sc = new Scanner(System.in);
		
		int result = 0;
		int no = 0;
		String id = null;
		String userInputNum = null;
		String userInput = null;
		
		while (true) {
			System.out.println();
			System.out.println("정말 삭제하시겠습니까?");
			System.out.println("삭제 하시려면 ");
			System.out.println("1번을 되돌아가려면 2번을");
			System.out.println("눌려주세요");
			System.out.print(" >>> ");
			userInput = sc.nextLine();
			if (userInput.equals("1")) {
				System.out.println("아이디를 입력해주세요");
				id = sc.nextLine();
				
				ArrayList<ReviewDTO> selfList = new ArrayList<>();
				ReviewDAO selDao = new ReviewDAO();
				ReviewDTO sfDto = new ReviewDTO();
				sfDto.setUserid(id);
				selfList = selDao.selfReview(sfDto);
				if (id.equals(sfDto.userid)) {
					for (int i = 0; i < selfList.size(); i++) {
						selfList.get(i).getNo();
						selfList.get(i).getRbook();
						selfList.get(i).getRtitle();
						selfList.get(i).getRegistered();
						System.out.println("──────────────────────────────────────────────────────────────────────────────♡");
						System.out.println("번호 : " + selfList.get(i).getNo() + "\t\t책제목 : " + selfList.get(i).getRbook());
						System.out.println("제목 : " + selfList.get(i).getRtitle() + "\t" +"\t\t등록일 : " + selfList.get(i).getRegistered());
						System.out.println("──────────────────────────────────────────────────────────────────────────────♡");
					}
					
				}
				
				while (true) {
					System.out.println();
					System.out.println("되돌아가려면 Enter Key를 입력해주세요");
					System.out.println("후기를 지우려면 번호를 입력해주세요");
					System.out.print(">>> ");
					userInputNum = sc.nextLine();
					
					if (userInputNum.equals("")) {
						break;
					} else {
						try {
							no = Integer.parseInt(userInputNum);
						} catch (Exception e) {
							e.printStackTrace();
						}
						
						ReviewDTO delDto = new ReviewDTO();
						delDto.setNo(no);
						ReviewDAO delDao = new ReviewDAO();
						result = delDao.deleteReview(delDto);
						
						if (result > 0) {
							System.out.println("삭제되었습니다.");
							break;
						} else {
							System.out.println("번호를 잘못입력하셨습니다.");
							continue;
							
						}
						
					}
					
				}
				
				
				
				
			} else if (userInput.equals("2")) {
				break;
			} else {
				System.out.println("잘못입력하셨습니다.");
				continue;
			}
			break;
		} // 4번 입력 while 문
		
		return "reviewDelete";
	} // Delete 중괄호

} // 클래스 중괄호
