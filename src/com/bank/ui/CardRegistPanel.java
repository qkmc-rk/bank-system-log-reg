package com.bank.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class CardRegistPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField acctIdField;
	private JTextField saveMnyField;
	private JTextField saveYearField;
	private AccountService acctService = new AccountServiceImpl();

	public CardRegistPanel() {
		setLayout(null);
		
		JPanel innerPanel = new JPanel();
		innerPanel.setOpaque(false);
		innerPanel.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128), 2, true), "\u57FA\u672C\u4FE1\u606F", TitledBorder.LEFT, TitledBorder.TOP, null, Color.PINK));
		innerPanel.setBounds(116, 67, 375, 137);
		add(innerPanel);
		innerPanel.setLayout(null);
		
		JLabel acctId = new JLabel("\u5361\u53F7\uFF1A");
		acctId.setBounds(31, 26, 60, 18);
		innerPanel.add(acctId);
		
		acctIdField = new JTextField();
		acctIdField.setBounds(77, 25, 100, 20);
		innerPanel.add(acctIdField);
		acctIdField.setColumns(10);
		
		JLabel acctType = new JLabel("\u8D26\u6237\u7C7B\u578B\uFF1A");
		acctType.setBounds(9, 60, 63, 14);
		innerPanel.add(acctType);
		
		JComboBox<String> acctTypeCobx = new JComboBox<>();
		acctTypeCobx.setModel(new DefaultComboBoxModel<String>(new String[] {"\u4E00\u5361\u901A", "\u8D37\u6B3E\u5361", "\u5916\u6C47\u5361", "\u4FE1\u7528\u5361"}));
		acctTypeCobx.setBounds(76, 59, 100, 20);
		innerPanel.add(acctTypeCobx);
		
		JLabel saveMoney = new JLabel("\u5B58\u5165\u91D1\u989D\uFF1A");
		saveMoney.setBounds(10, 90, 69, 23);
		innerPanel.add(saveMoney);
		
		saveMnyField = new JTextField();
		saveMnyField.setColumns(10);
		saveMnyField.setBounds(77, 90, 100, 20);
		innerPanel.add(saveMnyField);
		
		JLabel saveType = new JLabel("\u5B58\u6B3E\u7C7B\u578B\uFF1A");
		saveType.setBounds(195, 28, 80, 14);
		innerPanel.add(saveType);
		
		JComboBox<String> saveTypeCob = new JComboBox<>();
		saveTypeCob.setModel(new DefaultComboBoxModel<String>(new String[] {"\u6D3B\u671F", "\u5B9A\u671F"}));
		saveTypeCob.setBounds(262, 23, 100, 20);
		innerPanel.add(saveTypeCob);
		
		JLabel saveYear = new JLabel("\u5B58\u6B3E\u671F\u9650\uFF1A");
		saveYear.setBounds(197, 60, 78, 14);
		innerPanel.add(saveYear);
		
		saveYearField = new JTextField();
		saveYearField.setColumns(10);
		saveYearField.setBounds(262, 59, 100, 20);
		saveYearField.setText("-1");//活期的话存款期限为-1表示无意义
		saveYearField.setEditable(false);
		innerPanel.add(saveYearField);
		
		JButton button = new JButton("\u5F00 \u6237");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Account acct = new Account();
				User user = (User)Container.getObject("user");
				acct.setUserId(user.getUserId());
				acct.setAcctId(acctIdField.getText());
				acct.setAccType(acctTypeCobx.getSelectedIndex());
				acct.setSaveMoney(Double.parseDouble(saveMnyField.getText()));
				acct.setSaveType(saveTypeCob.getSelectedIndex());
				acct.setSaveYear(Integer.parseInt(saveYearField.getText()));
				if(Integer.parseInt(saveYearField.getText()) <= 1 && saveTypeCob.getSelectedIndex() == 1){
					acct.setSaveYear(1);
					JOptionPane.showMessageDialog(null, "存储年限小于1，默认初始化为1年！");
				}
				try {
					acctService.register(acct);
					JOptionPane.showMessageDialog(null, "开户成功！");
					//开户成功则跳转页面
					CardPanel cardPanel = (CardPanel)Container.getObject("cardPanel");
					cardPanel.refresh();
					JPanel mainPanel = (JPanel)Container.getObject("mainPanel");
					CardLayout card = (CardLayout) mainPanel.getLayout();
					card.show(mainPanel, "cardPanel");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "注册失败，检查【"+e.getMessage()+"】");
					e.printStackTrace();
				}
			}
		});
		saveTypeCob.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(saveTypeCob.getSelectedIndex() ==0){
					saveYearField.setText("-1");//活期的话存款期限为-1表示无意义
					saveYearField.setEditable(false);
				}
				if(saveTypeCob.getSelectedIndex() ==1){
					saveYearField.setText("");//活期的话存款期限为-1表示无意义
					saveYearField.setEditable(true);
				}
			}
		});
		button.setBounds(276, 254, 89, 23);
		add(button);

	}
}
