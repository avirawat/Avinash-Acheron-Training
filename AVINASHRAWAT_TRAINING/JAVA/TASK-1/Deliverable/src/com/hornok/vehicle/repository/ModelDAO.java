package com.hornok.vehicle.repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ModelDAO {
	static Connection connection;
	public static Connection openConnection() {
		Properties properties=new Properties();
		try {
			properties.load(new FileReader("jdbc.properties"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		String url=(String)properties.getProperty("driver");
		String username=(String)properties.get("username");
		String password=(String)properties.get("password");
		
		try {
			connection=DriverManager.getConnection(url,username,password);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static void closeConnection() {
		try {
			if(connection!=null)
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
