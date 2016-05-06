package com.bank.dao;

import java.sql.Connection;
import java.util.List;

import com.bank.entities.Account;

public interface AccountDAO {
	
	public void add(Account a,Connection conn) throws Exception;
	
	public void delete(String acctId, Connection conn) throws Exception;
	
	public void update(Account a, Connection conn) throws Exception;
	
	public Account findByAccountId(String acctId, Connection conn) throws Exception;
	
	public List<Account> findAllByUserId(String userId, Connection conn)throws Exception;
	
	
	
	
}
