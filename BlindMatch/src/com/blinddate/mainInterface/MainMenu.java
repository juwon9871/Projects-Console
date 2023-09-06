package com.blinddate.mainInterface;

import java.util.Scanner;

import com.blinddate.LoginRegist.AdminMain;
import com.blinddate.LoginRegist.UsertableMain;
import com.blinddate.event.Coupon;
import com.blinddate.event.CouponDAO;
import com.blinddate.matchingResult.MatchingResult;
import com.blinddate.matchservice.AdminMatch;
import com.blinddate.matchservice.PtopMatch;
import com.blinddate.matchservice.RandMatch;
import com.blinddate.matchservice.UpdateUserChoice;
import com.blinddate.matchservice.UpdateUserTable;
import com.blinddate.matchservice.UserChoiceDAO;
import com.blinddate.matchservice.UserDTO;
import com.blinddate.payment.Payment;

public class MainMenu {
	public static void main(String[] args) {

		String id = null;
		String pwd = null;
		String pwdchk = null;
		String adminmenu = null;
		String adminId = null;
		String adminPwd = null;

		UsertableMain utM = new UsertableMain();
		AdminMain adM = new AdminMain();

		Scanner sc = new Scanner(System.in);
		while (true) {

			System.out.println(
					"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━♥ Blind match ♥━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("♡                                                                              ♡");
			System.out.println("♡                         <메뉴를 선택해주세요>                                     ♡");
			System.out.println("♡                                                                             ♡");
			System.out.println("♡     1.서비스소개    2.이용하기    3.결제        4.매칭          5.이달의 이벤트         ♡");
			System.out.println("♡                  [로그인]   [이용권 구매]   [상세정보 기입]                 	       ♡");
			System.out.println("♡                  [회원가입]   [결제 해지]    [랜덤매칭]                              ♡");
			System.out.println("♡                 [ID/PW찾기]  [청약철회]     [1:1매칭]                      	♡");
			System.out.println("♡                                                                               ♡");
			System.out.println("♡                                                                              ♡");
			System.out.println("♡                                                                              ♡");
			System.out.println(
					"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			System.out.print("                 이동을 원하시는 메뉴의 번호를 입력하세요 : ");
			System.out.println();

			String inputmenu = sc.nextLine();

			if (inputmenu.equals("1")) {
				System.out.println();
				System.out.println("<<<<<<<<<<<<<<<<<<<<서비스 안내 멘트>>>>>>>>>>>>>>>>>>>>>>>>");
				System.out.println();
				System.out.println("      우리 Blind Date는 새로운 만남을 위한 서비스를 제공해요");
				System.out.println("             구독형 서비스와 일회권 서비스가 있습니다");
				System.out.println("             구독형 월 100,000원 일회형 20,000원");
				System.out.println("             매칭방식은 1:1, 랜덤, 관리자가 있습니다.");
				System.out.println("         선택하신 방식에 따라 저희 알고리즘으로 매칭해 드립니다.");
				System.out.println();
				System.out.println("               ♥좋은 인연을 찾길 바랍니다♡");
				System.out.println();
				System.out.println("           메뉴를 다시 보시려면 Enter를 눌러주세요");
				inputmenu = sc.nextLine();
				continue;
			}

			if (inputmenu.equals("2")) {
				utM.usertableMain();
			}

			else if (inputmenu.equals("3")) {
				try {
					System.out.println("결제 메뉴로 이동");
					Payment pM = new Payment();
					pM.getClass();
					
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (inputmenu.equals("4")) {
				System.out.println("매칭서비스로 이동시키기");
				String matchmenu = sc.nextLine();
				while (true) {
					System.out.println("서비스를 이용할 ID를 입력하세요");
					String userId = sc.nextLine();
					System.out.println();
					System.out.println();
					System.out.println("┌──────────♥♡♥♡ Matching Menu ♡♥♡♥──────────┐");
					System.out.println(" ♡\t                  " + "                 ♡ ");
					System.out.println("♡ \t         인연을 만들어 보세요         " + "   ♡ ");
					System.out.println(" ♡    1. 본인정보기입        2. 이상형정보기입" + "    ♡ ");
					System.out.println("♡     3. 1:1매칭           4. 랜덤매칭" + "         ♡ ");
					System.out.println(" ♡    5. 매칭결과           6. 돌아가기      " + "  ♡ ");
					System.out.println(" ♡\t                  " + "                 ♡ ");
					System.out.println("♡-♡-♡-♡-♡-♡-♡-원하는 번호를 입력하세요-♡-♡-♡-♡-♡-♡-♡");
					System.out.print("♥───♥───>     ");
					System.out.println();
					String logmenu = sc.nextLine();

					if (logmenu.equals("1")) {

						UpdateUserTable userTable = new UpdateUserTable();
						userTable.UpdateUserTable(userId);
						continue;
					} else if (logmenu.equals("2")) {
						UserChoiceDAO uDao = new UserChoiceDAO();
						if(uDao.checkId(userId)==(userId)) {
							// 시연전 확인해서 == 아니면 .equals로 바꾸기
							UpdateUserChoice userchoice = new UpdateUserChoice();
							userchoice.UpdateUserChoice(userId);
							
						 } else {
							 uDao.insertUserChoice(userId);
							 UpdateUserChoice userchoice = new UpdateUserChoice();
							 userchoice.UpdateUserChoice(userId);
						 }


						continue;
					} else if (logmenu.equals("3")) {
						PtopMatch pMatch = new PtopMatch();
						pMatch.ptpMatch(userId);
						continue;
					} else if (logmenu.equals("4")) {
						RandMatch rMatch = new RandMatch();
						rMatch.ranMatch(userId);
						continue;

					} else if (logmenu.equals("5")) {
						MatchingResult mResult = new MatchingResult();
						mResult.matchingResult(userId);
						continue;
					} else if (logmenu.equals("6")) {
						break;
					} else {
						continue;
					}

				}
			} else if (inputmenu.equals("5")) {
				while (true) {
					System.out.println();
					System.out.println();
					System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━♥ Blind match ♥━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ");
					System.out.println("♡                                                       ♡ ");
					System.out.println("♡                       이달의 이벤트                       ♡");
					System.out.println("♡                                                       ♡");
					System.out.println("♡                   흔들리는 꽃들 속에서~                     ♡");
					System.out.println("♡                                                       ♡");
					System.out.println("♡                   네 쿠폰향이 느껴진거야~                   ♡");
					System.out.println("♡                                                       ♡");
					System.out.println("♡                 이달의 쿠폰번호 : Spring345                ♡");
					System.out.println("♡                   수령 하시겠습니까? y/n                    ♡");
					System.out.println("♡-♡-♡-♡-♡-♡-♡-♡-♡-♡-♡-♡-♡-♡-♡-♡-♡-♡-♡-♡-♡-♡-♡-♡-♡-♡-♡-♡-♡-♡-♡");
					System.out.println();
					String event = sc.nextLine();
					System.out.println("서비스를 이용할 ID를 입력하세요");
					String userId = sc.nextLine();

					if (event.equals("y")) {
						UserDTO uDto = new UserDTO();
						CouponDAO cDao = new CouponDAO();
						uDto = cDao.selCoupon("4월");
						cDao.updateCoupon(uDto, userId);
						break;

					} else if (event.equals("n")) {
						break;
					} else {
						continue;
					}

				}
			}
			// @@@@@@@@@@@@@@@@@@ 5번 메뉴 이동@@@@@@@@@@@@@@@@@@@@@@@@@
			else if (inputmenu.equals("admin mode")) {

				while (true) {
					System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━♥ 관리자 채널 ♥━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ");
					System.out.println(" ♡                                                    ♡");
					System.out.println("♡             1.관리자계정 관리      2.관리자 매칭            ♡");
					System.out.println(" ♡                                                    ♡");
					System.out.println("♡             3.이벤트 등록         4.메인메뉴로         ♡");
					System.out.println(" ♡                                                    ♡");
					System.out.println("♡-♡-♡-♡-♡-♡-♡-♡- 원하시는 기능의 번호를 입력하세요 -♡-♡-♡-♡-♡-♡-♡-♡-♡");
					adminmenu = sc.nextLine();

					if (adminmenu.equals("1")) {
						adM.adminMain();

					} else if (adminmenu.equals("2")) {

						System.out.println("관리자매칭");
						sc.nextLine();
						AdminMatch aMatch = new AdminMatch();
						aMatch.getClass();

					} else if (adminmenu.equals("3")) {
						Coupon coupon = new Coupon();
						coupon.getClass();

					} else if (adminmenu.equals("4")) {
						break;

					} else {
						System.out.println();
						System.out.println("                        메뉴를 확인해주세요(˘･_･˘)");
						System.out.println();

					}
				}
			} else {
				System.out.println();
				System.out.println("                        메뉴를 확인해주세요(˘･_･˘)");
			}
		}
	}
}
