package com.swu.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JDBCTest {
	
	public static void main(String[] args) {
		JDBCTest test = new JDBCTest();
		test.getAllUser();
		
		
	}
	public void addUser(String username,String password){
		Connection conn = DBTool.getConnection();
		String sql = "insert into user(username,password) values('"+username+"','"+password+"')";
		Statement stmt = null;
		try {
			//通过Connection获取Statement
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				DBTool.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void updateUser(int id,String username,String password){
		Connection conn = DBTool.getConnection();
		String sql = "update user set username='"+username+"',password='"+password+"' where id="+id;
		Statement stmt = null;
		try {
			//通过Connection获取Statement
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				DBTool.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void deleteUser(int id){
		Connection conn = DBTool.getConnection();
		String sql = "delete from user where id="+id;
		Statement stmt = null;
		try {
			//通过Connection获取Statement
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				DBTool.closeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void getAllUser(){
		Connection conn = DBTool.getConnection();
		String sql = "select * from user";
		Statement stmt = null;
		//保存查询返回结果
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
