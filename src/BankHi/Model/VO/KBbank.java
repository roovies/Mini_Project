package BankHi.Model.VO;

import java.sql.Date;

public class KBbank {
	private String kbId;
	private String kbName;
	private String kbNum;
	private String kbPw;
	private int kbBalance;
	private String loanYn;
	private int loanMoney;
	private int loanLimit;
	private Date enrollDate;
	
	public KBbank() {}
	public KBbank(String kbId, String kbName, String kbNum, String kbPw, int kbBalance, String loanYn, int loanMoney,
			int loanLimit, Date enrollDate) {
		super();
		this.kbId = kbId;
		this.kbName = kbName;
		this.kbNum = kbNum;
		this.kbPw = kbPw;
		this.kbBalance = kbBalance;
		this.loanYn = loanYn;
		this.loanMoney = loanMoney;
		this.loanLimit = loanLimit;
		this.enrollDate = enrollDate;
	}
	
	/** Getter & Setter */
	public String getKbId() {
		return kbId;
	}
	public void setKbId(String kbId) {
		this.kbId = kbId;
	}
	public String getKbName() {
		return kbName;
	}
	public void setKbName(String kbName) {
		this.kbName = kbName;
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
