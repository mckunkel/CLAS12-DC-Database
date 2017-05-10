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
package com.IKP.database.serviceimpl;

import com.IKP.database.model.entities.RunRange;
import com.IKP.database.model.entities.User;
import com.IKP.database.query.AddItemQuery;
import com.IKP.database.service.AddItemFormService;

public class AddItemFormServiceImpl implements AddItemFormService {

	private AddItemQuery addItemQuery;

	public AddItemFormServiceImpl() {
		this.addItemQuery = new AddItemQuery();
	}

	public void insertUser(User user) {
		this.addItemQuery.insertUser(user);
	}

	public void insertRun(RunRange runRange) {
		this.addItemQuery.insertRun(runRange);

	}
}
