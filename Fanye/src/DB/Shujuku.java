package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Shujuku {
	String jdbcUrl = "jdbc:mysql://fanye.co2qg4eqf1im.us-east-1.rds.amazonaws.com:3306/cloudFinal";
	static Connection conn;
	private Statement stmt;

	// private Query query;
	public Shujuku() {
		try {
			connect();
			/*
			 * test(); for(String s:test()){ System.out.println(s); }
			 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void connect() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String userid = "final";
		String password = "88522712";
		conn = DriverManager.getConnection(jdbcUrl, userid, password);
	}

	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	public ArrayList<String> test() throws SQLException {
		stmt = conn.createStatement();
		ArrayList<String> result = new ArrayList<String>();
		ResultSet rset = stmt.executeQuery("show tables");
		while (rset.next()) {
			result.add(rset.getString(1));
		}
		return result;
	}
}