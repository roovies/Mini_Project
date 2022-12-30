package BankHi.Model.VO;

import java.sql.Date;

public class Member {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberGender;
	private String memberSSN;
	private String memberPhone;
	private String memberEmail;
	private String memberAddr;
	private String memberBank;
	private Date enrollDate;
	//회원가입을 위한 임시 데이터 저장변수
	private String bankNum;
	private String bankPw;

	public Member() {}
	public Member(String memberId, String memberPw, String memberName, String memberGender, String memberSSN,
			String memberPhone, String memberEmail, String memberAddr, String memberBank, String bankNum, String bankPw) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.memberSSN = memberSSN;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberAddr = memberAddr;
		this.memberBank = memberBank;
		this.bankNum = bankNum;
		this.bankPw = bankPw;
	}


	/** Getter & Setter */
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberSSN() {
		return memberSSN;
	}

	public void setMemberSSN(String memberSSN) {
		this.memberSSN = memberSSN;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberAddr() {
		return memberAddr;
	}

	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}

	public String getMemberBank() {
		return memberBank;
	}

	public void setMemberBank(String memberBank) {
		this.memberBank = memberBank;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getBankNum() {
		return bankNum;
	}
	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}
	public String getBankPw() {
		return bankPw;
	}
	public void setBankPw(String bankPw) {
		this.bankPw = bankPw;
	}
}
