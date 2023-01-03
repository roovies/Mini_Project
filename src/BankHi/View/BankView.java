package BankHi.View;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import BankHi.Model.VO.Member;
import BankHi.Model.VO.MemberKB;
import BankHi.Model.VO.MemberSH;
import BankHi.Model.VO.SendInfo;

public class BankView {
	Scanner sc;

	public BankView() {
		sc = new Scanner(System.in);
	}
	/**-------------------------------------------------------------------------------------------------
	/ 메인 뷰
	/-------------------------------------------------------------------------------------------------*/
	public int mainView() {
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■\t간편 송금 계좌 관리 프로그램 BankHi입니다. 로그인 후 이용바랍니다.\t■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 아이디 찾기");
		System.out.println("4. 비밀번호 찾기");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 >> ");
		int select = sc.nextInt();
		return select;
	}
	
	
	/**-------------------------------------------------------------------------------------------------
	/ 관리자 메뉴 뷰
	/-------------------------------------------------------------------------------------------------*/
	public int ad_menuView(Member member) {
		System.out.println();
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■\t\t\t\t"+member.getMemberName()+"님 환영합니다. *^^*\t\t\t■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("1. 전체 회원 목록");
		System.out.println("2. 대출상품 목록");
		System.out.println("3. 대출상품 추가");
		System.out.println("4. 대출상품 삭제");
		System.out.println("0. 로그아웃");
		System.out.print("선택 >> ");
		int select = sc.nextInt();
		return select;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 전체회원 목록 조회
	/-------------------------------------------------------------------------------------------------*/
	public void ad_memberListView(List<MemberSH> memSH, List<MemberKB> memKB) {
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.printf("%6s %13s %9s %9s %15s %s %s %8s %12s \n",
						"[이름]", "[아이디]", "[은행명]", "[계좌번호]", "[잔액]", "[대출가능여부]", "[대출받은 금액]", "[대출한도]", "[가입일]");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		for(int i=0; i<memSH.size(); i++) {
			System.out.printf("%6s ", memSH.get(i).getMemberName());
			System.out.printf("%13s ", memSH.get(i).getMemberId());
			System.out.printf("%10s ", memSH.get(i).getMemberBank());
			System.out.printf("%16s ", memSH.get(i).getShNum());
			System.out.printf("%15s원 ", memSH.get(i).getShBalance());
			System.out.printf("%7s ", memSH.get(i).getLoanYn());
			System.out.printf("%15s원 ", memSH.get(i).getLoanMoney());
			System.out.printf("%15s원 ", memSH.get(i).getLoanLimit());
			System.out.printf("%15s ", memSH.get(i).getEnrollDate());
			System.out.println();
		}
		for(int i=0; i<memKB.size(); i++) {
			System.out.printf("%6s ", memKB.get(i).getMemberName());
			System.out.printf("%13s ", memKB.get(i).getMemberId());
			System.out.printf("%10s ", memKB.get(i).getMemberBank());
			System.out.printf("%16s ", memKB.get(i).getKbNum());
			System.out.printf("%15s원 ", memKB.get(i).getKbBalance());
			System.out.printf("%7s ", memKB.get(i).getLoanYn());
			System.out.printf("%15s원 ", memKB.get(i).getLoanMoney());
			System.out.printf("%15s원 ", memKB.get(i).getLoanLimit());
			System.out.printf("%15s ", memKB.get(i).getEnrollDate());
			System.out.println();
		}
	}
	
	
	/**-------------------------------------------------------------------------------------------------
	/ 로그인 뷰
	/-------------------------------------------------------------------------------------------------*/
	public Member loginView() {
		System.out.println();
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■\t\t\t아이디와 비밀번호를 입력하세요. \t\t\t■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.print("ID >> ");
		String memberId = sc.next();
		System.out.print("Password >> ");
		String memberPw = sc.next();
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		return member;
	}
	
	
	/**-------------------------------------------------------------------------------------------------
	/ 아이디 찾기 뷰
	/-------------------------------------------------------------------------------------------------*/
	public Member searchIdView(Member member) {
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■\t\t\t아\t이\t디\t찾\t기\t\t\t■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("※ 가입 시 입력한 이름과 핸드폰 번호를 입력하세요. ");
		System.out.println("■ 이름을 입력하세요.");
		System.out.print("  입력 >> ");
		String searchName = sc.next();
		System.out.println("■ 핸드폰 번호를 입력하세요. (예시: 010-1234-1234)");
		System.out.print("  입력 >> ");
		String searchPhone = sc.next();
		member = new Member();
		member.setMemberName(searchName);
		member.setMemberPhone(searchPhone);
		return member;
	}
	
	public void searchIdOkView(Member member) {
		System.out.println("  [*] \""+member.getMemberName()+"\"님의 아이디는 "+member.getMemberId()+" 입니다.");
	}
	public void searchNoView() {
		System.out.println("  [*] 입력한 정보로 등록된 회원이 존재하지 않습니다.");
	}
	
	
	/**-------------------------------------------------------------------------------------------------
	/ 비밀번호 찾기 뷰
	/-------------------------------------------------------------------------------------------------*/
	public Member searchPwView(Member member) {
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■\t\t비\t밀\t번\t호\t찾\t기\t\t\t■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("※ 아이디와 이름 핸드폰 번호를 입력하세요. ");
		System.out.println("■ 아이디를 입력하세요.");
		System.out.print("  입력 >> ");
		String searchId = sc.next();
		System.out.println("■ 이름을 입력하세요.");
		System.out.print("  입력 >> ");
		String searchName = sc.next();
		System.out.println("■ 핸드폰 번호를 입력하세요. (예시: 010-1234-1234)");
		System.out.print("  입력 >> ");
		String searchPhone = sc.next();
		member = new Member();
		member.setMemberId(searchId);
		member.setMemberName(searchName);
		member.setMemberPhone(searchPhone);
		return member;
	}
	
	public Member searchPwOkView(Member member) {
		System.out.println("■ 새 비밀번호를 입력하세요.");
		System.out.print("  입력 >> ");
		String inputPw = sc.next();
		System.out.println("■ 비밀번호를 한 번 더 입력하세요.");
		System.out.print("  입력 >> ");
		String inputPw2 = sc.next();
		if(!inputPw.equals(inputPw2)) {
			System.out.println("입력한 비밀번호가 일치하지 않습니다. 다시 입력하세요.");
			member.setMemberPw(null);
			return member;
		}
		else {
			member.setMemberPw(inputPw);
			return member;
		}
	}
	
	
	/**-------------------------------------------------------------------------------------------------
	/ 회원가입 뷰
	/-------------------------------------------------------------------------------------------------*/
	public Member registerView(Member member) {
		//계좌번호 랜덤 생성
		String memberBank = "";
		String bankNum;
		Random rand = new Random();
		int randNum = rand.nextInt(999999999);
		/////////////////////////////////////////
		System.out.println();
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■\t\t\t회\t원\t가\t입\t\t\t\t■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■ 아이디를 입력하세요. (최대 20Byte)");
		System.out.print("  입력 >> ");
		String memberId = sc.next();
		System.out.println("■ 패스워드를 입력하세요. (최대 20Byte)");
		System.out.print("  입력 >> ");
		String memberPw = sc.next();
		System.out.println("■ 이름을 입력하세요. ");
		System.out.print("  입력 >> ");
		String memberName = sc.next();
		System.out.println("■ 성별을 입력하세요.  ('남' 또는 '여'로 입력)");
		System.out.print("  입력 >> ");
		String memberGender = sc.next();
		System.out.println("■ 주민등록번호를 입력하세요. (예시: 950505-1100223)");
		System.out.print("  입력 >> ");
		String memberSSN = sc.next();
		System.out.println("■ 핸드폰 번호를 입력하세요. (예시: 010-1234-1234)");
		System.out.print("  입력 >> ");
		String memberPhone = sc.next();
		System.out.println("■ 이메일을 입력하세요. (예시: bkh15@bankhi.co.kr)");
		System.out.print("  입력 >> ");
		String memberEmail = sc.next();
		System.out.println("■ 주소를 입력하세요. (예시: 서울시 강남구 도곡동 123)");
		System.out.print("  입력 >> ");
		sc.nextLine();
		String memberAddr = sc.nextLine();
		System.out.println("■ 사용하실 은행을 선택하세요.");
		System.out.println("1. SH은행\n2. KB은행");
		while(true) {
			System.out.print("  입력 >> ");
			int choice = sc.nextInt();
			if(choice==1) {
				memberBank = "SH은행";
				break;
			}
			else if(choice==2) {
				memberBank = "KB은행";
				break;
			}
			else {
				System.out.println("※ 1 또는 2를 입력해야 합니다. 다시 시도하세요.");
			}
		}
		System.out.println("■ 통장 비밀번호를 입력하세요. (4자리)");
		System.out.print("  입력 >> ");
		String bankPw = sc.next();
		//계좌번호 랜덤발급
		if(memberBank.equals("SH은행")) {
			bankNum = "110"+String.valueOf(randNum);
		}
		else
			bankNum = "1002"+String.valueOf(randNum);
		member = new Member(memberId, memberPw, memberName, memberGender, memberSSN, memberPhone, memberEmail, memberAddr, memberBank, bankNum, bankPw);
		return member;
	}
	
	
	/**-------------------------------------------------------------------------------------------------
	/ 메뉴 뷰
	/-------------------------------------------------------------------------------------------------*/
	public int menuView(Member member) {
		System.out.println();
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■\t\t\t\t"+member.getMemberName()+"님 환영합니다. *^^*\t\t\t■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("1. 내정보 조회");
		System.out.println("2. 송금하기");
		System.out.println("3. 거래내역 조회");
		System.out.println("4. 대출신청");
		System.out.println("5. 대출현황");
		System.out.println("6. 회원정보 수정");
		System.out.println("7. 회원탈퇴");
		System.out.println("0. 로그아웃");
		System.out.print("선택 >> ");
		int select = sc.nextInt();
		return select;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 내 정보 조회 뷰 (Overloading)
	/-------------------------------------------------------------------------------------------------*/
	public void mypageView(Member member, MemberSH memSH) {
		System.out.println();
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■\t\t\t\t"+member.getMemberName()+"님의 마이페이지\t\t\t\t■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("[아이디] "+member.getMemberId()+"\t\t[패스워드] ********\t\t[가입일] "+member.getEnrollDate());
		System.out.println("[이름] "+member.getMemberName()+"\t\t[성별] "+member.getMemberGender()+"\t\t\t[생년월일]"+member.getMemberSSN().substring(0, 6));
		System.out.println("[은행명] "+member.getMemberBank()+"\t\t[계좌번호] "+memSH.getShNum()+"\t\t[잔액] "+memSH.getShBalance()+"원");
		System.out.println("[대출가능여부] "+memSH.getLoanYn()+"\t[대출한도] "+memSH.getLoanLimit()+"원 \t\t[상환할 금액] "+memSH.getLoanMoney()+"원");
	}
	
	public void mypageView(Member member, MemberKB memKB) {
		System.out.println();
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■\t\t\t\t"+member.getMemberName()+"님의 마이페이지\t\t\t\t■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("[아이디] "+member.getMemberId()+"\t\t[패스워드] ********\t\t[가입일] "+member.getEnrollDate());
		System.out.println("[이름] "+member.getMemberName()+"\t\t[성별] "+member.getMemberGender()+"\t\t\t[생년월일]"+member.getMemberSSN().substring(0, 6));
		System.out.println("[은행명] "+member.getMemberBank()+"\t\t[계좌번호] "+memKB.getKbNum()+"\t[잔액] "+memKB.getKbBalance()+"원");
		System.out.println("[대출가능여부] "+memKB.getLoanYn()+"\t[대출한도] "+memKB.getLoanLimit()+"원 \t\t[상환할 금액] "+memKB.getLoanMoney()+"원");
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 타인 계좌로 송금 뷰
	/-------------------------------------------------------------------------------------------------*/
	public SendInfo sendMoneyView(MemberSH memSH, MemberKB memKB) {
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■\t\t\t\t타인 계좌로 송금\t\t\t\t■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		int money = 0;
		String accountNum = "";
		String bankName = "";
		int choice = 0;
		if(memKB==null) { //송금자가 SH은행일 경우
			System.out.println("■ 현재 "+memSH.getMemberName()+"님의 송금 가능 잔액은 "+memSH.getShBalance()+"원 입니다.");
			while(true) {
				System.out.println("1. 보낼 금액을 입력하세요. ");
				System.out.print("  입력 >> ");
				money = sc.nextInt();
				if(money>memSH.getShBalance()) {
					System.out.println("※ 잔액이 부족합니다. 다시 입력하세요.");
					System.out.println();
				}
				else if(money<1) {
					System.out.println("※ 1원 이상의 금액을 입력하세요.");
					System.out.println();
				}
				else
					break;
			}
			System.out.println("2. 받으실 분의 계좌번호를 하이픈(-)을 제외한 숫자로만 입력하세요.");
			System.out.print("  입력 >> ");
			accountNum = sc.next();
			System.out.println("3. 은행을 선택하세요.");
			while(true) {
				System.out.println("[1]SH은행  [2]KB은행");
				System.out.print("  입력 >> ");
				choice = sc.nextInt();
				if(choice==1) {
					bankName = "SH은행";
					break;
				}
				else if(choice==2) {
					bankName = "KB은행";
					break;
				}
				else {
					System.out.println("※ 1 또는 2를 입력해야 합니다. 다시 시도하세요.");
					System.out.println();
				}
			}
			SendInfo sendInfo = new SendInfo(bankName, accountNum, money);
			return sendInfo;
		}
		else { //송금자가 KB은행일 경우
			System.out.println("■ 현재 "+memKB.getMemberName()+"님의 송금 가능 잔액은 "+memKB.getKbBalance()+"원 입니다.");
			while(true) {
				System.out.println("1. 보낼 금액을 입력하세요. ");
				System.out.print("  입력 >> ");
				money = sc.nextInt();
				if(money>memKB.getKbBalance()) {
					System.out.println("※ 잔액이 부족합니다. 다시 입력하세요.");
					System.out.println();
				}
				else if(money<1) {
					System.out.println("※ 1원 이상의 금액을 입력하세요.");
					System.out.println();
				}
				else
					break;
			}
			System.out.println("2. 받으실 분의 계좌번호를 하이픈(-)을 제외한 숫자로만 입력하세요.");
			System.out.print("  입력 >> ");
			accountNum = sc.next();
			System.out.println("3. 은행을 선택하세요.");
			while(true) {
				System.out.println("[1]SH은행  [2]KB은행");
				System.out.print("  입력 >> ");
				choice = sc.nextInt();
				if(choice==1) {
					bankName = "SH은행";
					break;
				}
				else if(choice==2) {
					bankName = "KB은행";
					break;
				}
				else {
					System.out.println("※ 1 또는 2를 입력해야 합니다. 다시 시도하세요.");
					System.out.println();
				}
			}
			SendInfo sendInfo = new SendInfo(bankName, accountNum, money);
			return sendInfo;
		}
	}
	/**-------------------------------------------------------------------------------------------------
	/ 송금 전 계좌정보 확인 뷰
	/-------------------------------------------------------------------------------------------------*/
	public int sendCheckView(SendInfo sendInfo) {
		System.out.println("=================================");
		System.out.println("=\t송금\t정보\t확인\t=");
		System.out.println("=================================");
		System.out.println("[받는 분] "+sendInfo.getMemberName());
		System.out.println("[은행명] "+sendInfo.getBankName());
		System.out.println("[계좌번호] "+sendInfo.getAccountNum());
		System.out.println("[금액] "+sendInfo.getMoney()+"원");
		System.out.println("=================================");
		System.out.println("※ [1] 송금하기   [2] 취소하기");
		System.out.print("  입력 >> ");
		int choice = sc.nextInt();
		return choice;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 송금 전 비밀번호 확인 뷰
	/-------------------------------------------------------------------------------------------------*/
	public String checkPwView() {
		System.out.println("※ 계좌비밀번호 4자리를 입력하세요.");
		System.out.print("  입력 >> ");
		String bankpwd = sc.next();
		return bankpwd;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 계좌 비밀번호 변경 뷰
	/-------------------------------------------------------------------------------------------------*/
	public String ModifyBankPwView() {
		System.out.println("■ 새 비밀번호를 입력하세요.");
		System.out.print("  입력 >> ");
		String inputPw = sc.next();
		System.out.println("■ 비밀번호를 한 번 더 입력하세요.");
		System.out.print("  입력 >> ");
		String inputPw2 = sc.next();
		if(!inputPw.equals(inputPw2)) {
			System.out.println("입력한 비밀번호가 일치하지 않습니다. 다시 입력하세요.");
			return inputPw;
		}
		else {
			return inputPw;
		}
	}
	/**-------------------------------------------------------------------------------------------------
	/ 회원정보 수정 뷰
	/-------------------------------------------------------------------------------------------------*/
	public int modifyView() {
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■\t\t회\t원\t정\t보\t수\t정\t\t\t■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■ 수정할 항목을 선택하세요.");
		System.out.println("[1] 패스워드 변경\t[2] 계좌 비밀번호 변경");
		System.out.print("  입력 >> ");
		int select = sc.nextInt();
		return select;
	}
	public String inputPwView() {
		System.out.println("※ 현재 비밀번호를 입력하세요.");
		System.out.print("  입력 >> ");
		String loginpw = sc.next();
		return loginpw;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 시스템 메시지 (성공/실패)
	/-------------------------------------------------------------------------------------------------*/
	public String successView(String msg) {
		String message = "[시스템 메시지]: "+msg+"에 성공하였습니다.";
		System.out.println(message);
		return message;
	}
	public String failedView(String msg) {
		String message = "[시스템 메시지]: "+msg+"에 실패하였습니다.";
		System.out.println(message);
		return message;
	}
}
