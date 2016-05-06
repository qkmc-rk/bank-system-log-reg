package com.bank.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.bank.entities.User;
import com.bank.service.UserService;
import com.bank.service.impl.UserServiceImpl;
import com.bank.utils.Container;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel;				/*主面板*/
	private JTextField userIdField;
	private JPasswordField userPwdField;
	private JButton logBut;
	private JButton exitBut;
	private JButton RegBut;
	private ImageIcon background;				/*背景图片*/
	private JLabel backgroundCon;				/*背景图片容器*/
	private JLabel label1;
	private JLabel label2;
	private JLabel label;				/*标题*/
	
	public Login(){
		//设置框架
		setTitle("欢迎登陆");
		setSize(600, 400);
		//setLocation(220, 120);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setUndecorated( true);				//隐藏标题栏
		
		//设置背景图片
		background = new ImageIcon("images/background-login.png");
		backgroundCon = new JLabel(background);
		backgroundCon.setBounds(0, 0, background.getIconWidth(),background.getIconHeight());
		getLayeredPane().add(backgroundCon, new Integer(Integer.MIN_VALUE));
		JPanel jp = (JPanel)getContentPane();
		jp.setOpaque(false);
		
		//初始化mainPanel
		mainPanel  = new JPanel();
		mainPanel.setOpaque(false);
		mainPanel.setLayout(null);
		setContentPane(mainPanel);
		
		//设置标签
		label1 = new JLabel("用户ID:");
		label2 = new JLabel("密码:");
		label = new JLabel("阮氏银行管理系统");
		label.setFont(new Font("楷体",Font.BOLD,32));
		label1.setFont(new Font("楷体",Font.BOLD , 16));
		label2.setFont(new Font("楷体",Font.BOLD , 16));
		label.setBounds(170, 0, 450, 150);
		label.setForeground(Color.WHITE);
		label1.setForeground(Color.WHITE);
		label2.setForeground(Color.WHITE);
		label1.setBounds(164, 140, 80, 30);
		label2.setBounds(180,180, 60, 30);
		mainPanel.add(label1);
		mainPanel.add(label2);
		mainPanel.add(label);
		
		//设置TextField
		userIdField = new JTextField();
		userPwdField = new JPasswordField();
		userIdField.setBounds(230, 140, 200, 30);
		userPwdField.setBounds(230, 180, 200, 30);
		userIdField.setForeground(Color.white);
		userPwdField.setForeground(Color.white);
		userIdField.setBorder(null);
		userPwdField.setBorder(null);
		userIdField.setOpaque(false);
		userPwdField.setOpaque(false);
		mainPanel.add(userIdField);
		mainPanel.add(userPwdField);
		
		//设置按钮位置
		RegBut = new JButton();
		logBut = new JButton();
		exitBut = new JButton();
//		RegBut.setFont(new Font("微软雅黑",Font.PLAIN,16));
//		logBut.setFont(new Font("微软雅黑",Font.PLAIN,16));
//		exitBut.setFont(new Font("微软雅黑",Font.PLAIN,16));
		RegBut.setBounds(220, 280,120, 36);
		logBut.setBounds(350, 280,120, 36);
		exitBut.setBounds(480, 280,120, 36);
		RegBut.setContentAreaFilled(false);			/*异常*/
		logBut.setContentAreaFilled(false);			/*异常*/
		exitBut.setContentAreaFilled(false);			/*异常*/
		logBut.setIcon(new ImageIcon("images/login.png"));
		RegBut.setIcon(new ImageIcon("images/register.png"));
		exitBut.setIcon(new ImageIcon("images/exit.png"));
//		RegBut.setBorder(null);
//		logBut.setBorder(null);
//		exitBut.setBorder(null);
		mainPanel.add(RegBut);
		mainPanel.add(logBut);
		mainPanel.add(exitBut);
		
		//按钮交互
		exitBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		RegBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Register().setVisible(true);
			}
		});
		logBut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UserService service = new UserServiceImpl();
				if(userIdField.getText() != null && String.valueOf(userPwdField.getPassword()) != null){
					boolean flag = service.logUser(userIdField.getText(), String.valueOf(userPwdField.getPassword()));
					if(flag){
						User user = new User();
						user.setUserId(userIdField.getText());
						Container.register("user", user);//注册一下user，方便后面使用
						dispose();
						new InnerSystem().setVisible(true);
						
					}else{
						JOptionPane.showMessageDialog(null, "登陆失败","登陆异常", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
	}
}
