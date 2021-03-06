package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the dchvchan_status database table.
 * 
 */
@Embeddable
public class DchvchanStatusPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int statchangeid;

	private int id;

	public DchvchanStatusPK() {
	}
	public int getStatchangeid() {
		return this.statchangeid;
	}
	public void setStatchangeid(int statchangeid) {
		this.statchangeid = statchangeid;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DchvchanStatusPK)) {
			return false;
		}
		DchvchanStatusPK castOther = (DchvchanStatusPK)other;
		return 
			(this.statchangeid == castOther.statchangeid)
			&& (this.id == castOther.id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.statchangeid;
		hash = hash * prime + this.id;
		
		return hash;
	}
}