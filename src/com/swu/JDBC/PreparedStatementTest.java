package com.swu.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementTest {

	public static void main(String[] args) {
		PreparedStatementTest test = new PreparedStatementTest();
		try {
			test.getUserByUsername("user");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addUser(String username,String password) throws Exception{
		String sql = "insert into user(username,password) values(?,?)";
		Connection conn = DBTool.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, username);
		stmt.setString(2, password);
		stmt.executeUpdate();
		
		DBTool.closeConnection(stmt, conn);
	}
	public void updateUser(int id,String username,String password) throws SQLException{
		String sql = "update user set username=?,password=? where id=?";
		Connection conn = DBTool.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, username);
		stmt.setString(2, password);
		stmt.setInt(3, id);
		
		stmt.executeUpdate();
		
		DBTool.closeConnection(stmt, conn);
		
	}
	public void deleteUser(int id) throws SQLException{
		String sql = "delete from user where id = ?";
		Connection conn = DBTool.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, id);
	
		stmt.executeUpdate();
		
		DBTool.closeConnection(stmt, conn);
	}
	
	public void getUserByUsername(String username) throws SQLException{
		String sql = "select * from user where username=?";
		Connection conn = DBTool.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setString(1, username);
		
		
	
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()){
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			
		}
		
		DBTool.closeConnection(stmt, conn);
	}
}
