package com.bank.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.bank.entities.User;
import com.bank.service.UserService;
import com.bank.service.impl.UserServiceImpl;

public class Register extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private JPanel mainPanel;
	private JTextField userIdTxt;
	private JTextField personIdTxt;
	private JTextField userNameTxt;
	private JPasswordField userPwdTxt;
	private JTextField phoneTxt;
	private JTextField addrTxt;
	private ImageIcon background;			//����ͼ
	private JLabel backgroundCon;			//��������
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JComboBox<String> userType = new JComboBox<String>();		//ע��ʱ��ѡ���
	private JPanel stylePanel;
	
	
	
	
	public Register() throws HeadlessException {
		//����������
		setTitle("��ӭע��");
		//setLocation(200, 100);				/*����λ��*/
		setSize(600, 400);						/*���ô��ڴ�С*/
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);			/*�رմ���*/
		setUndecorated(true);
		//���ñ�����
		background = new ImageIcon("images/background.png");
		backgroundCon = new JLabel(background);
		backgroundCon.setBounds(0, 0,background.getIconWidth(), background.getIconHeight());
		getLayeredPane().add(backgroundCon, new Integer(Integer.MIN_VALUE));
		JPanel jp=(JPanel)getContentPane(); 
		jp.setOpaque(false);//����͸��
		
		//������ʽ���
		stylePanel = new JPanel();
		stylePanel.setBounds(163, 55, 350, 200);
		stylePanel.setOpaque(false);
		stylePanel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 0), 2, true), "\u6CE8\u518C\u8D26\u53F7", TitledBorder.RIGHT, TitledBorder.TOP, null, Color.ORANGE));
		getLayeredPane().add(stylePanel);
		
		//���������λ��
		mainPanel = new JPanel();
		mainPanel.setOpaque(false);
		mainPanel.setBounds(0, 0, 600, 400);
		setContentPane(mainPanel);
		mainPanel.setLayout(null);		/*ʹ�þ��Բ���*/
		
		userIdTxt = new JTextField();
		userIdTxt.setColumns(10);
		userIdTxt.setBounds(240, 70, 200, 20);
		userIdTxt.setOpaque(false);
		userIdTxt.setBorder(null);
		mainPanel.add(userIdTxt);
		
		personIdTxt = new JTextField();
		personIdTxt.setBounds(240, 100, 200, 20);
		mainPanel.add(personIdTxt);
		personIdTxt.setOpaque(false);
		personIdTxt.setBorder(null);
		personIdTxt.setColumns(10);
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		userNameTxt.setBounds(240, 130, 200, 20);
		userNameTxt.setOpaque(false);
		userNameTxt.setBorder(null);
		mainPanel.add(userNameTxt);
		
		userPwdTxt = new JPasswordField();
		userPwdTxt.setColumns(10);
		userPwdTxt.setBounds(240, 160, 200, 20);
		userPwdTxt.setOpaque(false);
		userPwdTxt.setBorder(null);
		mainPanel.add(userPwdTxt);
		
		phoneTxt = new JTextField();
		phoneTxt.setColumns(10);
		phoneTxt.setBounds(240, 190, 200, 20);
		phoneTxt.setOpaque(false);
		phoneTxt.setBorder(null);
		mainPanel.add(phoneTxt);
		
		addrTxt = new JTextField();
		addrTxt.setColumns(10);
		addrTxt.setBounds(240, 220, 200, 20);
		addrTxt.setOpaque(false);
		addrTxt.setBorder(null);
		mainPanel.add(addrTxt);
		
		//����ComboBox��λ�ú�����
		userType.setModel(new DefaultComboBoxModel<String>(new String[] {"����Ա�û�", "����ְԱ", "�ͻ�"}));
		userType.setBounds(350, 265, 99, 21);
		mainPanel.add(userType);
		
		//���ñ�ǩλ��
		label1 = new JLabel("�û�ID");
		label1.setBounds(180, 70, 200, 20);
		label1.setFont(new Font("����", Font.PLAIN, 16));
		mainPanel.add(label1);
		
		label2 = new JLabel("���֤");
		label2.setBounds(180, 100, 200, 20);
		label2.setFont(new Font("����", Font.PLAIN, 16));
		mainPanel.add(label2);
		
		label3 = new JLabel("����");
		label3.setBounds(180, 130, 200, 20);
		label3.setFont(new Font("����", Font.PLAIN, 16));
		mainPanel.add(label3);
		
		label4 = new JLabel("����");
		label4.setBounds(180, 160, 200, 20);
		label4.setFont(new Font("����", Font.PLAIN, 16));
		mainPanel.add(label4);
		
		label5 = new JLabel("�绰");
		label5.setBounds(180, 190, 200, 20);
		label5.setFont(new Font("����", Font.PLAIN, 16));
		mainPanel.add(label5);
		
		label6 = new JLabel("��ַ");
		label6.setBounds(180, 220, 200, 20);
		label6.setFont(new Font("����", Font.PLAIN, 16));
		mainPanel.add(label6);		
		
		//����ע�ᰴť
		JButton  regBut = new JButton();
		JButton  cancelBut = new JButton();
		regBut.setBounds(310, 300, 120, 36);
		cancelBut.setBounds(450, 300, 120, 36);
		cancelBut.setContentAreaFilled(false);			/*�쳣*/
		regBut.setContentAreaFilled(false);			/*�쳣*/
		regBut.setIcon(new ImageIcon("images/register.png"));
		cancelBut.setIcon(new ImageIcon("images/cancel.png"));
		mainPanel.add(regBut);
		mainPanel.add(cancelBut);
		
		//��ť����
		cancelBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelBut.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER){
					dispose();
				}
			}
		});
		regBut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				User user = new User();
				user.setUserId(userIdTxt.getText());
				user.setPersonId(personIdTxt.getText());
				user.setUserName(userNameTxt.getText());
				user.setUserPwd(String.valueOf(userPwdTxt.getPassword()));				/*   char* to String   */
				user.setPhone(phoneTxt.getText());
				user.setAddr(addrTxt.getText());
				user.setUserType(userType.getSelectedIndex());
				UserService service = new UserServiceImpl();
				Boolean flag = false;
				flag = service.regUser(user);
				if(flag) JOptionPane.showMessageDialog(null, "ע��ɹ���");
				else JOptionPane.showMessageDialog(null, "ע��ʧ��,���飡");
			}
		});
		regBut.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER){
					User user = new User();
					user.setUserId(userIdTxt.getText());
					user.setPersonId(personIdTxt.getText());
					user.setUserName(userNameTxt.getText());
					user.setUserPwd(String.valueOf(userPwdTxt.getPassword()));				/*   char* to String   */
					user.setPhone(phoneTxt.getText());
					user.setAddr(addrTxt.getText());
					user.setUserType(userType.getSelectedIndex());
					UserService service = new UserServiceImpl();
					Boolean flag = false;
					flag = service.regUser(user);
					if(flag) JOptionPane.showMessageDialog(null, "ע��ɹ���");
					else JOptionPane.showMessageDialog(null, "ע��ʧ��,���飡");
				}
			}
		});
	}
}
