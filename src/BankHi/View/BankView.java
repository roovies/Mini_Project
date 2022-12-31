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

public class BankView {
	Scanner sc;

	public BankView() {
		sc = new Scanner(System.in);
	}
	/**-------------------------------------------------------------------------------------------------
	/ 메인뷰
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
	/ 로그인뷰
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
	/ 아이디 찾기뷰
	/-------------------------------------------------------------------------------------------------*/
	public Member searchIdView(Member member) {
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■\t\t가입 시 입력한 이름과 핸드폰 번호를 입력하세요. \t\t■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
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
	
	public void searchOkView(Member member) {
		System.out.println("  [*] \""+member.getMemberName()+"\"님의 아이디는 "+member.getMemberId()+" 입니다.");
	}
	public void searchNoView(Member member) {
		System.out.println("  [*] 입력한 정보로 등록된 회원이 존재하지 않습니다.");
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 회원가입뷰
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
				System.out.println("※ 1 또는 2를 입력해야 합니다. 다시 시도해주세요.");
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
	/ 메뉴뷰
	/-------------------------------------------------------------------------------------------------*/
	public int menuView(Member member) {
		System.out.println();
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■\t\t\t\t"+member.getMemberName()+"님 환영합니다. *^^*\t\t\t■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("1. 내정보 조회");
		System.out.println("0. 로그아웃");
		System.out.print("선택 >> ");
		int select = sc.nextInt();
		return select;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 내 정보 조회뷰 (Overloading)
	/-------------------------------------------------------------------------------------------------*/
	public void mypageView(Member member, MemberSH memSH) {
		System.out.println();
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■\t\t\t\t"+member.getMemberName()+"님의 마이페이지\t\t\t\t■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("[아이디] "+member.getMemberId()+"\t\t[패스워드] ********\t\t[가입일] "+member.getEnrollDate());
		System.out.println("[이름] "+member.getMemberName()+"\t\t[성별] "+member.getMemberGender()+"\t\t\t[생년월일]"+member.getMemberSSN().substring(0, 6));
		System.out.println("[은행명] "+member.getMemberBank()+"\t\t[계좌번호] "+memSH.getShNum()+"\t\t[잔액] "+memSH.getShBalance()+"원");
		System.out.println("[대출가능여부] "+memSH.getLoanYn()+"\t[대출한도] "+memSH.getLoanLimit()+"원 \t\t[상환할 금액] "+memSH.getLoanMoney());
	}
	
	public void mypageView(Member member, MemberKB memKB) {
		System.out.println();
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■\t\t\t\t"+member.getMemberName()+"님의 마이페이지\t\t\t\t■■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("[아이디] "+member.getMemberId()+"\t\t[패스워드] ********\t\t[가입일] "+member.getEnrollDate());
		System.out.println("[이름] "+member.getMemberName()+"\t\t[성별] "+member.getMemberGender()+"\t\t\t[생년월일]"+member.getMemberSSN().substring(0, 6));
		System.out.println("[은행명] "+member.getMemberBank()+"\t\t[계좌번호] "+memKB.getKbNum()+"\t[잔액] "+memKB.getKbBalance()+"원");
		System.out.println("[대출가능여부] "+memKB.getLoanYn()+"\t[대출한도] "+memKB.getLoanLimit()+"원 \t\t[상환할 금액] "+memKB.getLoanMoney());
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
