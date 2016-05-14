/*
 * Copyright (C) 2016 Ruan <qkmc@outlook.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.bank.entities;

import java.util.Date;

/**
 * <p>公共方法类</p>
 *
 * @author Mr.Ruan
 * @version 1.0
 */
public class TransInfo {
	private int id;
	private String userId;
	private String acctNo;
	private double money;
	private String transType;
	private Date transDate;
	public TransInfo(int id, String userId, String acctNo, double money, String transType, Date transDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.acctNo = acctNo;
		this.money = money;
		this.transType = transType;
		this.transDate = transDate;
	}
	
	
	public TransInfo(String userId, String acctNo, double money, String transType, Date transDate) {
		super();
		this.userId = userId;
		this.acctNo = acctNo;
		this.money = money;
		this.transType = transType;
		this.transDate = transDate;
	}


	public TransInfo() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	
	
}
