package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the wiretopin database table.
 * 
 */
@Embeddable
public class WiretopinPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private byte loclayer;

	private byte locwire;

	public WiretopinPK() {
	}
	public byte getLoclayer() {
		return this.loclayer;
	}
	public void setLoclayer(byte loclayer) {
		this.loclayer = loclayer;
	}
	public byte getLocwire() {
		return this.locwire;
	}
	public void setLocwire(byte locwire) {
		this.locwire = locwire;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof WiretopinPK)) {
			return false;
		}
		WiretopinPK castOther = (WiretopinPK)other;
		return 
			(this.loclayer == castOther.loclayer)
			&& (this.locwire == castOther.locwire);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) this.loclayer);
		hash = hash * prime + ((int) this.locwire);
		
		return hash;
	}
}