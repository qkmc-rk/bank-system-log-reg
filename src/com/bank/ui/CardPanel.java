package com.bank.ui;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.bank.entities.Account;
import com.bank.entities.User;
import com.bank.service.AccountService;
import com.bank.service.impl.AccountServiceImpl;
import com.bank.utils.Container;
/*登陆成功后选择卡片的界面*/
public class CardPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	JLabel wecLabel = new JLabel("\u6B22\u8FCE\u4F60\u962E\u5764");
	JLabel choiceCard = new JLabel("\u9009\u62E9\u5361\u7247\uFF1A");
	private AccountService accountService = new AccountServiceImpl();
	JComboBox<String> cardsComBox = new JComboBox<>();
	
	
	public CardPanel() {
		setLayout(null);
	
		wecLabel.setFont(new Font("微软雅黑", Font.PLAIN, 21));
		wecLabel.setBounds(126, 49, 150, 43);
		add(wecLabel);
		
		choiceCard.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		choiceCard.setBounds(126, 123, 84, 28);
		add(choiceCard);
		

		cardsComBox.setBounds(220, 128, 230, 22);
		add(cardsComBox);
		
		JButton okBtn = new JButton("确定");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//获取accid之前先进行字符串截取
				String acctId = (String) cardsComBox.getSelectedItem();
				int index = acctId.indexOf("-");
				acctId = acctId.substring(0, index);
				/*---------------------------------*/
				try {
					/*跳转到BankPanel之前，先获取到下拉框中的acctId，然后再找到对应acct并注册为全局对象*/
					Account acct = accountService.findByAccountId(acctId);
					Container.register("acct", acct);
					/*执行跳转*/
					JPanel mainPanel = (JPanel)Container.getObject("mainPanel");
					CardLayout card = (CardLayout) mainPanel.getLayout();
					card.show(mainPanel, "bankPanel");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "发生内部错误，请检查["+e.getMessage()+"]");
					e.printStackTrace();
				}
			}
		});
		okBtn.setBounds(187, 239,120, 36);
		add(okBtn);
		
		JButton newHuBtn = new JButton("开户");
		newHuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel mainPanel = (JPanel)Container.getObject("mainPanel");
				CardLayout card = (CardLayout) mainPanel.getLayout();
				card.show(mainPanel, "cardRegistPanel");
			}
		});
		newHuBtn.setBounds(335, 239, 120, 36);
		add(newHuBtn);
		
		
	}
	public void refresh(){
		User user = (User)Container.getObject("user");
		wecLabel.setText("欢迎你，"+user.getUserId());
		/*刷新卡片数量*/
		String userId = user.getUserId();
		try {
			List<Account> accts = accountService.findAllByUserId(userId);
			cardsComBox.removeAllItems();
			if(accts != null && accts.size()>0){
				for(Account acct:accts){
					if(acct.getAccType() == 0)
						cardsComBox.addItem(acct.getAcctId()+"-一卡通");
					if(acct.getAccType() == 1)
						cardsComBox.addItem(acct.getAcctId()+"-贷款卡");
					if(acct.getAccType() == 2)
						cardsComBox.addItem(acct.getAcctId()+"-外汇卡");
					if(acct.getAccType() == 3)
						cardsComBox.addItem(acct.getAcctId()+"-信用卡");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
