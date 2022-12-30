package BankHi.Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import BankHi.Model.VO.Member;

public class LogDAO {
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String USER = "ROOVIES";
	private final String PW = "ROOVIES";
	
	public void logging(String log) {
		try {
			/** JDBC */
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PW);
			Statement stmt = conn.createStatement();
			
			/** DML(INSERT) */
			String sql = "INSERT INTO LOG VALUES('"+log+"', SYSDATE)";
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
