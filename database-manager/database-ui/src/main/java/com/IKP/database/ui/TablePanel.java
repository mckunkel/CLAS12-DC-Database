/*  +__^_________,_________,_____,________^-.-------------------,
 *  | |||||||||   `--------'     |          |                   O
 *  `+-------------USMC----------^----------|___________________|
 *    `\_,---------,---------,--------------'
 *      / X MK X /'|       /'
 *     / X MK X /  `\    /'
 *    / X MK X /`-------'
 *   / X MK X /
 *  / X MK X /
 * (________(                @author m.c.kunkel
 *  `------'
*/
package com.IKP.database.ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import com.IKP.database.model.entities.User;

public class TablePanel extends JPanel {

	private JTable userTable;
	private UserTableModel tableModel;

	public TablePanel() {
		initializeVariables();
		initialLayout();
		initializeTableAlignment();
		initializeHeaderAlignment();
	}

	private void initializeTableAlignment() {

		DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer();
		tableCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		this.userTable.getColumnModel().getColumn(0).setCellRenderer(tableCellRenderer);
		this.userTable.getColumnModel().getColumn(1).setCellRenderer(tableCellRenderer);
		this.userTable.getColumnModel().getColumn(2).setCellRenderer(tableCellRenderer);
		this.userTable.getColumnModel().getColumn(3).setCellRenderer(tableCellRenderer);
		this.userTable.getColumnModel().getColumn(4).setCellRenderer(tableCellRenderer);

	}

	private void initializeHeaderAlignment() {
		DefaultTableCellRenderer headerCellRenderer = new DefaultTableCellRenderer();
		headerCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		this.userTable.getTableHeader().setDefaultRenderer(headerCellRenderer);
	}

	private void initialLayout() {
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(10, 30, 10, 30));
		add(new JScrollPane(userTable), BorderLayout.CENTER);
	}

	private void initializeVariables() {
		this.tableModel = new UserTableModel();
		this.userTable = new JTable(tableModel);
	}

	public void setTableModel(List<User> usersList) {
		this.tableModel.setUserList(usersList);
	}

	public void updateTable() {
		this.tableModel.updateTable();
	}
}
