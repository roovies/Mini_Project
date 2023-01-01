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
		
		int select = 0;
		int result = 0;
		
		/**-------------------------------------------------------------------------------------------------
		/ 관리자 세션
		/-------------------------------------------------------------------------------------------------*/
		
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
					bView.successView("로그인");
					logCon.logging("로그인 성공", member);
					while (true) {
						select = bView.menuView(member);
						switch (select) {
						case 1: // 내정보 조회
							// 만약 member의 은행명이 SH면 sh멤버정보 로드, KB면 kh멤버정보 로드하도록 if문
							if (member.getMemberBank().substring(0, 2).equals("SH")) {
								memSH = bCon.loadSHMember(member);
								bView.mypageView(member, memSH);
								logCon.logging("내정보 조회 성공", member);
							} else {
								memKB = bCon.loadKBMember(member);
								bView.mypageView(member, memKB);
								logCon.logging("내정보 조회 성공", member);
							}
							break;
						case 0: // 로그아웃
							bView.successView("로그아웃");
							logCon.logging("로그아웃", member);
							break logout;
						default:
							break;
						}
					}
				} else {
					bView.failedView("로그인");
					logCon.logging("로그인 실패", member);
				}
				break;
			/**-------------------------------------------------------------------------------------------------
			/ 회원가입세션
			/-------------------------------------------------------------------------------------------------*/
			case 2 : 
				member = bView.registerView(member);
				result = bCon.registerMember(member);
				System.out.println(result);
				if(result>0) { //회원가입 성공
					if(member.getMemberBank().equals("SH은행")) {
						result = bCon.registerSHBank(member);
						if(result>0) {
						bView.successView("회원가입");
						logCon.logging("회원가입 성공", member);
						}
						else {
						bView.failedView("회원가입");
						logCon.logging("회원가입 실패", member);
						}
					}
					else {
						result = bCon.registerKBBank(member);
						if(result>0) {
							bView.successView("회원가입");
							logCon.logging("회원가입 성공", member);
						}
						else {
							bView.failedView("회원가입");
							logCon.logging("회원가입 실패", member);
						}
					}
				}
				else {
					bView.failedView("회원가입");
					logCon.logging("회원가입 실패", member);
				}
				break;
			/**-------------------------------------------------------------------------------------------------
			/ 아이디찾기세션
			/-------------------------------------------------------------------------------------------------*/
			case 3 : 
				member = bView.searchIdView(member);
				mList = bCon.searchAll();
				member = bCon.searchId(mList, member);
				if(member.getMemberId()==null) //검색된 정보의 아이디가 존재하지 않음
					bView.searchNoView();
				else { //아이디 존재
					bView.searchIdOkView(member);
					logCon.logging("아이디 찾기 성공", member);					
				}
				break;
			case 4 : //비밀번호 찾기
				member = bView.searchPwView(member);
				mList = bCon.searchAll();
				member = bCon.searchPw(mList, member);
				if(member.getMemberPw()==null) {
					bView.searchNoView();
					logCon.logging("비밀번호 찾기 시도 실패", member);
				}
				else {
					member = bView.searchPwOkView(member);
					while(true) {
						if(member.getMemberPw()==null)
							bView.searchPwOkView(member);
						else {
							result = bCon.modifyPw(member);
							bView.successView("비밀번호 변경");
							logCon.logging("비밀번호 변경 성공", member);
							break;
						}
					}
				}
				break;
			case 0 : break close;
			default : break;
			}
			
		}
	}
}
