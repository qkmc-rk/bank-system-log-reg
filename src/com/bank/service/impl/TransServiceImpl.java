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
package com.bank.service.impl;

import java.sql.Connection;
import java.util.List;

import com.bank.dao.TransDAO;
import com.bank.dao.impl.TransDAOImpl;
import com.bank.entities.TransInfo;
import com.bank.service.TransService;
import com.bank.utils.ConnectToJDBC;

/**
 * <p>公共方法类</p>
 *
 * @author Mr.Ruan
 * @version 1.0
 */
public class TransServiceImpl implements TransService{
	
	private TransDAO transdao = new TransDAOImpl();
	
	@Override
	public void add(TransInfo info) throws Exception {
		Connection conn = ConnectToJDBC.getConnection();
		conn.setAutoCommit(false);
		transdao.add(info, conn);
		conn.commit();
		conn.close();
	}

	@Override
	public List<TransInfo> findAdd() throws Exception {
		Connection conn = ConnectToJDBC.getConnection();
		conn.setAutoCommit(false);
		List<TransInfo> infos = transdao.findAll(conn);
		conn.commit();
		conn.close();
		return infos;
	}

	@Override
	public List<TransInfo> findByUserId(String userId) throws Exception {
		Connection conn = ConnectToJDBC.getConnection();
		conn.setAutoCommit(false);
		List<TransInfo> infos = transdao.findByUserId(userId, conn);
		conn.commit();
		conn.close();
		return infos;
	}
	
}
