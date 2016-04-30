package com.bank.service.impl;

import com.bank.dao.UserDAO;
import com.bank.dao.impl.UserDAOImpl;
import com.bank.entities.User;
import com.bank.service.UserService;

public class UserServiceImpl implements UserService {
	UserDAOImpl userdao = new UserDAOImpl();
	@Override
	public boolean regUser(User user) {
		boolean flag = userdao.addUser(user);
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

}
