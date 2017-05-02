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
import com.IKP.database.query.MainFrameQuery;
import com.IKP.database.service.MainFrameService;

public class MainFrameServiceImpl implements MainFrameService {
	private MainFrameQuery mainFrameQuery;

	public MainFrameServiceImpl() {
		this.mainFrameQuery = new MainFrameQuery();
	}

	public List<User> getAllUsers() {
		return this.mainFrameQuery.getUsers();
	}

	public List<RunRange> getAllRuns() {
		return this.mainFrameQuery.getRuns();
	}

	public List<UsedClass> getAllRows(UsedClass usedClass) {
		return this.mainFrameQuery.getRows(usedClass);
	}

	public void shutdown() {
		this.mainFrameQuery.shutdown();
	}

}
