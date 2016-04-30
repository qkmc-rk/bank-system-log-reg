package com.bank.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToJDBC {
	private static String DRIVER = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/banksystem";
	private static String USER = "root";
	private static String PASSWORD = "123456";
	/*
	 * 获取数据库连接对象
	 * @return 数据库连接对象
	 * */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("没有加载到驱动，请检查是否导入jar包");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e) {
			System.out.println("连接失败，请检查用户名密码，并确保链接地址有效");
			e.printStackTrace();
		}
		return conn;
	}
	/*
	 * 关闭数据库连接
	 * */
	public static void close(Connection conn){
		if(conn != null){
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println("关闭连接失败，请确认数据库依旧处于连接状态");
				e.printStackTrace();
			}
		}
	}
}
