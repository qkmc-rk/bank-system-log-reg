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
package com.bank.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.bank.entities.User;
import com.bank.service.Rules;
import com.bank.service.UserService;
import com.bank.service.impl.UserServiceImpl;
import com.bank.utils.Container;

/**
 * <p>公共方法类</p>
 *
 * @author Mr.Ruan
 * @version 1.0
 */
public class SystemPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPasswordField oldPsw;
	private JPasswordField newPsd1;
	private JPasswordField newPsd2;
	private UserService userService = new UserServiceImpl();

	/**
	 * Create the panel.
	 */
	public SystemPanel() {
		setLayout(null);
		
		JLabel label = new JLabel("\u539F\u59CB\u5BC6\u7801\uFF1A");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		label.setBounds(40, 23, 85, 40);
		add(label);
		
		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		label_1.setBounds(53, 64, 85, 40);
		add(label_1);
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u65B0\u5BC6\u7801\uFF1A");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		label_2.setBounds(26, 101, 85, 40);
		add(label_2);
		
		JButton chgBtn = new JButton("\u66F4\u6539\u5BC6\u7801");
		chgBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = (User)Container.getObject("user");
				if(user.getUserPwd().equals(new String(oldPsw.getPassword()))){
					if(new String(newPsd1.getPassword()).equals(new String(newPsd2.getPassword()))){
						if(new String(newPsd1.getPassword()).equals(new String(newPsd2.getPassword())) && !(new String(newPsd1.getPassword()).equals(new String(oldPsw.getPassword())))){
							String newPwd = new String(newPsd1.getPassword());
							try {
								Rules.validataUserPwd(new User(), user.getUserId(), new String(newPsd1.getPassword()));
								userService.updatePwd(user, newPwd);
								JOptionPane.showMessageDialog(null, "密码修改成功！");
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							
						}else{
							JOptionPane.showMessageDialog(null, "修改密码不能与原密码相同！");
						}
					}else{
						JOptionPane.showMessageDialog(null, "两次输入密码不一致！");
					}
				}else{
					JOptionPane.showMessageDialog(null, "原密码输入错误，请检查！");
				}
				
			}
		});
		chgBtn.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		chgBtn.setBounds(213, 142, 89, 23);
		add(chgBtn);
		
		oldPsw = new JPasswordField();
		oldPsw.setBounds(125, 34, 100, 21);
		add(oldPsw);
		
		newPsd1 = new JPasswordField();
		newPsd1.setBounds(125, 75, 100, 21);
		add(newPsd1);
		
		newPsd2 = new JPasswordField();
		newPsd2.setBounds(125, 115, 100, 21);
		add(newPsd2);

	}
}
