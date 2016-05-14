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
package com.bank.test;

import java.sql.Connection;
import java.sql.Date;

import org.junit.Test;

import com.bank.entities.TransInfo;
import com.bank.service.TransService;
import com.bank.service.impl.TransServiceImpl;
import com.bank.utils.ConnectToJDBC;

/**
 * <p>公共方法类</p>
 *
 * @author Mr.Ruan
 * @version 1.0
 */
public class TestTransService {

	@Test
	public void testTransService() {
		//Connection conn = ConnectToJDBC.getConnection();
		TransService transService = new TransServiceImpl();
		TransInfo info = new TransInfo("10001", "369258147", 50.0, "pop", new Date(0));
		try {
			transService.add(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
