package com.bank.entities;

import java.util.Date;

public class Account {
	/*各个字段*/
	private int id;
	private String acctId;  /*账户ID*/
	private String userId;   /*用户ID*/
	private int accType;    /*账户类型    0，一卡通  1贷款 2外汇  3信用*/
	private int isLoss;
	
	private double saveMoney;
	private int saveType;
	private int saveYear;
	private Date saveDate= new Date();
	
	private double loanMoney;
	private int loanType;
	private int loanYear;
	private Date loanDate = new Date();
	
	private String warrant01;			/*担保人*/
	private String warrant02;
	private String loanHouse;
	
	private double creditMoney;
	private double consumeMoney;
	
	private String creditPwd;
	private double US_dollar;			/*美元余额*/
	private double HK_dollar;
	private double JP_dollar;
	
	/*
	 * constructer
	 * */
	public Account() {
		super();
	}
	public Account(String acctId) {
		this.acctId = acctId;
	}
	public Account(int id, String acctId, String userId, int accType, int isLoss, double saveMoney, int saveType,
			int saveYear, Date saveDate, double loanMoney, int loanType, int loanYear, Date loanDate, String warrant01,
			String warrant02, String loanHouse, double creditMoney, double consumeMoney, String creditPwd,
			double uS_dollar, double hK_dollar, double jP_dollar) {
		super();
		this.id = id;
		this.acctId = acctId;
		this.userId = userId;
		this.accType = accType;
		this.isLoss = isLoss;
		this.saveMoney = saveMoney;
		this.saveType = saveType;
		this.saveYear = saveYear;
		this.saveDate = saveDate;
		this.loanMoney = loanMoney;
		this.loanType = loanType;
		this.loanYear = loanYear;
		this.loanDate = loanDate;
		this.warrant01 = warrant01;
		this.warrant02 = warrant02;
		this.loanHouse = loanHouse;
		this.creditMoney = creditMoney;
		this.consumeMoney = consumeMoney;
		this.creditPwd = creditPwd;
		US_dollar = uS_dollar;
		HK_dollar = hK_dollar;
		JP_dollar = jP_dollar;
	}
	/*setter and getter*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAcctId() {
		return acctId;
	}
	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getAccType() {
		return accType;
	}
	public void setAccType(int accType) {
		this.accType = accType;
	}
	public int getIsLoss() {
		return isLoss;
	}
	public void setIsLoss(int isLoss) {
		this.isLoss = isLoss;
	}
	public double getSaveMoney() {
		return saveMoney;
	}
	public void setSaveMoney(double saveMoney) {
		this.saveMoney = saveMoney;
	}
	public int getSaveType() {
		return saveType;
	}
	public void setSaveType(int saveType) {
		this.saveType = saveType;
	}
	public int getSaveYear() {
		return saveYear;
	}
	public void setSaveYear(int saveYear) {
		this.saveYear = saveYear;
	}
	public Date getSaveDate() {
		return saveDate;
	}
	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}
	public double getLoanMoney() {
		return loanMoney;
	}
	public void setLoanMoney(double loanMoney) {
		this.loanMoney = loanMoney;
	}
	public int getLoanType() {
		return loanType;
	}
	public void setLoanType(int loanType) {
		this.loanType = loanType;
	}
	public int getLoanYear() {
		return loanYear;
	}
	public void setLoanYear(int loanYear) {
		this.loanYear = loanYear;
	}
	public Date getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}
	public String getWarrant01() {
		return warrant01;
	}
	public void setWarrant01(String warrant01) {
		this.warrant01 = warrant01;
	}
	public String getWarrant02() {
		return warrant02;
	}
	public void setWarrant02(String warrant02) {
		this.warrant02 = warrant02;
	}
	public String getLoanHouse() {
		return loanHouse;
	}
	public void setLoanHouse(String loanHouse) {
		this.loanHouse = loanHouse;
	}
	public double getCreditMoney() {
		return creditMoney;
	}
	public void setCreditMoney(double creditMoney) {
		this.creditMoney = creditMoney;
	}
	public double getConsumeMoney() {
		return consumeMoney;
	}
	public void setConsumeMoney(double consumeMoney) {
		this.consumeMoney = consumeMoney;
	}
	public String getCreditPwd() {
		return creditPwd;
	}
	public void setCreditPwd(String creditPwd) {
		this.creditPwd = creditPwd;
	}
	public double getUS_dollar() {
		return US_dollar;
	}
	public void setUS_dollar(double uS_dollar) {
		US_dollar = uS_dollar;
	}
	public double getHK_dollar() {
		return HK_dollar;
	}
	public void setHK_dollar(double hK_dollar) {
		HK_dollar = hK_dollar;
	}
	public double getJP_dollar() {
		return JP_dollar;
	}
	public void setJP_dollar(double jP_dollar) {
		JP_dollar = jP_dollar;
	}
	
	
	
}
