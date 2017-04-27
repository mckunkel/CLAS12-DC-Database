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
import com.IKP.database.query.AddUserQuery;
import com.IKP.database.service.AddItemFormService;

public class AddItemFormServiceImpl implements AddItemFormService {

	private AddUserQuery addUserQuery;

	public AddItemFormServiceImpl() {
		this.addUserQuery = new AddUserQuery();
	}

	public void insertUser(User user) {
		this.addUserQuery.insertUser(user);
	}

	public void insertRun(RunRange runRange) {
		this.addUserQuery.insertRun(runRange);

	}
}
