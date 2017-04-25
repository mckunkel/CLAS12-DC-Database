package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the wiretopin database table.
 * 
 */
@Entity
@NamedQuery(name="Wiretopin.findAll", query="SELECT w FROM Wiretopin w")
public class Wiretopin implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private WiretopinPK id;

	private byte stbconnector;

	private byte stbpin;

	public Wiretopin() {
	}

	public WiretopinPK getId() {
		return this.id;
	}

	public void setId(WiretopinPK id) {
		this.id = id;
	}

	public byte getStbconnector() {
		return this.stbconnector;
	}

	public void setStbconnector(byte stbconnector) {
		this.stbconnector = stbconnector;
	}

	public byte getStbpin() {
		return this.stbpin;
	}

	public void setStbpin(byte stbpin) {
		this.stbpin = stbpin;
	}

}