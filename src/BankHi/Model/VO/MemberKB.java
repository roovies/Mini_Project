package BankHi.Model.VO;

import java.sql.Date;

public class MemberKB {
	private String memberId;
	private String memberName;
	private String memberBank;
	private String kbNum;
	private String kbPw;
	private int kbBalance;
	private String loanYn;
	private int loanMoney;
	private int loanLimit;
	private Date enrollDate;
	
	public MemberKB() {}
	public MemberKB(String memberId, String memberName, String memberBank, String kbNum, String kbPw, int kbBalance,
			String loanYn, int loanMoney, int loanLimit, Date enrollDate) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberBank = memberBank;
		this.kbNum = kbNum;
		this.kbPw = kbPw;
		this.kbBalance = kbBalance;
		this.loanYn = loanYn;
		this.loanMoney = loanMoney;
		this.loanLimit = loanLimit;
		this.enrollDate = enrollDate;
	}
	
	
	/** Getter & Setter */
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberBank() {
		return memberBank;
	}
	public void setMemberBank(String memberBank) {
		this.memberBank = memberBank;
	}
	public String getKbNum() {
		return kbNum;
	}
	public void setKbNum(String kbNum) {
		this.kbNum = kbNum;
	}
	public String getKbPw() {
		return kbPw;
	}
	public void setKbPw(String kbPw) {
		this.kbPw = kbPw;
	}
	public int getKbBalance() {
		return kbBalance;
	}
	public void setKbBalance(int kbBalance) {
		this.kbBalance = kbBalance;
	}
	public String getLoanYn() {
		return loanYn;
	}
	public void setLoanYn(String loanYn) {
		this.loanYn = loanYn;
	}
	public int getLoanMoney() {
		return loanMoney;
	}
	public void setLoanMoney(int loanMoney) {
		this.loanMoney = loanMoney;
	}
	public int getLoanLimit() {
		return loanLimit;
	}
	public void setLoanLimit(int loanLimit) {
		this.loanLimit = loanLimit;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
}
