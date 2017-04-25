package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the stbmap database table.
 * 
 */
@Embeddable
public class StbmapPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private byte locsuplayer;

	private byte stbboardloc;

	private byte stbconnector;

	public StbmapPK() {
	}
	public byte getLocsuplayer() {
		return this.locsuplayer;
	}
	public void setLocsuplayer(byte locsuplayer) {
		this.locsuplayer = locsuplayer;
	}
	public byte getStbboardloc() {
		return this.stbboardloc;
	}
	public void setStbboardloc(byte stbboardloc) {
		this.stbboardloc = stbboardloc;
	}
	public byte getStbconnector() {
		return this.stbconnector;
	}
	public void setStbconnector(byte stbconnector) {
		this.stbconnector = stbconnector;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof StbmapPK)) {
			return false;
		}
		StbmapPK castOther = (StbmapPK)other;
		return 
			(this.locsuplayer == castOther.locsuplayer)
			&& (this.stbboardloc == castOther.stbboardloc)
			&& (this.stbconnector == castOther.stbconnector);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) this.locsuplayer);
		hash = hash * prime + ((int) this.stbboardloc);
		hash = hash * prime + ((int) this.stbconnector);
		
		return hash;
	}
}