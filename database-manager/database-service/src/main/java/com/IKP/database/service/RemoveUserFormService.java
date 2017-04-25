
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

package com.IKP.database.service;

import java.util.List;

import com.IKP.database.model.entities.RunRange;
import com.IKP.database.model.entities.User;

public interface RemoveUserFormService {
	public List<User> getAllUsers();

	public void removeUser(User user);

	public List<RunRange> getAllRuns();

	public void removeRun(RunRange runRange);
}
