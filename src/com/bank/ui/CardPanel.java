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
import javax.swing.JPanel;

import com.bank.entities.Account;
import com.bank.entities.User;
import com.bank.service.AccountService;
import com.bank.service.impl.AccountServiceImpl;
import com.bank.utils.Container;
/*µÇÂ½³É¹¦ºóÑ¡Ôñ¿¨Æ¬µÄ½çÃæ*/
public class CardPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	JLabel wecLabel = new JLabel("\u6B22\u8FCE\u4F60\u962E\u5764");
	JLabel choiceCard = new JLabel("\u9009\u62E9\u5361\u7247\uFF1A");
	private AccountService accountService = new AccountServiceImpl();
	JComboBox<String> cardsComBox = new JComboBox<>();
	
	
	public CardPanel() {
		setLayout(null);
	
		wecLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 21));
		wecLabel.setBounds(126, 49, 150, 43);
		add(wecLabel);
		
		choiceCard.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		choiceCard.setBounds(126, 123, 84, 28);
		add(choiceCard);
		

		cardsComBox.setBounds(220, 128, 230, 22);
		add(cardsComBox);
		
		JButton okBtn = new JButton();
		okBtn.setBounds(187, 239,120, 36);
		okBtn.setIcon(new ImageIcon("images/login.png"));
		add(okBtn);
		
		JButton newHuBtn = new JButton();
		newHuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel mainPanel = (JPanel)Container.getObject("mainPanel");
				CardLayout card = (CardLayout) mainPanel.getLayout();
				card.show(mainPanel, "cardRegistPanel");
			}
		});
		newHuBtn.setBounds(335, 239, 120, 36);
		newHuBtn.setIcon(new ImageIcon("images/login.png"));
		add(newHuBtn);
		
		
	}
	public void refresh(){
		User user = (User)Container.getObject("user");
		wecLabel.setText("»¶Ó­Äã£¬"+user.getUserId());
		/*Ë¢ÐÂ¿¨Æ¬ÊýÁ¿*/
		String userId = user.getUserId();
		try {
			List<Account> accts = accountService.findAllByUserId(userId);
			cardsComBox.removeAllItems();
			if(accts != null && accts.size()>0){
				for(Account acct:accts){
					cardsComBox.addItem(acct.getAcctId());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
