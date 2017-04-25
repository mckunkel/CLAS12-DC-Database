package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hvcrateslot database table.
 * 
 */
@Embeddable
public class HvcrateslotPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private byte hvcrate;

	private byte hvslot;

	private byte hvsubslot;

	public HvcrateslotPK() {
	}
	public byte getHvcrate() {
		return this.hvcrate;
	}
	public void setHvcrate(byte hvcrate) {
		this.hvcrate = hvcrate;
	}
	public byte getHvslot() {
		return this.hvslot;
	}
	public void setHvslot(byte hvslot) {
		this.hvslot = hvslot;
	}
	public byte getHvsubslot() {
		return this.hvsubslot;
	}
	public void setHvsubslot(byte hvsubslot) {
		this.hvsubslot = hvsubslot;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HvcrateslotPK)) {
			return false;
		}
		HvcrateslotPK castOther = (HvcrateslotPK)other;
		return 
			(this.hvcrate == castOther.hvcrate)
			&& (this.hvslot == castOther.hvslot)
			&& (this.hvsubslot == castOther.hvsubslot);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) this.hvcrate);
		hash = hash * prime + ((int) this.hvslot);
		hash = hash * prime + ((int) this.hvsubslot);
		
		return hash;
	}
}