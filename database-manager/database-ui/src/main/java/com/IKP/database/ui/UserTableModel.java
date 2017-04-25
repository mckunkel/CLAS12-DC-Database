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

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.IKP.database.model.entities.User;
import com.IKP.utils.NumberConstants;

public class UserTableModel extends AbstractTableModel implements TableModel {

	private List<User> userList;
	private String[] colNames = { "Name", "Password", "Role", "Information", "isDeleted" };

	public UserTableModel() {
		this.userList = new ArrayList<User>();
	}

	public int getRowCount() {
		return this.userList.size();
	}

	public int getColumnCount() {
		return NumberConstants.NUM_OF_COLUMNS;
	}

	public String getColumnName(int column) {
		return this.colNames[column];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {

		User user = this.userList.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return user.getName();
		case 1:
			return user.getPassword();
		case 2:
			return user.getRoles();
		case 3:
			return user.getInfo();
		case 4:
			return user.getIsDeleted();
		default:
			return null;
		}
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public void updateTable() {
		fireTableDataChanged();
	}

}
