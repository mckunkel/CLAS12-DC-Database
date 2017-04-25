package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hvcrateslot database table.
 * 
 */
@Entity
@NamedQuery(name="Hvcrateslot.findAll", query="SELECT h FROM Hvcrateslot h")
public class Hvcrateslot implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HvcrateslotPK id;

	private byte sector;

	private byte suplayer;

	private String wiretype;

	public Hvcrateslot() {
	}

	public HvcrateslotPK getId() {
		return this.id;
	}

	public void setId(HvcrateslotPK id) {
		this.id = id;
	}

	public byte getSector() {
		return this.sector;
	}

	public void setSector(byte sector) {
		this.sector = sector;
	}

	public byte getSuplayer() {
		return this.suplayer;
	}

	public void setSuplayer(byte suplayer) {
		this.suplayer = suplayer;
	}

	public String getWiretype() {
		return this.wiretype;
	}

	public void setWiretype(String wiretype) {
		this.wiretype = wiretype;
	}

}