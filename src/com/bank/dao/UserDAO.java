package com.bank.dao;

import com.bank.entities.User;

public interface UserDAO {
	/*
	 * 用户注册时插入用户信息
	 * @param user 用户
	 * @return 是否成功
	 * */
	public boolean addUser(User user);
	
	/*
	 * 根据userId和密码查询用户，便于登陆
	 * @user 查询对象
	 * @return 对象
	 * */
	public User qurryUser(String userId,String pwd);
	/*
	 * 更新用户，修改密码
	 * @user user对象
	 * @newOwd 新密码
	 * @return 是否成功
	 * */
	public boolean updateUser(User user,String newPwd);
	/*	
	 * 通过查找用户名来查找用户
	 * @user user对象
	 * @userId  用户Id
	 * @return user
	 * */
	public User findUserByUserId(String userId);
	
}
