package com.bank.service.impl;

import com.bank.dao.UserDAO;
import com.bank.dao.impl.UserDAOImpl;
import com.bank.entities.User;
import com.bank.service.Rules;
import com.bank.service.UserService;

public class UserServiceImpl implements UserService {
		UserDAO userdao = new UserDAOImpl();
	@Override
	public boolean regUser(User user) {
		boolean flag  = false;
		try {
			Rules.validataUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;  			/*如果抛出异常则说明注册应该失败，返回false*/
		}
		/*是否有用户已经存在*/
		User u = userdao.findUserByUserId(user.getUserId());
		if(u != null)
			if( u.getUserId().equals(user.getUserId()))
					return false;
		flag = userdao.addUser(user);
		return flag;
	}
	@Override
	public boolean logUser(String userId, String pwd) {
		User user = userdao.qurryUser(userId, pwd);
		if(user != null && user.getUserId().equals(userId) && user.getUserPwd().equals(pwd)) 
			return true;
		else 
			return false;
	}

	@Override
	public boolean updatePwd(User user, String newPwd) {
		Boolean flag = userdao.updateUser(user, newPwd);
		return flag;
	}
	/*
	 * getter and setter
	 * */
	public UserDAO getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDAOImpl userdao) {
		this.userdao = userdao;
	}
	@Override
	public User findUserByUserId(String userId) {
		User user = new User();
		user = userdao.findUserByUserId(userId);
		return user;
	}

}
