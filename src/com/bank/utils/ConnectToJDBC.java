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
	 * ��ȡ���ݿ����Ӷ���
	 * @return ���ݿ����Ӷ���
	 * */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("û�м��ص������������Ƿ���jar��");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e) {
			System.out.println("����ʧ�ܣ������û������룬��ȷ�����ӵ�ַ��Ч");
			e.printStackTrace();
		}
		return conn;
	}
	/*
	 * �ر����ݿ�����
	 * */
	public static void close(Connection conn){
		if(conn != null){
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				System.out.println("�ر�����ʧ�ܣ���ȷ�����ݿ����ɴ�������״̬");
				e.printStackTrace();
			}
		}
	}
}
