package com.swu.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTool {
	public static Connection getConnection(){
		String dbURL = "jdbc:mysql://localhost:3307/test";
		String username = "root";
		String password = "";
		Connection conn = null;
		try {
			//注册驱动类
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL,username,password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("加载驱动失败");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("连接失败");
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConnection(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("关闭失败");
			e.printStackTrace();
		}
	}
	public static void closeConnection(Statement stmt,Connection conn){
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
