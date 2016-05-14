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
package com.bank.utils;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * <p>公共方法类</p>
 *
 * @author Mr.Ruan
 * @version 1.0
 */
public class XTabbedPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private final JTabbedPane pane;
	
	/*构造*/
	public XTabbedPanel(final JTabbedPane pane) {
		super(new FlowLayout(FlowLayout.LEFT,0,0));
		if(pane == null)throw new NullPointerException("TabbledPane is null");
		this.pane = pane;/*初始化这个面板*/
		setOpaque(false);
		
		/*Tab标题*/
		JLabel label = new JLabel(){
			private static final long serialVersionUID = 1L;
			@Override
			public String getText() {
				int i = pane.indexOfTabComponent(XTabbedPanel.this);
				if(i != -1) return pane.getTitleAt(i);
				return null;
			};
		};
		
		add(label);//把获得的标签显示到XTabbedPanel上
		label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 2));
		add(new TabButton());
	}
	/*使用内部类实现tab上的关闭按钮*/
	private class TabButton extends JButton{
		private static final long serialVersionUID = 1L;
		private ImageIcon icon;
		public TabButton(){
			icon = new ImageIcon("images/close.png");
			setSize(20,20);								/*需要重新调整*/
			setIcon(icon);
			setBorder(null);
			setBorderPainted(false);
			setFocusPainted(false);
			/*设置开启关闭时间的图片显示*/
			setPressedIcon(new ImageIcon("images/close_pressed.png"));
			setRolloverIcon(new ImageIcon("images/close_rollover.png"));
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					pane.remove(pane.indexOfTabComponent(XTabbedPanel.this));
					if(pane.getTabCount() == 0){
						
					}
				}
			});
			
		}
	}
	
}
