package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.dao.UserDAO;
import com.bank.entities.User;
import com.bank.utils.ConnectToJDBC;

public class UserDAOImpl implements UserDAO{
	
	@Override
	public boolean addUser(User user) {
		Connection conn = ConnectToJDBC.getConnection();
		String sql = "insert into t_user(userId,personId,userName,userPwd,phone,addr,userType)values(?,?,?,?,?,?,?)";
		if(user.getUserName().equals("")  ||  user.getUserId().equals("")  || user.getUserPwd().equals("") || user.getPersonId().equals("") || user.getAddr().equals("") || user.getAddr().equals("")) 
			return false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getPersonId());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserPwd());
			pstmt.setString(5, user.getPhone());
			pstmt.setString(6, user.getAddr());
			pstmt.setInt(7, user.getUserType());
			pstmt.executeUpdate();
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("插入失败，请检查sql语句和对象");
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;						/*执行失败则返回假*/
	}

	@Override
	public User qurryUser(String userId, String pwd) {
		Connection conn = ConnectToJDBC.getConnection();
		User user = null;
		String sql = "select * from t_user where userId=? and userPwd=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				user = new User();
				user.setUserId(rs.getString(2));
				user.setPersonId(rs.getString(3));
				user.setUserName(rs.getString(4));
				user.setUserPwd(rs.getString(5));
				user.setPhone(rs.getString(7));
				user.setAddr(rs.getString(8));
				user.setUserType(rs.getInt(9));
				if(rs.getString(6) != null)user.setOldPwd(rs.getString(6));
			}
		} catch (SQLException e) {
			System.out.println("查询失败，请检查sql语句和对象");
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean updateUser(User user,String newPwd) {
		Connection conn = ConnectToJDBC.getConnection();
		String sql = "update t_user set userPwd=?,oldPwd=? where userId=? and userPwd=?";
		User userTmp = null;
		userTmp = qurryUser(user.getUserId(),user.getUserPwd());			/*更新密码之前先查询是否存在这样一个对象。*/
		if(userTmp != null)
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPwd);
			pstmt.setString(2, user.getUserPwd());
			pstmt.setString(3, user.getUserId());
			pstmt.setString(4, user.getUserPwd());
			pstmt.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			System.out.println("PreparedStatement pstmt = conn.prepareStatement(sql);失败或者之后的内容失败");
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
