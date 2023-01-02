package BankHi.Controller;

import java.util.ArrayList;
import java.util.List;

import BankHi.Model.DAO.MemberDAO;
import BankHi.Model.VO.Member;
import BankHi.Model.VO.MemberKB;
import BankHi.Model.VO.MemberSH;
import BankHi.Model.VO.SendInfo;

public class BankController {
	MemberDAO mDAO = new MemberDAO();
	MemberSH memSH = null;
	MemberKB memKB = null;
	List<Member> mList = new ArrayList<Member>();
	
	/**-------------------------------------------------------------------------------------------------
	/ 로그인 기능
	/-------------------------------------------------------------------------------------------------*/
	public Member login(Member member) {
		member = mDAO.selectIdPW(member);
		return member;
	}
	
	
	/**-------------------------------------------------------------------------------------------------
	/ 회원가입 기능
	/-------------------------------------------------------------------------------------------------*/
	public int registerMember(Member member) {
		int result = mDAO.insertMember(member);
		return result;
	}
	public int registerSHBank(Member member) {
		int result = mDAO.insertSHBank(member);
		return result;
	}
	public int registerKBBank(Member member) {
		int result = mDAO.insertKBBank(member);
		return result;
	}
	
	
	
	/**-------------------------------------------------------------------------------------------------
	/ 전체 회원 목록 조회 기능
	/-------------------------------------------------------------------------------------------------*/
	public List<Member> searchAll() {
		mList = mDAO.selectAll();
		return mList;
	}
	
	
	/**-------------------------------------------------------------------------------------------------
	/ 아이디 찾기 기능
	/-------------------------------------------------------------------------------------------------*/
	public Member searchId(List<Member> mList, Member member) {
		for(int i=0; i<mList.size(); i++) {
			if(mList.get(i).getMemberName().equals(member.getMemberName())
				&& mList.get(i).getMemberPhone().equals(member.getMemberPhone())) {
				return mList.get(i);
			}
		}
		return member;
	}
	
	
	/**-------------------------------------------------------------------------------------------------
	/ 비밀번호 찾기 기능
	/-------------------------------------------------------------------------------------------------*/
	public Member searchPw(List<Member> mList, Member member) {
		for(int i=0; i<mList.size(); i++) {
			if(mList.get(i).getMemberId().equals(member.getMemberId())
				&& mList.get(i).getMemberName().equals(member.getMemberName())
				&& mList.get(i).getMemberPhone().equals(member.getMemberPhone())) {
				return mList.get(i);
			}
		}
		return member;
	}
	
