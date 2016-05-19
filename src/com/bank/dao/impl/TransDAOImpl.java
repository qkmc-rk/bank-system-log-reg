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
package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.TransDAO;
import com.bank.entities.TransInfo;

/**
 * <p>公共方法类</p>
 *
 * @author Mr.Ruan
 * @version 1.0
 */
public class TransDAOImpl implements TransDAO {

	@Override
	public void add(TransInfo info, Connection conn) throws Exception {
		String sql = "insert into t_transInfo(userId, acctNo, money, transType, transDate)values(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, info.getUserId());
		pstmt.setString(2, info.getAcctNo());
		pstmt.setDouble(3, info.getMoney());
		pstmt.setString(4, info.getTransType());
		//pstmt.setDate(5, new java.sql.Date(info.getTransDate().getTime()));
		pstmt.setTimestamp(5, new Timestamp(info.getTransDate().getTime()));
		pstmt.executeUpdate();
	}

	@Override
	public List<TransInfo> findAll(Connection conn) throws Exception {
			List<TransInfo> infos = new ArrayList<>();
			String sql = "select * from t_transInfo order by id desc";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				TransInfo info = new TransInfo();
				info.setUserId(rs.getString(2));
				info.setAcctNo(rs.getString(3));
				info.setMoney(rs.getDouble(4));
				info.setTransType(rs.getString(5));
				info.setTransDate(rs.getDate(6));
				infos.add(info);
			}
		return infos;
	}

	@Override
	public List<TransInfo> findByUserId(String userId, Connection conn) throws Exception {
		List<TransInfo> infos = new ArrayList<>();
		String sql = "select * from t_transInfo where userId='"+userId+"'"+"order by id desc" ;
		PreparedStatement pstmt= conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			TransInfo info = new TransInfo();
			info.setUserId(rs.getString(2));
			info.setAcctNo(rs.getString(3));
			info.setMoney(rs.getDouble(4));
			info.setTransType(rs.getString(5));
			info.setTransDate(rs.getDate(6));
			infos.add(info);
		}
		return infos;
	}
}
