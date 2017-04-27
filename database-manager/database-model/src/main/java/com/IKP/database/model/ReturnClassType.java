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

import com.IKP.database.model.entities.RunRange;
import com.IKP.database.model.entities.User;

public class ReturnClassType {

	private ReturnClassType() {
	}

	public UsedClass returnClassType(UsedClass usedClass) {
		if (usedClass.getClass().getSimpleName().equalsIgnoreCase("RunRange")) {
			usedClass = new RunRange();
		}

		if (usedClass.getClass().getSimpleName().equalsIgnoreCase("User")) {
			usedClass = new User();
		}
		return usedClass;
	}

}
