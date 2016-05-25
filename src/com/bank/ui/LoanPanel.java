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

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.bank.entities.Account;
import com.bank.entities.User;
import com.bank.service.AccountService;
import com.bank.service.impl.AccountServiceImpl;
import com.bank.utils.Container;

/**
 * <p>����������</p>
 *
 * @author Mr.Ruan
 * @version 1.0
 */
public class LoanPanel extends JPanel {
	private JTextField LoanYearTextField;
	private JTextField War1textField;
	private JTextField War2textField;
	private JTextField LoanMoneyTextField;
	private JTextField LoanHousetextField;
	private AccountService accountService = new AccountServiceImpl();

	/**
	 * Create the panel.
	 */
	public LoanPanel() {
		setLayout(null);
		
		JComboBox LoanTypeComboBox = new JComboBox();
		LoanTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"\u77ED\u671F", "\u4E2D\u671F", "\u957F\u671F"}));
		LoanTypeComboBox.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		LoanTypeComboBox.setBounds(99, 6, 65, 20);
		add(LoanTypeComboBox);
		
		JLabel LoanTypelabel = new JLabel("\u8D37\u6B3E\u7C7B\u578B\uFF1A");
		LoanTypelabel.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		LoanTypelabel.setBounds(15, 0, 74, 32);
		add(LoanTypelabel);
		
		JLabel LoanYearlabel = new JLabel("\u8D37\u6B3E\u65F6\u957F\uFF1A");
		LoanYearlabel.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		LoanYearlabel.setBounds(15, 31, 74, 32);
		add(LoanYearlabel);
		
		LoanYearTextField = new JTextField();
		LoanYearTextField.setBounds(99, 38, 65, 20);
		add(LoanYearTextField);
		LoanYearTextField.setColumns(10);
		
		JLabel LoanMoneylabel = new JLabel("\u8D37\u6B3E\u989D\u5EA6\uFF1A");
		LoanMoneylabel.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		LoanMoneylabel.setBounds(174, 7, 65, 18);
		add(LoanMoneylabel);
		
		LoanMoneyTextField = new JTextField();
		LoanMoneyTextField.setBounds(238, 7, 79, 20);
		add(LoanMoneyTextField);
		LoanMoneyTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uFF08\u77ED\u671F\u4EE5\u5929\u8BA1\u6570\uFF0C\u957F\u4E2D\u671F\u4EE5\u5E74\u8BA1\u6570\uFF09");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(174, 41, 184, 14);
		add(lblNewLabel);
		
		JPanel Stupanel = new JPanel();
		Stupanel.setBounds(0, 66, 358, 107);
		add(Stupanel);
		Stupanel.setBorder(new TitledBorder(new LineBorder(new Color(255, 200, 0)), "\u5206\u7C7B\u8BE6\u7EC6\u4FE1\u606F\u680F", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Stupanel.setLayout(null);
		
		JLabel War2label = new JLabel("\u62C5\u4FDD\u4EBA2\uFF1A");
		War2label.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		War2label.setBounds(20, 51, 72, 14);
		Stupanel.add(War2label);
		
		War2textField = new JTextField();
		War2textField.setColumns(10);
		War2textField.setBounds(90, 49, 86, 20);
		Stupanel.add(War2textField);
		
		JButton StuBtn = new JButton("\u786E\u8BA4\u5B66\u751F\u8D37\u6B3E");
		StuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*ѧ����������*/
				/*���Ȼ�ȡѧ�������User��Accout*/
				Account acct = (Account)Container.getObject("acct");
				User user =(User)Container.getObject("user");
				/*�����ж��ǲ��Ǵ��*/
				if(acct.getAccType() != 1){
					JOptionPane.showMessageDialog(null, "���Ǵ�����޷��������ҵ��");
					try {
						throw new Exception("�˿����Ǵ��");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else if(acct.getLoanMoney() != 0){
					JOptionPane.showMessageDialog(null, "�˿��Ѵ���޷������������ҵ��");
					try {
						throw new Exception("�˿��Ѵ���");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else{
					/*�����������ʱ��Ͷ��*/
					int  LoanType = LoanTypeComboBox.getSelectedIndex();
					int LoanYear = Integer.parseInt(LoanYearTextField.getText());
					double LoanMoney = Double.parseDouble(LoanMoneyTextField.getText());
					acct.setLoanType(LoanType);
					if(LoanType == 0 && Integer.parseInt(LoanYearTextField.getText())>0&& Integer.parseInt(LoanYearTextField.getText())<365)
						acct.setLoanYear(LoanYear);
					else if(LoanType == 1 && Integer.parseInt(LoanYearTextField.getText())>=1&& Integer.parseInt(LoanYearTextField.getText())<=3)
						acct.setLoanYear(LoanYear);
					else if(LoanType == 2 && Integer.parseInt(LoanYearTextField.getText())>3 && Integer.parseInt(LoanYearTextField.getText())<=8)
						acct.setLoanYear(LoanYear);
					else{
						JOptionPane.showMessageDialog(null, "�������޺����Ϳ�����������ϸ�Ķ��������");
						try {
							throw new Exception("�����쳣");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					acct.setLoanMoney(LoanMoney);
					acct.setWarrant01(War1textField.getText());
					acct.setWarrant02(War2textField.getText());
					acct.setLoanDate(new Date());
					/*�������ݿ�*/
					try {
						accountService.updateAccount(acct);
						JOptionPane.showMessageDialog(null, "������ɣ����Ժ�鿴�������!");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,"�޷���ɴ������󣬴���["+e.getMessage()+"]");
						e.printStackTrace();
					}
				}
			}
		});
		StuBtn.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		StuBtn.setBounds(214, 23, 113, 30);
		Stupanel.add(StuBtn);
		
		JLabel War1label = new JLabel("\u62C5\u4FDD\u4EBA1\uFF1A");
		War1label.setBounds(20, 23, 72, 14);
		Stupanel.add(War1label);
		War1label.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		
		War1textField = new JTextField();
		War1textField.setBounds(90, 20, 86, 20);
		Stupanel.add(War1textField);
		War1textField.setColumns(10);
		
		JLabel LoanHouseLabel = new JLabel("\u623F\u5C4B\u4EF7\u503C\uFF1A");
		LoanHouseLabel.setBounds(14, 76, 66, 20);
		Stupanel.add(LoanHouseLabel);
		LoanHouseLabel.setFont(new Font("΢���ź�", Font.PLAIN, 13));
		
		LoanHousetextField = new JTextField();
		LoanHousetextField.setBounds(90, 76, 86, 20);
		Stupanel.add(LoanHousetextField);
		LoanHousetextField.setColumns(10);
		
		JButton PerBtn = new JButton("\u786E\u8BA4\u4E2A\u4EBA\u8D37\u6B3E");
		PerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*ѧ����������*/
				/*���Ȼ�ȡ���˴����User��Accout*/
				Account acct = (Account)Container.getObject("acct");
				User user =(User)Container.getObject("user");
				/*�����ж��ǲ��Ǵ��*/
				if(acct.getAccType() != 1){
					JOptionPane.showMessageDialog(null, "���Ǵ�����޷��������ҵ��");
					try {
						throw new Exception("�˿����Ǵ��");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else if(acct.getLoanMoney() != 0){
					JOptionPane.showMessageDialog(null, "�˿��Ѵ���޷������������ҵ��");
					try {
						throw new Exception("�˿��Ѵ���");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else{
					/*�����������ʱ��Ͷ��*/
					int  LoanType = LoanTypeComboBox.getSelectedIndex();
					int LoanYear = Integer.parseInt(LoanYearTextField.getText());
					double LoanMoney = Double.parseDouble(LoanMoneyTextField.getText());
					acct.setLoanType(LoanType);
					if(LoanType == 0 && Integer.parseInt(LoanYearTextField.getText())>0&& Integer.parseInt(LoanYearTextField.getText())<365)
						acct.setLoanYear(LoanYear);
					else if(LoanType == 1 && Integer.parseInt(LoanYearTextField.getText())>=1&& Integer.parseInt(LoanYearTextField.getText())<=3)
						acct.setLoanYear(LoanYear);
					else if(LoanType == 2 && Integer.parseInt(LoanYearTextField.getText())>3 && Integer.parseInt(LoanYearTextField.getText())<=8)
						acct.setLoanYear(LoanYear);
					else{
						JOptionPane.showMessageDialog(null, "�������޺����Ϳ�����������ϸ�Ķ��������");
						try {
							throw new Exception("�����쳣");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					acct.setLoanMoney(LoanMoney);
					acct.setLoanHouse(LoanHousetextField.getText());
					if(Integer.parseInt(LoanMoneyTextField.getText()) > Integer.parseInt(LoanHousetextField.getText())*0.8 ||Integer.parseInt(LoanMoneyTextField.getText()) < 0){
						JOptionPane.showMessageDialog(null, "�����ȳ������ߵ���0�����������");
						acct.setLoanHouse("0");
						acct.setLoanMoney(0);
						try {
							throw new Exception("�����ȹ���");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else{
						acct.setLoanDate(new Date());
						/*�������ݿ�*/
						try {
							accountService.updateAccount(acct);
							JOptionPane.showMessageDialog(null, "������ɣ����Ժ�鿴�������!");
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null,"�޷���ɴ������󣬴���["+e.getMessage()+"]");
							e.printStackTrace();
						}
					}
					
				}
				}
		});
		PerBtn.setBounds(214, 64, 113, 30);
		Stupanel.add(PerBtn);
		PerBtn.setFont(new Font("΢���ź�", Font.PLAIN, 13));

	}
}
