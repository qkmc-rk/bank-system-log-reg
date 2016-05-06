package com.bank.test;

import org.junit.Test;

import com.bank.entities.Account;
import com.bank.service.AccountService;
import com.bank.service.impl.AccountServiceImpl;

public class TestAccountService {

	@Test
	public void testRegister() {
		Account acct = new Account();
		AccountService as = new AccountServiceImpl();
		try {
			as.register(acct);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
