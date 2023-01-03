package BankHi.Run;

import java.util.ArrayList;
import java.util.List;

import BankHi.Controller.BankController;
import BankHi.Controller.LogController;
import BankHi.Model.VO.Member;
import BankHi.Model.VO.MemberKB;
import BankHi.Model.VO.MemberSH;
import BankHi.Model.VO.SendInfo;
import BankHi.View.BankView;

public class BankRun {
	public static void main(String[] args) {
		BankView bView = new BankView();
		BankController bCon = new BankController();
		LogController logCon = new LogController();
		Member member = null;
		MemberSH memSH = null;
		MemberKB memKB = null;
		SendInfo sendInfo = null;
		List<Member> mList = new ArrayList<Member>();
		List<MemberSH> shList = new ArrayList<MemberSH>();
		List<MemberKB> kbList = new ArrayList<MemberKB>();
		
		int select = 0;
		int result = 0;

		/**-------------------------------------------------------------------------------------------------
		/ 메인 세션
		/-------------------------------------------------------------------------------------------------*/
		close:
		while(true) {
			select = bView.mainView();
			switch(select) {
			/**-------------------------------------------------------------------------------------------------
			/ 메인 - 로그인 세션
			/-------------------------------------------------------------------------------------------------*/
			case 1 : 
				member = bView.loginView();
				member = bCon.login(member);
				
				if(member==null) {								//로그인 실패
					bView.failedView("로그인");
					logCon.logging("로그인 실패", member);
				}
				else if(member.getMemberId().equals("admin")) { //관리자 로그인 성공
					bView.successView("로그인");
					logCon.logging("로그인 성공", member);
					adlogout:
					while(true) {
						select = bView.ad_menuView(member);
						switch(select) {
						case 1 :
							shList = bCon.loadSHMemberAll();
							kbList = bCon.loadKBMemberAll();
							bView.ad_memberListView(shList, kbList);
							bView.successView("전체 회원 목록 조회");
							logCon.logging("전체 회원 목록 조회", member);
							break;
						case 2 :
							break;
						case 0 :
							bView.successView("로그아웃");
							logCon.logging("로그아웃", member);
							break adlogout;
						}
					}
				}
				else if((!member.getMemberId().equals("admin"))&&(member != null)) { //일반회원 로그인 성공
					bView.successView("로그인");
					logCon.logging("로그인 성공", member);
					logout:
					while(true) {
						select = bView.menuView(member);
						switch(select) {
						case 1 : //내정보 조회
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
						case 2 : //송금
							memSH = bCon.loadSHMember(member);
							memKB = bCon.loadKBMember(member);
							sendInfo = bView.sendMoneyView(memSH, memKB);
							sendInfo = bCon.checkBank(sendInfo); //null이면 계좌존재x
							if(sendInfo!=null) {
								select = bView.sendCheckView(sendInfo);
								if(select==1) {
									String bankpwd = bView.checkPwView();
									result = bCon.checkPw(bankpwd, member);
									if(result==1) {
										bCon.sendMoney(sendInfo, memSH, memKB);
										bView.successView("타인 계좌로 송금");
										logCon.logging("타인 계좌로 송금", member);
									}
									else {
										bView.failedView("비밀번호가 일치하지 않아 송금");
										break;
									}
								}
								else if(select==2) {
									bView.successView("송금 취소");
									break;
								}
							}
							else {
								bView.failedView("계좌번호가 존재하지 않아 송금");
							}
							
							break;
						case 3 : //거래내역 조회
							break;
						case 4 : //대출신청
							break;
						case 5 : //대출현황
							break;
						case 6 : //회원정보 수정
							select = bView.modifyView();
							if(select==1) { //로그인 비밀번호 변경
								String loginpw = bView.inputPwView();
								if(loginpw.equals(member.getMemberPw())) {
									member = bView.searchPwOkView(member);
									while(true) {
										if(member.getMemberPw()==null) {
											member = bView.searchPwOkView(member);
										}
										else {
											result = bCon.modifyPw(member);
											bView.successView("로그인 비밀번호 변경");
											logCon.logging("로그인 비밀번호 변경 성공", member);
											break;
										}
									}
								}
								else
									bView.failedView("비밀번호가 일치하지 않아 비밀번호 변경");
							}
							else if(select==2) { //계좌 비밀번호 변경
								memSH = bCon.loadSHMember(member);
								memKB = bCon.loadKBMember(member);
								String bankpw = bView.checkPwView();
								result = bCon.checkBankPw(memSH, memKB, bankpw); //1이면 SH은행, 2면 KB은행, 0이면 비밀번호일치x
								switch(result) {
								case 1 : //SH은행
									bankpw = bView.ModifyBankPwView();
									result = bCon.modifySHPw(memSH, bankpw);
									if(result>0) {
										bView.successView("계좌 비밀번호 변경");
										logCon.logging("계좌 비밀번호 변경 성공", member);
									}
									else {
										bView.failedView("비밀번호가 4자리를 초과하여 변경");
									}
									break;
								case 2 : //KB은행
									bankpw = bView.ModifyBankPwView();
									result = bCon.modifyKBPw(memKB, bankpw);
									if(result>0) {
										bView.successView("계좌 비밀번호 변경");
										logCon.logging("계좌 비밀번호 변경 성공", member);
									}
									else {
										bView.failedView("비밀번호가 4자리를 초과하여 변경");
									}
									break;
								case 0 :
									bView.failedView("비밀번호가 일치하지 않아 비밀번호 변경");
									break;
								default :
									break;
								}
							}
							else
								bView.failedView("1 또는 2를 입력하지 않아 회원정보 수정");
							break;
						case 7 : //회원탈퇴
							break;
						case 0 : //로그아웃
							bView.successView("로그아웃");
							logCon.logging("로그아웃", member);
							break logout;
						default :
							break;
						}
					}
				}
				break;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//				//로그인 세션 구현 (초기버전)
////				logout://no
//
//				adlogout:
//				/**-------------------------------------------------------------------------------------------------
//				/ 로그인세션
//				/-------------------------------------------------------------------------------------------------*/
//				if (member != null) {
//					bView.successView("로그인");
//					logCon.logging("로그인 성공", member);
//					/**-------------------------------------------------------------------------------------------------
//					/ 관리자 로그인 성공
//					/-------------------------------------------------------------------------------------------------*/
//					if(member.getMemberId().equals("admin")) {
//						while(true) {
//							select = bView.ad_menuView(member);
//							switch(select) {
//							case 1:
//								mList = bCon.searchAll();
//								bView.ad_memberListView(shList, kbList);
//								break;
//							case 0:
//								break adlogout;
//							}
//						}
//					}
//
//					logout:
//					/**-------------------------------------------------------------------------------------------------
//					/ 일반회원 로그인 성공
//					/-------------------------------------------------------------------------------------------------*/
//					while (true) {
//						select = bView.menuView(member);
//						switch (select) {
//						case 1: // 내정보 조회
//							// 만약 member의 은행명이 SH면 sh멤버정보 로드, KB면 kh멤버정보 로드하도록 if문
//							if (member.getMemberBank().substring(0, 2).equals("SH")) {
//								memSH = bCon.loadSHMember(member);
//								bView.mypageView(member, memSH);
//								logCon.logging("내정보 조회 성공", member);
//							} else {
//								memKB = bCon.loadKBMember(member);
//								bView.mypageView(member, memKB);
//								logCon.logging("내정보 조회 성공", member);
//							}
//							break;
//						case 0: // 로그아웃
////							member = null;
//							bView.successView("로그아웃");
//							logCon.logging("로그아웃", member);
//							break logout;
//						default:
//							break;
//						}
//					}
//				} else {
//					bView.failedView("로그인");
//					logCon.logging("로그인 실패", member);
//				}
//				break;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			/**-------------------------------------------------------------------------------------------------
			/ 메인 - 회원가입 세션
			/-------------------------------------------------------------------------------------------------*/
			case 2 : 
				member = bView.registerView(member);
				result = bCon.registerMember(member);
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
			/ 메인 - 아이디 찾기 세션
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
			/**-------------------------------------------------------------------------------------------------
			/ 메인 - 비밀번호 찾기 세션
			/-------------------------------------------------------------------------------------------------*/
			case 4 : 
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
							bView.successView("비밀번호 찾기");
							logCon.logging("비밀번호 찾기 성공", member);
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
