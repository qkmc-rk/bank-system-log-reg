package com.bank.service;

import com.bank.entities.User;

public interface UserService {
	/*ע��
	 * */
	public boolean regUser(User user);
	/*
	 * ��½
	 * @return void
	 * */
	public boolean logUser(String userId,String pwd);
	/*
	 * �޸�����
	 * 
	 * */
	public boolean updatePwd(User user,String newPwd);
	
	public User findUserByUserId(String userId);


}
