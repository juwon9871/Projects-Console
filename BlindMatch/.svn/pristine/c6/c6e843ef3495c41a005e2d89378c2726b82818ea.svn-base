package com.blinddate.matchservice;

import java.util.Scanner;

import com.blinddate.matchservice.UserDTO;


public class UserChoice {

	public UserChoice() {

		Scanner sc = new Scanner(System.in);
		int age = 0;
		int height = 0;
		int weight = 0;
		String mbti = null;
		String car = null;
		String drink = null;
		String smoke = null;
		String rel = null;
		String addr = null;

		
		System.out.println("========원하는 상대방의 조건========");
		while(true) {
			System.out.print("1.나이 : "); 
			age = sc.nextInt();
			if(age>=20&&age<=45) {
				break;
			}else {
				System.out.println("20세~45세 사이로 입력하세요");
				continue;
			}
			
		}
		
		while(true) { // 150~200
			System.out.print("2.키 : ");
			height = sc.nextInt();
			if(height>=150&&height<=200) {
				break;
			}else {
				System.out.println("150cm~200cm 사이로 입력하세요");
				continue;
			}
		}
			
		while(true) { // 35~150
			
			System.out.print("3.몸무게 : ");
			weight = sc.nextInt();
			sc.nextLine();
			if(weight>=35&&weight<=150) {
				break;
			}else {
				System.out.println("35kg~150kg 사이로 입력하세요");
				continue;
			}
		}
		
		while(true) {
			System.out.println("4.원하는 지역 1.사는지역 2.상관없음");
			System.out.print("==>");
			String addrNum = sc.next();
			if(addrNum.equals("1")) {
				//addr= 
				break;
			}else if(addrNum.equals("2")) {
				addr=null;
				break;
			}else {
				System.out.println("다시입력하세요");
				continue;
			}
		}
		while(true) {			
			System.out.println("5.차유무 1.Y 2.N 3.상관없음");
			System.out.print("==>");
			car = sc.next();
			if(car.equals("1")) {
				car ="Y";
				break;
			}else if(car.equals("2")){
				car ="N";
				break;
			}else if(car.equals("3")){
				car = null;
				break;
			}else{
				System.out.println("다시입력하세요");
				continue;
			}
		}
		while(true) {
			
			System.out.println("6.흡연여부 => 1.Y 2.N 3.상관없음");
			System.out.print("==>");
			smoke = sc.next();
			if(smoke.equals("1")) {
				smoke ="Y";
				break;
			}else if(smoke.equals("2")){
				smoke ="N";
				break;
			}else if(smoke.equals("3")){
				smoke = null;
				break;
			}else{
				System.out.println("다시입력하세요");
				continue;
			}
		}
		
		while(true) {
			
			System.out.println("7.음주 여부 => 1.Y 2.N 3.상관없음");
			System.out.print("==>");
			drink = sc.next();
			if(drink.equals("1")) {
				drink="Y";
				break;
			}else if(drink.equals("2")){
				drink ="N";
				break;
			}else if(drink.equals("3")){
				drink = null;
				break;
			}else{
				System.out.println("다시입력하세요");
				continue;
			}
		}
		while(true) {
			System.out.print("8.원하는 MBTI(성격) :");
			mbti = sc.next().toUpperCase();
			
			if(mbti.equals("ISTJ") || mbti.equals("ISTP") || mbti.equals("ISFJ") || mbti.equals("ISFP")
                  || mbti.equals("INFJ") || mbti.equals("INTJ") || mbti.equals("INFP") || mbti.equals("INTP")
                  || mbti.equals("ESTJ") || mbti.equals("ESFP") || mbti.equals("ENFP") || mbti.equals("ENTP")
                  || mbti.equals("ESFJ") || mbti.equals("ESTP") || mbti.equals("ENFJ") || mbti.equals("ENTJ")) {
				break;
			}else {
				System.out.println("다시입력하세요.");
				continue;
			}
		}
		while(true) {
			System.out.println("9.종교 => 1.기독교 2.불교 3.천주교 4.상관없음");
			rel = sc.next();
			if(rel.equals("1")) {
				rel="christian"; //기독교
				break;
			}else if(rel.equals("2")) {
				rel="buddhism"; //불교
				break;
			}else if(rel.equals("3")) {
				rel="catolic"; //천주교
				break;
			}else if(rel.equals("4")) {
				rel=null;
				break;
			}else {
				System.out.println("다시입력하세요.");
				break;
			}
		}
		UserDTO uDto = new UserDTO();
		// Admin dao 객체 생성
		uDto.setAge(age);
		uDto.setHeight(height);
		uDto.setWeight(age);
		uDto.setAddr(addr);
		uDto.setCar(car);
		uDto.setDrink(drink);
		uDto.setMbti(mbti);
		uDto.setRel(rel);
		uDto.setSmoke(smoke);
		//uDto.setId(uDto.getId());
		

		
		UserChoiceDAO uDao = new UserChoiceDAO();

		// Admin 등록 메서드 호출
		uDao.updateUserChoice(uDto);
		
	}
}
