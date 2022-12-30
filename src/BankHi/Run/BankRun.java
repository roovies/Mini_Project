package BankHi.Run;

import java.util.ArrayList;
import java.util.List;

import BankHi.Controller.BankController;
import BankHi.Controller.LogController;
import BankHi.Model.VO.Member;
import BankHi.Model.VO.MemberKB;
import BankHi.Model.VO.MemberSH;
import BankHi.View.BankView;

public class BankRun {
	public static void main(String[] args) {
		BankView bView = new BankView();
		BankController bCon = new BankController();
		LogController logCon = new LogController();
		Member member = null;
		MemberSH memSH = null;
		MemberKB memKB = null;
		List<Member> mList = new ArrayList<Member>();
		
		String log = "";
		int select = 0;
		int result = 0;
		
		/**-------------------------------------------------------------------------------------------------
		/ 메인세션
		/-------------------------------------------------------------------------------------------------*/
		close :
		while(true) {
			select = bView.mainView();
			switch(select) {
			case 1 : 
				member = bView.loginView();
				member = bCon.login(member);
				logout:
				/**-------------------------------------------------------------------------------------------------
				/ 로그인세션
				/-------------------------------------------------------------------------------------------------*/
				if (member != null) {
					log = bView.successView("로그인", member);
					logCon.logging(log);
					while (true) {
						select = bView.menuView(member);
						switch (select) {
						case 1: // 내정보 조회
							// 만약 member의 은행명이 SH면 sh멤버정보 로드, KB면 kh멤버정보 로드하도록 if문
							if (member.getMemberBank().substring(0, 2).equals("SH")) {
								memSH = bCon.loadSHMember(member);
								bView.mypageView(member, memSH);
							} else {
								memKB = bCon.loadKBMember(member);
								bView.mypageView(member, memKB);
							}
							break;
						case 0: // 로그아웃
							break logout;
						default:
							break;
						}
					}
				} else {
					log = bView.failedView("로그인");
					logCon.logging(log);
				}
				break;
			/**-------------------------------------------------------------------------------------------------
			/ 회원가입세션
			/-------------------------------------------------------------------------------------------------*/
			case 2 : 
				member = bView.registerView(member);
				result = bCon.registerMember(member);
				System.out.println(result);
				if(result>0) {
					if(member.getMemberBank().equals("SH은행")) {
						result = bCon.registerSHBank(member);
						if(result>0) {
						log = bView.successView("회원가입", member);
						logCon.logging(log);
						}
						else {
						log = bView.failedView("회원가입");
						logCon.logging(log);
						}
					}
				}
//				if(result>0) {
//					if("SH은행".equals(member.getMemberBank())) {
//						result = bCon.registerSHBank(member);
//						if(result>0) {
//							log = bView.successView("회원가입", member);
//							logCon.logging(log);
//						}
//						else {
//							log = bView.failedView("회원가입");
//							logCon.logging(log);
//						}
//					}
//					else {
//						result = bCon.registerKBBank(member);
//						if(result>0) {
//							log = bView.successView("회원가입", member);
//							logCon.logging(log);
//						}
//						else {
//							log = bView.failedView("회원가입");
//							logCon.logging(log);
//						}
//					}
//				}
				break;
			case 3 : break;
			case 4 : break;
			case 0 : break close;
			default : break;
			}
			
		}
	}
}
