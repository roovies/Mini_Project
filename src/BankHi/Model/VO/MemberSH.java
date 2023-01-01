package BankHi.Model.VO;

import java.sql.Date;

public class MemberSH {
	private String memberId;
	private String memberName;
	private String memberBank;
	private String shNum;
	private String shPw;
	private int shBalance;
	private String loanYn;
	private int loanMoney;
	private int loanLimit;
	private Date enrollDate;
	
	
	public MemberSH() {}
	public MemberSH(String memberId, String memberName, String memberBank, String shNum, String shPw, int shBalance,
			String loanYn, int loanMoney, int loanLimit, Date enrollDate) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberBank = memberBank;
		this.shNum = shNum;
		this.shPw = shPw;
		this.shBalance = shBalance;
		this.loanYn = loanYn;
		this.loanMoney = loanMoney;
		this.loanLimit = loanLimit;
		this.enrollDate = enrollDate;
	}
	
	
	
	/** Getter & Setter*/
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
	public String getShNum() {
		return shNum;
	}
	public void setShNum(String shNum) {
		this.shNum = shNum;
	}
	public String getShPw() {
		return shPw;
	}
	public void setShPw(String shPw) {
		this.shPw = shPw;
	}
	public int getShBalance() {
		return shBalance;
	}
	public void setShBalance(int shBalance) {
		this.shBalance = shBalance;
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
