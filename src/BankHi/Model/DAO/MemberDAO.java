package BankHi.Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BankHi.Model.VO.Member;
import BankHi.Model.VO.MemberKB;
import BankHi.Model.VO.MemberSH;


public class MemberDAO {
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String USER = "ROOVIES";
	private final String PW = "ROOVIES";
	
	
	/**-------------------------------------------------------------------------------------------------
	/ 전체 회원 목록 조회 DAO
	/-------------------------------------------------------------------------------------------------*/
	public List<Member> selectAll() {
		Member member = null;
		List<Member> mList = new ArrayList<Member>();
		try {
			/** JDBC */
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PW);
			String sql = "SELECT * FROM MEMBER";
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			while(rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPw(rset.getString("MEMBER_PW"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberGender(rset.getString("MEMBER_GENDER"));
				member.setMemberSSN(rset.getString("MEMBER_SSN"));
				member.setMemberPhone(rset.getString("MEMBER_PHONE"));
				member.setMemberEmail(rset.getString("MEMBER_EMAIL"));
				member.setMemberAddr(rset.getString("MEMBER_ADDR"));
				member.setMemberBank(rset.getString("MEMBER_BANK"));
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));
				mList.add(member);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mList;
	}
	
	
	/**-------------------------------------------------------------------------------------------------
	/ 회원가입 DAO
	/-------------------------------------------------------------------------------------------------*/
	//회원추가
	public int insertMember(Member member) {
		int result = 0;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PW);
			String sql = 
					"INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,?,?, DEFAULT)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberGender());
			pstmt.setString(5, member.getMemberSSN());
			pstmt.setString(6, member.getMemberPhone());
			pstmt.setString(7, member.getMemberEmail());
			pstmt.setString(8, member.getMemberAddr());
			pstmt.setString(9, member.getMemberBank());
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//회원정보 SH은행에 추가
	public int insertSHBank(Member member) {
		int result = 0;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PW);
			String sql = 
					"INSERT INTO SHBANK VALUES(?,?,?,?,DEFAULT,DEFAULT,DEFAULT,DEFAULT, DEFAULT)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberName());
			pstmt.setString(3, member.getBankNum());
			pstmt.setString(4, member.getBankPw());
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	//회원정보 KB은행에 추가
	public int insertKBBank(Member member) {
		int result = 0;
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PW);
			String sql = 
					"INSERT INTO KBBANK VALUES(?,?,?,?,DEFAULT,DEFAULT,DEFAULT,DEFAULT, DEFAULT)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberName());
			pstmt.setString(3, member.getBankNum());
			pstmt.setString(4, member.getBankPw());
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**-------------------------------------------------------------------------------------------------
	/ 비밀번호 변경 DAO
	/-------------------------------------------------------------------------------------------------*/
	public int updatePw(Member member) {
		int result = 0;
		try {
			/** JDBC */
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PW);
			String sql = "UPDATE MEMBER SET MEMBER_PW=? WHERE MEMBER_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberPw());
			pstmt.setString(2, member.getMemberId());
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**-------------------------------------------------------------------------------------------------
	/ 로그인 DAO
	/-------------------------------------------------------------------------------------------------*/
	public Member selectIdPW(Member member) {
		try {
			/** JDBC */
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PW);
			/** DQL(SELECT) */
//			String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID='"+member.getMemberId()+"' AND MEMBER_PW='"+member.getMemberPw()+"'";
//			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID=? AND MEMBER_PW=?";
			PreparedStatement pstmt = conn.prepareStatement(sql); //Secure Coding
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			ResultSet rset = pstmt.executeQuery();
			member = null;
//			ResultSet rset = stmt.executeQuery(sql);
			if(rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString(1));
				member.setMemberPw(rset.getString(2));
				member.setMemberName(rset.getString(3));
				member.setMemberGender(rset.getString(4));
				member.setMemberSSN(rset.getString(5));
				member.setMemberPhone(rset.getString(6));
				member.setMemberEmail(rset.getString(7));
				member.setMemberAddr(rset.getString(8));
				member.setMemberBank(rset.getString(9));
				member.setEnrollDate(rset.getDate(10));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	
	
	/**-------------------------------------------------------------------------------------------------
	/ 각 은행 회원정보 로드 DAO
	/-------------------------------------------------------------------------------------------------*/
	//각 은행 모든 회원정보 로드
	public List<MemberSH> selectSHAll(){
		List<MemberSH> shList = new ArrayList<MemberSH>();
		MemberSH memSH = null;
		try {
			/** JDBC */
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PW);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM SHBANK";
			ResultSet rset = stmt.executeQuery(sql);
			while(rset.next()) {
				memSH = new MemberSH();
				memSH.setMemberId(rset.getString(1));
				memSH.setMemberName(rset.getString(2));
				memSH.setMemberBank("SH은행");
				memSH.setShNum(rset.getString(3));
				memSH.setShBalance(rset.getInt(5));
				memSH.setLoanYn(rset.getString(6));
				memSH.setLoanMoney(rset.getInt(7));
				memSH.setLoanLimit(rset.getInt(8));
				memSH.setEnrollDate(rset.getDate(9));
				shList.add(memSH);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shList;
	}
	
	public List<MemberKB> selectKBAll(){
		List<MemberKB> kbList = new ArrayList<MemberKB>();
		MemberKB memKB = null;
		try {
			/** JDBC */
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PW);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM KBBANK";
			ResultSet rset = stmt.executeQuery(sql);
			while(rset.next()) {
				memKB = new MemberKB();
				memKB.setMemberId(rset.getString(1));
				memKB.setMemberName(rset.getString(2));
				memKB.setMemberBank("KB은행");
				memKB.setKbNum(rset.getString(3));
				memKB.setKbBalance(rset.getInt(5));
				memKB.setLoanYn(rset.getString(6));
				memKB.setLoanMoney(rset.getInt(7));
				memKB.setLoanLimit(rset.getInt(8));
				memKB.setEnrollDate(rset.getDate(9));
				kbList.add(memKB);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kbList;
	}
	
	// 각 은행 개별 회원정보 로드
	public MemberSH selectSHJoin(Member member) {
		MemberSH memSH = null;
		try {
			/** JDBC */
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PW);
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT * FROM MEMBER JOIN SHBANK ON MEMBER_ID=SH_ID WHERE MEMBER_ID='"+member.getMemberId()+"'";
			ResultSet rset = stmt.executeQuery(sql);
			if(rset.next()) {
				memSH = new MemberSH();
				memSH.setMemberId(rset.getString("MEMBER_ID"));
				memSH.setMemberName(rset.getString("MEMBER_NAME"));
				memSH.setMemberBank(rset.getString("MEMBER_BANK"));
				memSH.setShNum(rset.getString("SH_NUM"));
				memSH.setShPw(rset.getString("SH_PW"));
				memSH.setShBalance(rset.getInt("SH_BALANCE"));
				memSH.setLoanYn(rset.getString("LOAN_YN"));
				memSH.setLoanMoney(rset.getInt("LOAN_MONEY"));
				memSH.setLoanLimit(rset.getInt("LOAN_LIMIT"));
				memSH.setEnrollDate(rset.getDate("SH_ENROLL_DATE"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memSH;
	}
	
	public MemberKB selectKBJoin(Member member) {
		MemberKB memKB = null;
		try {
			/** JDBC */
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PW);
			Statement stmt = conn.createStatement();
			
			String sql = "SELECT * FROM MEMBER JOIN KBBANK ON MEMBER_ID=KB_ID WHERE MEMBER_ID='"+member.getMemberId()+"'";
			ResultSet rset = stmt.executeQuery(sql);
			if(rset.next()) {
				memKB = new MemberKB();
				memKB.setMemberId(rset.getString("MEMBER_ID"));
				memKB.setMemberName(rset.getString("MEMBER_NAME"));
				memKB.setMemberBank(rset.getString("MEMBER_BANK"));
				memKB.setKbNum(rset.getString("KB_NUM"));
				memKB.setKbPw(rset.getString("KB_PW"));
				memKB.setKbBalance(rset.getInt("KB_BALANCE"));
				memKB.setLoanYn(rset.getString("LOAN_YN"));
				memKB.setLoanMoney(rset.getInt("LOAN_MONEY"));
				memKB.setLoanLimit(rset.getInt("LOAN_LIMIT"));
				memKB.setEnrollDate(rset.getDate("KB_ENROLL_DATE"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memKB;
	}
}
