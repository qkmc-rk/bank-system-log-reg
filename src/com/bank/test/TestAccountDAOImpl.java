package com.bank.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.bank.dao.AccountDAO;
import com.bank.dao.impl.AccountDAOImpl;
import com.bank.entities.Account;
import com.bank.utils.ConnectToJDBC;

public class TestAccountDAOImpl {

	@Test
	public void testAdd(){
		Connection conn = ConnectToJDBC.getConnection();
		try {
			Account account = new Account("20220");
			//conn.setAutoCommit(false);
			AccountDAO accountdao = new AccountDAOImpl();
			accountdao.add(account, conn);
		//	conn.commit();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
