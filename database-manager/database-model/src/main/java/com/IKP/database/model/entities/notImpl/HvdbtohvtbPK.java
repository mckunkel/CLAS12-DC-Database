package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the hvdbtohvtb database table.
 * 
 */
@Embeddable
public class HvdbtohvtbPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String hvdbtype;

	private byte quad;

	private byte doublet;

	private byte stbboardloc;

	public HvdbtohvtbPK() {
	}
	public String getHvdbtype() {
		return this.hvdbtype;
	}
	public void setHvdbtype(String hvdbtype) {
		this.hvdbtype = hvdbtype;
	}
	public byte getQuad() {
		return this.quad;
	}
	public void setQuad(byte quad) {
		this.quad = quad;
	}
	public byte getDoublet() {
		return this.doublet;
	}
	public void setDoublet(byte doublet) {
		this.doublet = doublet;
	}
	public byte getStbboardloc() {
		return this.stbboardloc;
	}
	public void setStbboardloc(byte stbboardloc) {
		this.stbboardloc = stbboardloc;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HvdbtohvtbPK)) {
			return false;
		}
		HvdbtohvtbPK castOther = (HvdbtohvtbPK)other;
		return 
			this.hvdbtype.equals(castOther.hvdbtype)
			&& (this.quad == castOther.quad)
			&& (this.doublet == castOther.doublet)
			&& (this.stbboardloc == castOther.stbboardloc);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.hvdbtype.hashCode();
		hash = hash * prime + ((int) this.quad);
		hash = hash * prime + ((int) this.doublet);
		hash = hash * prime + ((int) this.stbboardloc);
		
		return hash;
	}
}