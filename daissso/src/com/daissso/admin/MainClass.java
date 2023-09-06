package com.daissso.admin;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		String id = null;
		String pwd = null;
		String name = null;

		String pno = null;
		String pname = null;
		String price = null;
		String publisher = null;
		String category = null;
		bookManageDAO bMDAO = new bookManageDAO();

		Scanner sc = new Scanner(System.in);
		int inputMenu = 0;
		int adminMenu = 0;

		while (true) {
			System.out.println("==============================");
			System.out.println("1.회원가입 2.관리자 3.종료 ");
			System.out.println("==============================");

			System.out.println("원하시는 메뉴를 선택해 주세요 ==>");

			inputMenu = sc.nextInt();

			if (inputMenu == 1) {
				// 회원가입 로직 작성
				while (true) {
					System.out.println("id를 입력하세요 : ");
					sc.next(); // 엔터키 입력을 실행으로 받아줘서 써놓는 아이
					id = sc.nextLine();

					if (id.equals("")) {
						continue;
					} else {
						break;
					}
				}

				while (true) {
					System.out.println("pw를 입력하세요 : ");
					pwd = sc.nextLine();

					if (pwd.equals("")) {
						continue;
					} else {
						break;
					}

				}

				while (true) {
					System.out.println("이름을 입력하세요 : ");
					name = sc.nextLine();

					if (name.equals("")) {
						continue;
					} else {
						break;
					}
				}

				if (!id.equals("") && !pwd.equals("") && !name.equals("")) {

					daisssoDTO dDto = new daisssoDTO(id, pwd, name);

					daisssoDAO dDao = new daisssoDAO();

					dDao.insertMember(dDto);

				}

			} else if (inputMenu == 2) {
				// 관리자 메뉴 영역
				bMDAO.adminMenu();
			} else if (adminMenu == 2) {

			} else if (adminMenu == 3) {
				
			} else if (adminMenu == 4) {
//===================< 도서 삭제 > =====================================

				

			} else if (inputMenu == 3) {
				// 종료
				break;
			} else {
				System.out.print("다시 입력해 주세요");
				continue; // while문 시작점으로 돌아감
			}

		}
	}
}