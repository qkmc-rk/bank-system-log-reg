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

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import com.bank.utils.XTabbedPanel;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * <p>公共方法类</p>
 *
 * @author Mr.Ruan
 * @version 1.0
 */
public class BankPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private Map<String, JComponent> datas = new HashMap<String, JComponent>();

	/**
	 * Create the panel.
	 */
	public BankPanel() {
		MoneyPanel moneyPanel = new MoneyPanel();
		SystemPanel systemPanel = new SystemPanel();
		
		datas.put("储蓄业务", moneyPanel);
		datas.put("系统管理", systemPanel);
		
		setSize(600, 400);
		setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, 600, 400);
		splitPane.setDividerLocation(200);
		add(splitPane);
		
		JTree bankMenu = new JTree();
		bankMenu.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		bankMenu.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("\u94F6\u884C\u7BA1\u7406\u7CFB\u7EDF") {
				private static final long serialVersionUID = 1L;

				{
					add(new DefaultMutableTreeNode("\u50A8\u84C4\u4E1A\u52A1"));
					add(new DefaultMutableTreeNode("\u8D37\u6B3E\u4E1A\u52A1"));
					add(new DefaultMutableTreeNode("\u5916\u6C47\u4E1A\u52A1"));
					add(new DefaultMutableTreeNode("\u7CFB\u7EDF\u7BA1\u7406"));
				}
			}
		));
		splitPane.setLeftComponent(bankMenu);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setDividerLocation(200);
		splitPane.setRightComponent(splitPane_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		splitPane_1.setLeftComponent(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane_1.setRightComponent(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null,null}
			},
			new String[] {
				"账户ID", "卡号", "金额", "交易类型","交易日期"
			}
		));
		scrollPane.setViewportView(table);
		
		/*给左侧tree添加选择事件*/
		bankMenu.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override/*当值改变时*/
			public void valueChanged(TreeSelectionEvent e) {
				TreePath path = e.getPath();
				if(path == null) 
					return;
				bankMenu.setSelectionPath(path);
				DefaultMutableTreeNode node=(DefaultMutableTreeNode)bankMenu.
						getLastSelectedPathComponent();
				/*进行判断*/
				if(node.isLeaf()){
					String name = path.getPathComponent(path.getPathCount() - 1).toString();
					JComponent textPane = datas.get(name);
					
					if(textPane == null){
						textPane = new ErrorPanel();
						tabbedPane.addTab(name, null,textPane,null);
						tabbedPane.setTabComponentAt(tabbedPane.getTabCount() - 1, new 
								XTabbedPanel(tabbedPane));
						tabbedPane.setSelectedComponent(textPane);
						datas.put(name, textPane);
					}else{
						/*首先进行判断要显示的面板，然后对面板进行一系列初始化操作，比如显示余额*/
						if(textPane instanceof MoneyPanel){
							MoneyPanel mp = (MoneyPanel)textPane;
							mp.refresh();
						}
						tabbedPane.addTab(name, null,textPane,null);
						tabbedPane.setTabComponentAt(tabbedPane.getTabCount() -1, new 
								XTabbedPanel(tabbedPane));
						tabbedPane.setSelectedComponent(textPane);
					}
				}		
			}
		});
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

}
