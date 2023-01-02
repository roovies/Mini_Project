package BankHi.Model.VO;

public class SendInfo {
	private String memberName;
	private String memberId;
	private String bankName;
	private String accountNum;
	private int money;
	
	public SendInfo() {}
	public SendInfo(String bankName, String accountNum, int money) {
		super();
		this.bankName = bankName;
		this.accountNum = accountNum;
		this.money = money;
	}
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	

}
