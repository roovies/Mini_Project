package BankHi.Controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import BankHi.Model.DAO.LogDAO;

public class LogController {
	LogDAO logDAO = new LogDAO();
	public void logging(String log) {
		try {
			InetAddress local = InetAddress.getLocalHost();
			String IP = local.getHostAddress();
			logDAO.logging("@"+IP+"  "+log);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
