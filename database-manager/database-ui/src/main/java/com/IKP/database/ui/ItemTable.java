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

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.IKP.database.model.EntityFactory;
import com.IKP.database.model.UsedClass;

public class ItemTable extends AbstractTableModel implements TableModel {

	private List<UsedClass> rowList;
	private UsedClass usedClass;

	@SuppressWarnings("unchecked")

	public ItemTable(UsedClass usedClass) {
		this.usedClass = usedClass;
		this.rowList = EntityFactory.getEntityList(usedClass);
	}

	public int getRowCount() {
		return this.rowList.size();
	}

	public int getColumnCount() {
		return EntityFactory.getEntityColNames(usedClass).length;
	}

	public String getColumnName(int column) {
		return EntityFactory.getEntityColNames(usedClass)[column];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return EntityFactory.getValueAt(rowIndex, columnIndex, this.rowList.get(rowIndex));
	}

	public void setItemList(List<UsedClass> rows) {
		this.rowList = rows;
	}

	public void updateTable() {
		fireTableDataChanged();
	}

}
