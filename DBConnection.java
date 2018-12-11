package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	static Connection getConnection() throws IOException, ClassNotFoundException, SQLException
	{
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream("resources/DB.properties");
		
		prop.load(fis);
		
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		
		return con;
	}
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		DBConnection.getConnection();
	}
}
