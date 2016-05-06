package com.bank.service.impl;

import java.sql.Connection;
import java.util.List;

import com.bank.dao.AccountDAO;
import com.bank.dao.impl.AccountDAOImpl;
import com.bank.entities.Account;
import com.bank.service.AccountService;
import com.bank.service.Rules;
import com.bank.utils.ConnectToJDBC;

public class AccountServiceImpl implements AccountService{
	AccountDAO accountdao = new AccountDAOImpl();

	@Override
	public void register(Account a) throws Exception {
		/*注册之前先进行账户校验*/
		Rules.validataAccount(a);
		/*判断是否存在此卡号，存在则抛出异常*/
		Account acct = findByAccountId(a.getAcctId());
		if(acct.getAcctId().equals(a.getAcctId())) throw new Exception("此卡号已经存在，请不要重复添加！");
		
		Connection conn = ConnectToJDBC.getConnection();
		conn.setAutoCommit(false);
		accountdao.add(a, conn);
		conn.commit();
		conn.close();
	}

	@Override
	public void removeAccount(String acctId) throws Exception {
		Connection conn = ConnectToJDBC.getConnection();
		conn.setAutoCommit(false);
		accountdao.delete(acctId, conn);
		conn.commit();
		conn.close();		
	}

	@Override
	public void updateAccount(Account a) throws Exception {
		Connection conn = ConnectToJDBC.getConnection();
		conn.setAutoCommit(false);
		accountdao.update(a, conn);
		conn.commit();
		conn.close();		
	}

	@Override
	public Account findByAccountId(String acctId) throws Exception {
		Connection conn = ConnectToJDBC.getConnection();
		conn.setAutoCommit(false);
		Account acct = accountdao.findByAccountId(acctId, conn);
		conn.commit();
		conn.close();
		return acct;
	}

	@Override
	public List<Account> findAllByUserId(String userId) throws Exception {
		Connection conn = ConnectToJDBC.getConnection();
		conn.setAutoCommit(false);
		List<Account> accts = accountdao.findAllByUserId(userId, conn);
		conn.commit();
		conn.close();
		return accts;
	}

}
