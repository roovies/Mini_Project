package BankHi.Controller;

import java.util.ArrayList;
import java.util.List;

import BankHi.Model.DAO.MemberDAO;
import BankHi.Model.VO.Member;
import BankHi.Model.VO.MemberKB;
import BankHi.Model.VO.MemberSH;

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
	public MemberSH loadSHMember(Member member) {
		memSH = mDAO.selectSHJoin(member);
		return memSH;
	}
	
	public MemberKB loadKBMember(Member member) {
		memKB = mDAO.selectKBJoin(member);
		return memKB;
	}
}
