package com.bank.service;

import com.bank.entities.User;

public interface UserService {
	/*×¢²á
	 * */
	public boolean regUser(User user);
	/*
	 * µÇÂ½
	 * @return void
	 * */
	public boolean logUser(String userId,String pwd);
	/*
	 * ĞŞ¸ÄÃÜÂë
	 * 
	 * */
	public boolean updatePwd(User user,String newPwd);
	
	public User findUserByUserId(String userId);


}
