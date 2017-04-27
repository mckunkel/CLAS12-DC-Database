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
import com.IKP.database.model.UsedClass;
import com.IKP.database.model.entities.RunRange;
import com.IKP.database.model.entities.User;

public class RemoveItemQuery extends AbstractQuery {

	UsedClass usedClass;

	public RemoveItemQuery() {

	}

	public RemoveItemQuery(UsedClass usedClass) {
		createType(usedClass);
	}

	public void createType(UsedClass usedClass) {
		this.usedClass = usedClass.getEnityClass();
	}

	public List<User> getAllUsers() {
		open();
		Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery("SELECT s FROM User s");

		List<User> usersList = query.getResultList();
		return usersList;
	}

	public List<RunRange> getAllRuns() {
		open();
		Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery("SELECT s FROM RunRange s");

		List<RunRange> runList = query.getResultList();
		return runList;
	}

	public List<UsedClass> getAllItems() {
		open();
		Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery(this.usedClass.getNamedQuery());
		List<UsedClass> aList = query.getResultList();
		return aList;
	}

	public List<UsedClass> getAllItems(UsedClass usedClass) {
		open();
		Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery(usedClass.getNamedQuery());
		List<UsedClass> aList = query.getResultList();
		return aList;
	}

	public void removeUser(User user) {
		open();
		EntityManagerHandler.INSTANCE.getEntityManager().remove(user);
		EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
	}

	public void removeRun(RunRange runRange) {
		open();
		EntityManagerHandler.INSTANCE.getEntityManager().remove(runRange);
		EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
	}

	public void removeItem(UsedClass usedClass) {
		open();
		EntityManagerHandler.INSTANCE.getEntityManager().remove(usedClass.getEnityClass());
		EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
	}

}
