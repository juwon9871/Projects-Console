package com.daissso.Member;

import java.util.Scanner;

public class daissoMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		daissoMemberDAO dmDao = new daissoMemberDAO();
		
		dmDao.firstMenu();
	}
}
