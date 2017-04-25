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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public enum EntityManagerHandler {

	INSTANCE;

	private EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("com.IKP.dcDatabase-persistance-unit");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	private EntityTransaction entityTransaction = entityManager.getTransaction();

	public void open() {
		if (!entityTransaction.isActive()) {
			entityTransaction.begin();
		}
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityTransaction getEntityTransaction() {
		return entityTransaction;
	}

	public void setEntityTransaction(EntityTransaction entityTransaction) {
		this.entityTransaction = entityTransaction;
	}

	public void shutdown() {
		entityManager.close();
		entityManagerFactory.close();
	}
}
