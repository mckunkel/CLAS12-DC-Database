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

import com.IKP.database.model.EntityManagerHandler;
import com.IKP.database.model.entities.RunRange;
import com.IKP.database.model.entities.User;

public class AddItemQuery extends AbstractQuery {

	public AddItemQuery() {

	}

	public void insertUser(User user) {
		open();
		EntityManagerHandler.INSTANCE.getEntityManager().persist(user);
		EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
	}

	public void insertRun(RunRange runRange) {
		open();
		EntityManagerHandler.INSTANCE.getEntityManager().persist(runRange);
		EntityManagerHandler.INSTANCE.getEntityTransaction().commit();
	}
}
