package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the sensewirerange database table.
 * 
 */
@Embeddable
public class SensewirerangePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private byte sensewirelow;

	private byte sensewirehigh;

	private byte sensewire;

	public SensewirerangePK() {
	}
	public byte getSensewirelow() {
		return this.sensewirelow;
	}
	public void setSensewirelow(byte sensewirelow) {
		this.sensewirelow = sensewirelow;
	}
	public byte getSensewirehigh() {
		return this.sensewirehigh;
	}
	public void setSensewirehigh(byte sensewirehigh) {
		this.sensewirehigh = sensewirehigh;
	}
	public byte getSensewire() {
		return this.sensewire;
	}
	public void setSensewire(byte sensewire) {
		this.sensewire = sensewire;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SensewirerangePK)) {
			return false;
		}
		SensewirerangePK castOther = (SensewirerangePK)other;
		return 
			(this.sensewirelow == castOther.sensewirelow)
			&& (this.sensewirehigh == castOther.sensewirehigh)
			&& (this.sensewire == castOther.sensewire);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) this.sensewirelow);
		hash = hash * prime + ((int) this.sensewirehigh);
		hash = hash * prime + ((int) this.sensewire);
		
		return hash;
	}
}