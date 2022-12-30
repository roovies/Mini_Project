package BankHi.Controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import BankHi.Model.DAO.LogDAO;
import BankHi.Model.VO.Member;

public class LogController {
	LogDAO logDAO = new LogDAO();
	public void logging(String msg, Member member) {
		if(member==null)
			member = new Member();
		try {
			InetAddress local = InetAddress.getLocalHost();
			String IP = local.getHostAddress();
			logDAO.logging("[HOST]"+IP+"     [ID]"+member.getMemberId()+"   [CONTENT]"+msg);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
