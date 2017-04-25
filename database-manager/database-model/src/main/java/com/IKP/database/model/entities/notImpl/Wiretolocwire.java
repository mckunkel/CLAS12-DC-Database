package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the wiretolocwire database table.
 * 
 */
@Entity
@NamedQuery(name="Wiretolocwire.findAll", query="SELECT w FROM Wiretolocwire w")
public class Wiretolocwire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte wire;

	private byte locwire;

	private byte stbboardhalf;

	private byte stbboardloc;

	public Wiretolocwire() {
	}

	public byte getWire() {
		return this.wire;
	}

	public void setWire(byte wire) {
		this.wire = wire;
	}

	public byte getLocwire() {
		return this.locwire;
	}

	public void setLocwire(byte locwire) {
		this.locwire = locwire;
	}

	public byte getStbboardhalf() {
		return this.stbboardhalf;
	}

	public void setStbboardhalf(byte stbboardhalf) {
		this.stbboardhalf = stbboardhalf;
	}

	public byte getStbboardloc() {
		return this.stbboardloc;
	}

	public void setStbboardloc(byte stbboardloc) {
		this.stbboardloc = stbboardloc;
	}

}