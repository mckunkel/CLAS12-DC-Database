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

public class MainFrameQuery extends AbstractQuery {

	public MainFrameQuery() {
	}

	public List<User> getUsers() {
		open();
		Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery("SELECT u FROM User u");

		List<User> usersList = query.getResultList();
		return usersList;
	}

	public List<RunRange> getRuns() {
		open();
		Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery("SELECT u FROM RunRange u");

		List<RunRange> usersList = query.getResultList();
		return usersList;
	}

	public List<UsedClass> getRows(UsedClass usedClass) {
		open();
		Query query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery(usedClass.getNamedQuery());

		List<UsedClass> rowList = query.getResultList();
		return rowList;
	}

}
