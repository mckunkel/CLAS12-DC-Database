package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hvsubslotchang database table.
 * 
 */
@Embeddable
public class HvsubslotchangPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private byte chan;

	private byte subslot;

	public HvsubslotchangPK() {
	}
	public byte getChan() {
		return this.chan;
	}
	public void setChan(byte chan) {
		this.chan = chan;
	}
	public byte getSubslot() {
		return this.subslot;
	}
	public void setSubslot(byte subslot) {
		this.subslot = subslot;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HvsubslotchangPK)) {
			return false;
		}
		HvsubslotchangPK castOther = (HvsubslotchangPK)other;
		return 
			(this.chan == castOther.chan)
			&& (this.subslot == castOther.subslot);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) this.chan);
		hash = hash * prime + ((int) this.subslot);
		
		return hash;
	}
}