	public int modifyPw(Member member) {
		int result = mDAO.updatePw(member);
		return result;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 각 은행별 고객정보 로드 기능
	/-------------------------------------------------------------------------------------------------*/
	//모든 고객 정보
	public List<MemberSH> loadSHMemberAll() {
		List<MemberSH> shList = mDAO.selectSHAll();
		return shList;
	}
	public List<MemberKB> loadKBMemberAll() {
		List<MemberKB> kbList = mDAO.selectKBAll();
		return kbList;
	}
	
	//개별 고객 정보
	public MemberSH loadSHMember(Member member) {
		memSH = mDAO.selectSHJoin(member);
		return memSH;
	}
	
	public MemberKB loadKBMember(Member member) {
		memKB = mDAO.selectKBJoin(member);
		return memKB;
	}
	
	/**-------------------------------------------------------------------------------------------------
	/ 송금하기 기능
	/-------------------------------------------------------------------------------------------------*/
	//계좌 유효성 확인
	public SendInfo checkBank(SendInfo sendInfo) {
		if(sendInfo.getBankName().equals("SH은행")) {
			MemberSH memSH = mDAO.selectSHNum(sendInfo);
			if(memSH!=null) {
				sendInfo.setMemberId(memSH.getMemberId());
				sendInfo.setMemberName(memSH.getMemberName());
				return sendInfo;
			}
		}
		else if(sendInfo.getBankName().equals("KB은행")) {
			MemberKB memKB = mDAO.selectKBNum(sendInfo);
			if(memKB!=null) {
				sendInfo.setMemberId(memKB.getMemberId());
				sendInfo.setMemberName(memKB.getMemberName());
				return sendInfo;
			}
		}
		return null; //해당 계좌 존재x
	}
	
	//송금
	public void sendMoney(SendInfo sendInfo, MemberSH sendSH, MemberKB sendKB) {
		int result = 0;
		if(sendKB==null) { //송금자가 SH은행일 경우
			if(sendInfo.getBankName().equals("SH은행")) { //받는 사람이 SH은행일 경우
				/** 송금받는 사람 계좌 잔액 추가 */
				Member member = new Member();
				member.setMemberId(sendInfo.getMemberId());
				MemberSH rcvSH = mDAO.selectSHJoin(member);
				int money = rcvSH.getShBalance();
				money = money+sendInfo.getMoney();
				rcvSH.setShBalance(money);
				result = mDAO.updateSHMoney(rcvSH);
				
				/** 송금하는 사람 계좌 잔액 빼기 */
				money = sendSH.getShBalance();
				money -= sendInfo.getMoney();
				sendSH.setShBalance(money);
				result = mDAO.updateSHMoney(sendSH);
			}
			else if(sendInfo.getBankName().equals("KB은행")) { //받는 사람이 KB은행일 경우
				/** 송금받는 사람 계좌 잔액 추가 */
				Member member = new Member();
				member.setMemberId(sendInfo.getMemberId());
				MemberKB rcvKB = mDAO.selectKBJoin(member);
				int money = rcvKB.getKbBalance();
				money = money+sendInfo.getMoney();
				rcvKB.setKbBalance(money);
				result = mDAO.updateKBMoney(rcvKB);
				
				/** 송금하는 사람 계좌 잔액 빼기 */
				money = sendSH.getShBalance();
				money -= sendInfo.getMoney();
				sendSH.setShBalance(money);
				result = mDAO.updateSHMoney(sendSH);
			}
		}
		else { //송금자가 KB은행일 경우
			if(sendInfo.getBankName().equals("SH은행")) { //받는 사람이 SH은행일 경우
				/** 송금받는 사람 계좌 잔액 추가 */
				Member member = new Member();
				member.setMemberId(sendInfo.getMemberId());
				MemberSH rcvSH = mDAO.selectSHJoin(member);
				int money = rcvSH.getShBalance();
				money = money+sendInfo.getMoney();
				rcvSH.setShBalance(money);
				result = mDAO.updateSHMoney(rcvSH);
				
				/** 송금하는 사람 계좌 잔액 빼기 */
				money = sendKB.getKbBalance();
				money -= sendInfo.getMoney();
				sendKB.setKbBalance(money);
				result = mDAO.updateKBMoney(sendKB);
			}
			else if(sendInfo.getBankName().equals("KB은행")) { //받는 사람이 KB은행일 경우
				/** 송금받는 사람 계좌 잔액 추가 */
				Member member = new Member();
				member.setMemberId(sendInfo.getMemberId());
				MemberKB rcvKB = mDAO.selectKBJoin(member);
				int money = rcvKB.getKbBalance();
				money = money+sendInfo.getMoney();
				rcvKB.setKbBalance(money);
				result = mDAO.updateKBMoney(rcvKB);
				
				/** 송금하는 사람 계좌 잔액 빼기 */
				money = sendKB.getKbBalance();
				money -= sendInfo.getMoney();
				sendKB.setKbBalance(money);
				result = mDAO.updateKBMoney(sendKB);
			}
		}
	}
	
	//패스워드 확인
	public int checkPw(String bankpwd, Member member) {
		BankController bCon = new BankController();
		if(member.getMemberBank().equals("SH은행")) {
			MemberSH memSH = bCon.loadSHMember(member);
			if(memSH.getShPw().equals(bankpwd))
				return 1;
		}
		else {
			MemberKB memKB = bCon.loadKBMember(member);
			if(memKB.getKbPw().equals(bankpwd))
				return 1;
		}
		return 0;
	}
}
