package lsh.messagebox.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/messagebox";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "root";
	private Connection conn = null;
	
	//构造方法中进行数据库连接
	public DatabaseConnection() {
		try {
			Class.forName(DBDRIVER);
			this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//取得数据库连接
	public Connection getConnction() {
		return this.conn;
	}
	
	//关闭数据库连接
	public void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
