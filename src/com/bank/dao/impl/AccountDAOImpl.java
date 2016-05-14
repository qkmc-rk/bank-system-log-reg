package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.AccountDAO;
import com.bank.entities.Account;

public class AccountDAOImpl implements AccountDAO{

	@Override/*实现增加Account*/
	public void add(Account a, Connection conn) throws Exception {
		String sql = "insert into t_account(acctId,userId,accType,isLoss,saveMoney,saveType,saveYear,saveDate,loanMoney,"
				+ "loanType,loanYear,loanDate,warrant01,warrant02,loanHouse,creditMoney,consumeMoney,creditPwd,US_dollar"
				+ ",HK_dollar,JP_dollar)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, a.getAcctId());
		pstmt.setString(2, a.getUserId());
		pstmt.setInt(3,a.getAccType());
		pstmt.setInt(4,a.getIsLoss());
		pstmt.setDouble(5, a.getSaveMoney());
		pstmt.setInt(6,a.getSaveType());
		pstmt.setInt(7,a.getSaveYear());
		pstmt.setDate(8, new Date(a.getSaveDate().getTime()));
		pstmt.setDouble(9,a.getLoanMoney());
		pstmt.setInt(10, a.getLoanType());
		pstmt.setInt(11, a.getLoanYear());
		pstmt.setDate(12, new Date(a.getLoanDate().getTime()));			/*something goes uncommon*/
		pstmt.setString(13,a.getWarrant01());
		pstmt.setString(14, a.getWarrant02());
		pstmt.setString(15, a.getLoanHouse());
		pstmt.setDouble(16, a.getCreditMoney());
		pstmt.setDouble(17,a.getConsumeMoney());
		pstmt.setString(18,a.getCreditPwd());
		pstmt.setDouble(19, a.getUS_dollar());
		pstmt.setDouble(20, a.getHK_dollar());
		pstmt.setDouble(21, a.getJP_dollar());
		pstmt.executeUpdate();
		
	}

	@Override
	public void delete(String acctId, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Account a, Connection conn) throws Exception {
		String sql = "update t_account set acctId=?,userId=?,accType=?,isLoss=?,saveMoney=?,saveType=?,saveYear=?,saveDate=?,loanMoney=?,"
				+ "loanType=?,loanYear=?,loanDate=?,warrant01=?,warrant02=?,loanHouse=?,creditMoney=?,consumeMoney=?,creditPwd=?,US_dollar=?,HK_dollar=?,"
				+ "JP_dollar=?" +"where acctId="+a.getAcctId();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, a.getAcctId());
		pstmt.setString(2, a.getUserId());
		pstmt.setInt(3,a.getAccType());
		pstmt.setInt(4,a.getIsLoss());
		pstmt.setDouble(5, a.getSaveMoney());
		pstmt.setInt(6,a.getSaveType());
		pstmt.setInt(7,a.getSaveYear());
		pstmt.setDate(8, new Date(a.getSaveDate().getTime()));
		pstmt.setDouble(9,a.getLoanMoney());
		pstmt.setInt(10, a.getLoanType());
		pstmt.setInt(11, a.getLoanYear());
		pstmt.setDate(12, new Date(a.getLoanDate().getTime()));			/*something goes uncommon*/
		pstmt.setString(13,a.getWarrant01());
		pstmt.setString(14, a.getWarrant02());
		pstmt.setString(15, a.getLoanHouse());
		pstmt.setDouble(16, a.getCreditMoney());
		pstmt.setDouble(17,a.getConsumeMoney());
		pstmt.setString(18,a.getCreditPwd());
		pstmt.setDouble(19, a.getUS_dollar());
		pstmt.setDouble(20, a.getHK_dollar());
		pstmt.setDouble(21, a.getJP_dollar());
		pstmt.executeUpdate();
	}



	@Override
	public List<Account> findAllByUserId(String userId, Connection conn) throws Exception {
		List<Account> accts = new ArrayList<>();
		String sql = "select * from t_account where userId=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Account acct = new Account();
			acct.setAcctId(rs.getString(2));
			acct.setUserId(rs.getString(3));
			acct.setAccType(rs.getInt(4));
			acct.setIsLoss(rs.getInt(5));
			acct.setSaveMoney(rs.getDouble(6));
			acct.setSaveType(rs.getInt(7));
			acct.setSaveYear(rs.getInt(8));
			acct.setSaveDate(rs.getDate(9));
			acct.setLoanMoney(rs.getDouble(10));
			acct.setLoanType(rs.getInt(11));
			acct.setLoanYear(rs.getInt(12));
			acct.setLoanDate(rs.getDate(13));			/*something goes uncommon*/
			acct.setWarrant01(rs.getString(14));
			acct.setWarrant02(rs.getString(15));
			acct.setLoanHouse(rs.getString(16));
			acct.setCreditMoney(rs.getDouble(17));
			acct.setConsumeMoney(rs.getDouble(18));
			acct.setCreditPwd(rs.getString(19));
			acct.setUS_dollar(rs.getDouble(20));
			acct.setHK_dollar(rs.getDouble(21));
			acct.setJP_dollar(rs.getDouble(22));
			accts.add(acct);
		}
		return accts;
	}

	@Override
	public Account findByAccountId(String acctId, Connection conn) throws Exception {
		Account acct = null;
		String sql = "select * from t_account where acctId=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, acctId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			acct = new Account();
			acct.setAcctId(rs.getString(2));
			acct.setUserId(rs.getString(3));
			acct.setAccType(rs.getInt(4));
			acct.setIsLoss(rs.getInt(5));
			acct.setSaveMoney(rs.getDouble(6));
			acct.setSaveType(rs.getInt(7));
			acct.setSaveYear(rs.getInt(8));
			acct.setSaveDate(rs.getDate(9));
			acct.setLoanMoney(rs.getDouble(10));
			acct.setLoanType(rs.getInt(11));
			acct.setLoanYear(rs.getInt(12));
			acct.setLoanDate(rs.getDate(13));			/*something goes uncommon*/
			acct.setWarrant01(rs.getString(14));
			acct.setWarrant02(rs.getString(15));
			acct.setLoanHouse(rs.getString(16));
			acct.setCreditMoney(rs.getDouble(17));
			acct.setConsumeMoney(rs.getDouble(18));
			acct.setCreditPwd(rs.getString(19));
			acct.setUS_dollar(rs.getDouble(20));
			acct.setHK_dollar(rs.getDouble(21));
			acct.setJP_dollar(rs.getDouble(22));
		}
		return acct;
	}

}
