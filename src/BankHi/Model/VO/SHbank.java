package BankHi.Model.VO;

import java.sql.Date;

public class SHbank {
	private String shId;
	private String shName;
	private String shNum;
	private String shPw;
	private int shBalance;
	private String loanYn;
	private int loanMoney;
	private int loanLimit;
	private Date enrollDate;
	
	
	public SHbank() {}
	public SHbank(String shId, String shName, String shNum, String shPw, int shBalance, String loanYn, int loanMoney,
			int loanLimit, Date enrollDate) {
		super();
		this.shId = shId;
		this.shName = shName;
		this.shNum = shNum;
		this.shPw = shPw;
		this.shBalance = shBalance;
		this.loanYn = loanYn;
		this.loanMoney = loanMoney;
		this.loanLimit = loanLimit;
		this.enrollDate = enrollDate;
	}
	/** Getter & Setter */
	public String getShId() {
		return shId;
	}
	public void setShId(String shId) {
		this.shId = shId;
	}
	public String getShName() {
		return shName;
	}
	public void setShName(String shName) {
		this.shName = shName;
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
