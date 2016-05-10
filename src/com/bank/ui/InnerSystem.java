package com.bank.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.bank.utils.Container;

public class InnerSystem extends JFrame {
	
	private static final long serialVersionUID = 1L;   //���ǣ�
	
	public InnerSystem(){
		/*����InnerSystem���������*/
			setTitle("�������й���ϵͳ");
			setSize(600, 400);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setResizable(false);
			setUndecorated( true);				//���ر�����
			
			//��������壬��дpaintComponent���������ñ���
			JPanel mainPanel =new  JPanel(){
				private static final long serialVersionUID = 1L;

				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					ImageIcon bg = new ImageIcon("images/InnerSystem.jpg");
					g.drawImage(bg.getImage(), 0, 0,this.getWidth(), this.getHeight(),null);
				}
			};
			mainPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
			this.getContentPane().add(mainPanel,BorderLayout.CENTER);
			mainPanel.setLayout(new CardLayout(0,0));//����Ϊ��Ƭ���֣�����������panel
			
			/*���ڼ������Panel*/
			CardPanel cardPanel = new CardPanel();
			cardPanel.refresh();
			mainPanel.add(cardPanel,"cardPanel");
			cardPanel.setOpaque(false);
			
			CardRegistPanel cardRegistPanel = new CardRegistPanel();
			mainPanel.add(cardRegistPanel,"cardRegistPanel");
			cardRegistPanel.setOpaque(false);
			
			/*��������ע�����*/
			Container.register("mainPanel",mainPanel);
			Container.register("cardPanel",cardPanel);
			Container.register("cardRegistPanel",cardRegistPanel);
		
	}
}
