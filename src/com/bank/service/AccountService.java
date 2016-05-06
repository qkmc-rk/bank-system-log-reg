package com.bank.service;

import java.util.List;

import com.bank.entities.Account;

public interface AccountService {
	
	public void register(Account a) throws Exception;
	
	public void removeAccount(String acctId) throws Exception;
	
	public void updateAccount(Account a) throws Exception;
	
	public Account findByAccountId(String acctId) throws Exception;
	
	public List<Account> findAllByUserId(String userId)throws Exception;
}
