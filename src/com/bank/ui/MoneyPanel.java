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
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.bank.entities.Account;
import com.bank.entities.TransInfo;
import com.bank.entities.User;
import com.bank.service.AccountService;
import com.bank.service.TransService;
import com.bank.service.UserService;
import com.bank.service.impl.AccountServiceImpl;
import com.bank.service.impl.TransServiceImpl;
import com.bank.service.impl.UserServiceImpl;
import com.bank.utils.Container;

/**
 * <p>����������</p>
 *
 * @author Mr.Ruan
 * @version 1.0
 */
public class MoneyPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField SavedField;
	private JTextField MoneyField;
	private JTextField AcctIdField;
	private JTextField UserField;
	/*ע�����*/
	private AccountService accountService = new AccountServiceImpl();
	private UserService userService = new UserServiceImpl();
	private TransService transService = new TransServiceImpl();

	/**
	 * Create the panel.
	 */
	public MoneyPanel() {
		setLayout(null);
		
		JLabel savedlabel = new JLabel("\u4F59\u989D\uFF1A");
		savedlabel.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		savedlabel.setBounds(50, 11, 46, 14);
		add(savedlabel);
		
		JLabel Moneylabel = new JLabel("\u91D1\u989D\uFF1A");
		Moneylabel.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		Moneylabel.setBounds(50, 36, 46, 14);
		add(Moneylabel);
		
		JLabel acctIdLabel = new JLabel("\u6536\u6B3E\u8D26\u53F7\uFF1A");
		acctIdLabel.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		acctIdLabel.setBounds(25, 61, 65, 14);
		add(acctIdLabel);
		
		JLabel Userlabel = new JLabel("\u6536\u6B3E\u4EBA\uFF1A");
		Userlabel.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		Userlabel.setBounds(35, 85, 61, 14);
		add(Userlabel);
		
		SavedField = new JTextField();
		SavedField.setEditable(false);
		SavedField.setBounds(106, 9, 100, 20);
		add(SavedField);
		SavedField.setColumns(10);
		
		MoneyField = new JTextField();
		MoneyField.setColumns(10);
		MoneyField.setBounds(106, 34, 100, 20);
		add(MoneyField);
		
		AcctIdField = new JTextField();
		AcctIdField.setColumns(10);
		AcctIdField.setBounds(106, 59, 100, 20);
		add(AcctIdField);
		
		UserField = new JTextField();
		UserField.setColumns(10);
		UserField.setBounds(106, 83, 100, 20);
		add(UserField);
		
		JButton saveBtn = new JButton("\u5B58\u6B3E");
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*���Ȼ�ȡContainer�е�acct,user*/
				Account acct = (Account)Container.getObject("acct");
				User user = (User)Container.getObject("user");
				/*����ֵ*/
				acct.setSaveMoney(acct.getSaveMoney()+Double.parseDouble(MoneyField.getText()));
				/*�����ݿ���и���*/
				try {
					accountService.updateAccount(acct);
					TransInfo info = new TransInfo();
					info.setUserId(user.getUserId());
					info.setAcctNo(acct.getAcctId());
					info.setMoney(Double.parseDouble(MoneyField.getText()));
					info.setTransType("push");
					info.setTransDate(new Date());
					transService.add(info);
					refresh();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "���ʧ�ܣ�ԭ��["+e.getMessage()+"]");
					e.printStackTrace();
				}
			}
		});
		saveBtn.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		saveBtn.setBounds(10, 110, 89, 23);
		add(saveBtn);
		
		JButton getBtn = new JButton("\u53D6\u6B3E");
		getBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*���Ȼ�ȡContainer�е�acct*/
				Account acct = (Account)Container.getObject("acct");
				User user = (User)Container.getObject("user");
				
				/*�ж��Ƿ��Ƕ���*/
				if(acct.getSaveYear()  != -1 && (new Date().getTime()-acct.getSaveDate().getTime())/(1000*60*60*24) < acct.getSaveYear()*365){
						JOptionPane.showMessageDialog(null, "���ڴ��ʱ��δ�����޷�ȡ��");
				}else{
					/*����Ƿ��㹻*/
					if(acct.getSaveMoney() <Double.parseDouble(MoneyField.getText())){
						JOptionPane.showMessageDialog(null, "�˻�����");
					}
					//System.out.println((new Date().getTime()-acct.getSaveDate().getTime())/(1000*60*60*24));
					else{
						/*����ֵ*/
						acct.setSaveMoney(acct.getSaveMoney()-Double.parseDouble(MoneyField.getText()));
						/*�����ݿ���и���*/
						try {
							accountService.updateAccount(acct);
							TransInfo info = new TransInfo();
							info.setUserId(user.getUserId());
							info.setAcctNo(acct.getAcctId());
							info.setMoney(Double.parseDouble(MoneyField.getText()));
							info.setTransType("pop");
							info.setTransDate(new Date());
							transService.add(info);
							refresh();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "ȡ��ʧ�ܣ�ԭ��["+e1.getMessage()+"]");
							e1.printStackTrace();
						}
					}
				}
				
				
			}
		});
		getBtn.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		getBtn.setBounds(106, 110, 89, 23);
		add(getBtn);
		
		JButton transBtn = new JButton("\u8F6C\u8D26");
		transBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*ת��*/
				try {
					/*��ȡ�Է���Account*/
					Account opAccount = accountService.findByAccountId(AcctIdField.getText());
					if(opAccount == null){
						JOptionPane.showMessageDialog(null, "���˺Ų�����");
					}else{
						/*��ȡ�Է�User*/
						User opUser = userService.findUserByUserId(opAccount.getUserId());
						if(UserField.getText().equals(opUser.getUserName())){
							/********/
							/*ת��֮ǰ���Ȼ�ȡContainer�е�acct*/
							Account acct = (Account)Container.getObject("acct");
							if(acct.getSaveMoney() <Double.parseDouble(MoneyField.getText())){	/*�ж�����Ƿ���*/
								JOptionPane.showMessageDialog(null, "�˻�����");
							}else{
								/*�㣡һ��Ǯ�ӣ�һ��Ǯ��*/
								acct.setSaveMoney(acct.getSaveMoney()-Double.parseDouble(MoneyField.getText()));
								opAccount.setSaveMoney(opAccount.getSaveMoney()+Double.parseDouble(MoneyField.getText()));
								/*�����ݿ���и���*/
								try {
									/*�������ݿ����*/
									/*ת�˷�ֹ��������ʹ��ͬһ������У�������ع�*/
									accountService.transferm(acct, opAccount);
									TransInfo info = new TransInfo();
									info.setUserId(opUser.getUserId());
									info.setAcctNo(acct.getAcctId());
									info.setMoney(Double.parseDouble(MoneyField.getText()));
									info.setTransType("transfer");
									info.setTransDate(new Date());
									transService.add(info);
									refresh();
								} catch (Exception e1) {
									JOptionPane.showMessageDialog(null, "ȡ��ʧ�ܣ�ԭ��["+e1.getMessage()+"]");
									e1.printStackTrace();
								}
								
								/********/
							}
						}else{
							JOptionPane.showMessageDialog(null, "�û���ƥ��");
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		transBtn.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		transBtn.setBounds(205, 110, 89, 23);
		add(transBtn);
		
		JButton refreshMoney = new JButton("\u5237\u65B0\u4F59\u989D");
		refreshMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		refreshMoney.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		refreshMoney.setBounds(304, 110, 89, 23);
		add(refreshMoney);

	}

	public void refresh() {
		Account acct = (Account)Container.getObject("acct");
		try {
			acct = accountService.findByAccountId(acct.getAcctId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		SavedField.setText(acct.getSaveMoney()+"");
		
		/*���ı��������ղ���*/
		MoneyField.setText("");
		AcctIdField.setText("");
		UserField.setText("");
		
		/*��ʾ���׼�¼��table����*/
		try {
			//User user = (User)Container.getObject("user");
			//List<TransInfo> infos = transService.findByUserId(user.getUserId());
			List<TransInfo> infos = transService.findAdd();
			Object[][] datas = new Object[infos.size()][5];
			for(int i=0; i<infos.size(); i++){
				datas[i][0] = infos.get(i).getUserId();
				datas[i][1] = infos.get(i).getAcctNo();
				datas[i][2] = infos.get(i).getMoney();
				datas[i][3] = infos.get(i).getTransType();
				datas[i][4] = infos.get(i).getTransDate();
				/*ת�˻���ȡ����Ϊ��*/
				//if(infos.get(i).getTransType().equals("pop") || infos.get(i).getTransType().equals("transfer")){
				//	datas[i][2] = infos.get(i).getMoney()-2* infos.get(i).getMoney();
			//	}
			}
			BankPanel bankPanel = (BankPanel)Container.getObject("bankPanel");
			bankPanel.getTable().setModel(new DefaultTableModel(datas,new String[] {"�˻�ID", "����", "���", "��������","��������"}));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}









