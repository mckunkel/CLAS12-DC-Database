package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hvsubslotchansf database table.
 * 
 */
@Embeddable
public class HvsubslotchansfPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private byte chan;

	private String wiretype;

	public HvsubslotchansfPK() {
	}
	public byte getChan() {
		return this.chan;
	}
	public void setChan(byte chan) {
		this.chan = chan;
	}
	public String getWiretype() {
		return this.wiretype;
	}
	public void setWiretype(String wiretype) {
		this.wiretype = wiretype;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HvsubslotchansfPK)) {
			return false;
		}
		HvsubslotchansfPK castOther = (HvsubslotchansfPK)other;
		return 
			(this.chan == castOther.chan)
			&& this.wiretype.equals(castOther.wiretype);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) this.chan);
		hash = hash * prime + this.wiretype.hashCode();
		
		return hash;
	}
}