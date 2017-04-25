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

import com.IKP.database.model.entities.RunRange;

public class RunTableModel extends AbstractTableModel implements TableModel {

	private List<RunRange> alist;
	private String[] colNames = { "Name", "Run Min", "Run Max", "Comment", "Created", "Updated" };

	public RunTableModel() {
		this.alist = new ArrayList<RunRange>();
	}

	public int getRowCount() {
		return this.alist.size();
	}

	public int getColumnCount() {
		return colNames.length;
	}

	public String getColumnName(int column) {
		return this.colNames[column];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {

		RunRange runRange = this.alist.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return runRange.getName();
		case 1:
			return runRange.getRunMin();
		case 2:
			return runRange.getRunMax();
		case 3:
			return runRange.getComment();
		case 4:
			return runRange.getCreated();
		case 5:
			return runRange.getLastActionTime();
		default:
			return null;
		}
	}

	public void setList(List<RunRange> aList) {
		this.alist = aList;
	}

	public void updateTable() {
		fireTableDataChanged();
	}

}
