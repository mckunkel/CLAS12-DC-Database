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

import java.util.List;

import com.IKP.database.model.UsedClass;
import com.IKP.database.model.entities.RunRange;
import com.IKP.database.model.entities.User;
import com.IKP.database.query.RemoveItemQuery;
import com.IKP.database.service.RemoveItemFormService;

public class RemoveItemFormServiceImpl implements RemoveItemFormService {

	private RemoveItemQuery removeItemQuery;

	public RemoveItemFormServiceImpl() {
		this.removeItemQuery = new RemoveItemQuery();
	}

	public List<User> getAllUsers() {
		return this.removeItemQuery.getAllUsers();
	}

	public void removeUser(User user) {
		this.removeItemQuery.removeUser(user);
	}

	public List<RunRange> getAllRuns() {
		return this.removeItemQuery.getAllRuns();

	}

	public void removeRun(RunRange runRange) {
		this.removeItemQuery.removeRun(runRange);
	}

	public List<UsedClass> getAllItems() {
		return this.removeItemQuery.getAllItems();

	}

	public void removeItem(UsedClass usedClass) {
		this.removeItemQuery.removeItem(usedClass.getEnityClass());
	}

}
