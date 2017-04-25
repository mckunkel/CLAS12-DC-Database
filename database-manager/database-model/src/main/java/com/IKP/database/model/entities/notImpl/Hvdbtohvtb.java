package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hvdbtohvtb database table.
 * 
 */
@Entity
@NamedQuery(name="Hvdbtohvtb.findAll", query="SELECT h FROM Hvdbtohvtb h")
public class Hvdbtohvtb implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HvdbtohvtbPK id;

	private byte hvlocchang;

	private byte hvlocchansf;

	private byte stbboardhalf;

	private byte wireoffset;

	public Hvdbtohvtb() {
	}

	public HvdbtohvtbPK getId() {
		return this.id;
	}

	public void setId(HvdbtohvtbPK id) {
		this.id = id;
	}

	public byte getHvlocchang() {
		return this.hvlocchang;
	}

	public void setHvlocchang(byte hvlocchang) {
		this.hvlocchang = hvlocchang;
	}

	public byte getHvlocchansf() {
		return this.hvlocchansf;
	}

	public void setHvlocchansf(byte hvlocchansf) {
		this.hvlocchansf = hvlocchansf;
	}

	public byte getStbboardhalf() {
		return this.stbboardhalf;
	}

	public void setStbboardhalf(byte stbboardhalf) {
		this.stbboardhalf = stbboardhalf;
	}

	public byte getWireoffset() {
		return this.wireoffset;
	}

	public void setWireoffset(byte wireoffset) {
		this.wireoffset = wireoffset;
	}

}