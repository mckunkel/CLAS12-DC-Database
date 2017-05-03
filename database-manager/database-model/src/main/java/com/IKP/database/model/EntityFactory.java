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
package com.IKP.database.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import com.IKP.database.model.entities.RunRange;
import com.IKP.database.model.entities.User;
import com.IKP.utils.StringConstants;

public class EntityFactory {

	public static UsedClass getEntity(UsedClass usedClass) {

		if (usedClass instanceof User)
			return new User();
		else if (usedClass instanceof RunRange)
			return new RunRange();
		return null;

	}

	public static List getEntityList(UsedClass usedClass) {

		if (usedClass instanceof User)
			return new ArrayList<User>();
		else if (usedClass instanceof RunRange)
			return new ArrayList<RunRange>();
		return null;

	}

	public static String[] getEntityColNames(UsedClass usedClass) {

		if (usedClass instanceof User) {
			String[] colNames = { "Name", "Password", "Role", "Information", "isDeleted" };
			return colNames;
		} else if (usedClass instanceof RunRange) {
			String[] colNames = { "Name", "Run Min", "Run Max", "Comment", "Created", "Updated" };
			return colNames;
		}

		return null;

	}

	public static Object getValueAt(int rowIndex, int columnIndex, UsedClass usedClass) {
		if (usedClass instanceof User) {

			switch (columnIndex) {
			case 0:
				return ((User) usedClass).getName();
			case 1:
				return ((User) usedClass).getPassword();
			case 2:
				return ((User) usedClass).getRoles();
			case 3:
				return ((User) usedClass).getInfo();
			case 4:
				return ((User) usedClass).getIsDeleted();
			default:
				return null;
			}
		} else if (usedClass instanceof RunRange) {

			switch (columnIndex) {
			case 0:
				return ((RunRange) usedClass).getName();
			case 1:
				return ((RunRange) usedClass).getRunMin();
			case 2:
				return ((RunRange) usedClass).getRunMax();
			case 3:
				return ((RunRange) usedClass).getComment();
			case 4:
				return ((RunRange) usedClass).getCreated();
			case 5:
				return ((RunRange) usedClass).getLastActionTime();
			default:
				return null;
			}
		}

		return null;

	}

	public static JLabel getJLabel(UsedClass usedClass) {
		if (usedClass instanceof User) {
			return new JLabel(StringConstants.USER_FORM_NAME);
		} else if (usedClass instanceof RunRange) {
			return new JLabel(StringConstants.RUN_FORM_NAME);
		}

		return null;
	}

	public static String getTitleBorder(UsedClass usedClass) {
		if (usedClass instanceof User) {
			return StringConstants.USER_REMOVE_FORM_SUBTITLE;
		} else if (usedClass instanceof RunRange) {
			return StringConstants.RUN_REMOVE_FORM_SUBTITLE;
		}

		return null;
	}
}
