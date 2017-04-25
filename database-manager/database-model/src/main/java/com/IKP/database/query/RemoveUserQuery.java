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
package com.IKP.database.query;

import java.util.List;

import javax.persistence.Query;

import com.IKP.database.model.EntityManagerHandler;
import com.IKP.database.model.entities.RunRange;
import com.IKP.database.model.entities.User;

public class RemoveUserQuery extends AbstractQuery {

	public RemoveUserQuery() {

	}

	public List<User> getAllUsers() {
		open();
		Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery("SELECT s FROM User s");

		List<User> usersList = query.getResultList();
		return usersList;
	}

	public void removeUser(User user) {
		open();
		EntityManagerHandler.INSTANCE.getEntityManager().remove(user);
		EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
	}

	public List<RunRange> getAllRuns() {
		open();
		Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery("SELECT s FROM RunRange s");

		List<RunRange> runList = query.getResultList();
		return runList;
	}

	public void removeRun(RunRange runRange) {
		open();
		EntityManagerHandler.INSTANCE.getEntityManager().remove(runRange);
		EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
	}

}
