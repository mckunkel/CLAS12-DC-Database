package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hvpINTolayer database table.
 * 
 */
@Embeddable
public class HvpINTolayerPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private byte doublethalf;

	private byte locquadpin;

	private byte hvtbpin;

	public HvpINTolayerPK() {
	}
	public byte getDoublethalf() {
		return this.doublethalf;
	}
	public void setDoublethalf(byte doublethalf) {
		this.doublethalf = doublethalf;
	}
	public byte getLocquadpin() {
		return this.locquadpin;
	}
	public void setLocquadpin(byte locquadpin) {
		this.locquadpin = locquadpin;
	}
	public byte getHvtbpin() {
		return this.hvtbpin;
	}
	public void setHvtbpin(byte hvtbpin) {
		this.hvtbpin = hvtbpin;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HvpINTolayerPK)) {
			return false;
		}
		HvpINTolayerPK castOther = (HvpINTolayerPK)other;
		return 
			(this.doublethalf == castOther.doublethalf)
			&& (this.locquadpin == castOther.locquadpin)
			&& (this.hvtbpin == castOther.hvtbpin);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) this.doublethalf);
		hash = hash * prime + ((int) this.locquadpin);
		hash = hash * prime + ((int) this.hvtbpin);
		
		return hash;
	}
}