package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the senselayerrange database table.
 * 
 */
@Embeddable
public class SenselayerrangePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private byte senselow;

	private byte sensehigh;

	private byte senselayer;

	public SenselayerrangePK() {
	}
	public byte getSenselow() {
		return this.senselow;
	}
	public void setSenselow(byte senselow) {
		this.senselow = senselow;
	}
	public byte getSensehigh() {
		return this.sensehigh;
	}
	public void setSensehigh(byte sensehigh) {
		this.sensehigh = sensehigh;
	}
	public byte getSenselayer() {
		return this.senselayer;
	}
	public void setSenselayer(byte senselayer) {
		this.senselayer = senselayer;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SenselayerrangePK)) {
			return false;
		}
		SenselayerrangePK castOther = (SenselayerrangePK)other;
		return 
			(this.senselow == castOther.senselow)
			&& (this.sensehigh == castOther.sensehigh)
			&& (this.senselayer == castOther.senselayer);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) this.senselow);
		hash = hash * prime + ((int) this.sensehigh);
		hash = hash * prime + ((int) this.senselayer);
		
		return hash;
	}
}