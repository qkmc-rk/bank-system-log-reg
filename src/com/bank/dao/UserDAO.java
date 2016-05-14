package com.bank.dao;

import com.bank.entities.User;

public interface UserDAO {
	/*
	 * �û�ע��ʱ�����û���Ϣ
	 * @param user �û�
	 * @return �Ƿ�ɹ�
	 * */
	public boolean addUser(User user);
	
	/*
	 * ����userId�������ѯ�û������ڵ�½
	 * @user ��ѯ����
	 * @return ����
	 * */
	public User qurryUser(String userId,String pwd);
	/*
	 * �����û����޸�����
	 * @user user����
	 * @newOwd ������
	 * @return �Ƿ�ɹ�
	 * */
	public boolean updateUser(User user,String newPwd);
	/*	
	 * ͨ�������û����������û�
	 * @user user����
	 * @userId  �û�Id
	 * @return user
	 * */
	public User findUserByUserId(String userId);
	
}
