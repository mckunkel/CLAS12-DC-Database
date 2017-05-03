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

import com.IKP.database.model.EntityFactory;
import com.IKP.database.model.UsedClass;

public class TablePanel extends JPanel {

	private JTable itemTable;
	private ItemTable tableModel;

	private UsedClass usedClass;

	public TablePanel(UsedClass usedClass) {
		this.usedClass = usedClass;
		initializeVariables();
		initialLayout();
		initializeTableAlignment();
		initializeHeaderAlignment();
	}

	private void initializeTableAlignment() {

		DefaultTableCellRenderer tableCellRenderer = new DefaultTableCellRenderer();
		tableCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		for (int i = 0; i < EntityFactory.getEntityColNames(usedClass).length; i++) {
			this.itemTable.getColumnModel().getColumn(i).setCellRenderer(tableCellRenderer);
		}
	}

	private void initializeHeaderAlignment() {
		DefaultTableCellRenderer headerCellRenderer = new DefaultTableCellRenderer();
		headerCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		this.itemTable.getTableHeader().setDefaultRenderer(headerCellRenderer);
	}

	private void initialLayout() {
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(10, 30, 10, 30));
		add(new JScrollPane(itemTable), BorderLayout.CENTER);
	}

	private void initializeVariables() {
		this.tableModel = new ItemTable(this.usedClass);
		this.itemTable = new JTable(tableModel);
	}

	public void setTableModel(List<UsedClass> usersList) {
		this.tableModel.setItemList(usersList);
	}

	public void updateTable() {
		this.tableModel.updateTable();
	}

}
