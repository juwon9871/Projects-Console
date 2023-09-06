package com.daissso.review;

import java.util.Scanner;

public class ReviewMain {

	public String mainReview() {
		
		Scanner sc = new Scanner(System.in);
		
		String userInput = null;
		
		ReviewFunction rF = new ReviewFunction();
		
		while (true) {
			System.out.println("──────────────────────────────────────────────────────────────────────────────♡");
			System.out.println("\t 1. 후기등록 \t 2. 후기수정 \t 3.후기조회");
			System.out.println();
			System.out.println("\t 4. 후기삭제 \t 5. 돌아가기 \t 6. 종료");
			System.out.println("──────────────────────────────────────────────────────────────────────────────♡");
			System.out.print("입력 >>>>> ");
			userInput = sc.nextLine();
			
			if (userInput.equals("1")) {
				rF.reviewInsert();
				
			} else if (userInput.equals("2")) {
				rF.reviewUpdate();
				
			} else if (userInput.equals("3")) {
				rF.reviewSelect();
				
			} else if (userInput.equals("4")) {
				rF.reviewDelete();
				
			} else if (userInput.equals("5")) {
				break;
				
			} else if (userInput.equals("6")) {
				System.exit(0);
				
			} else {
				continue;
			}
		} // while문
		return "mainReview";
	}
		
		
		
}
