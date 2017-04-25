package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hvsubslotchansf database table.
 * 
 */
@Entity
@NamedQuery(name="Hvsubslotchansf.findAll", query="SELECT h FROM Hvsubslotchansf h")
public class Hvsubslotchansf implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HvsubslotchansfPK id;

	private byte locchan;

	private byte subslot;

	public Hvsubslotchansf() {
	}

	public HvsubslotchansfPK getId() {
		return this.id;
	}

	public void setId(HvsubslotchansfPK id) {
		this.id = id;
	}

	public byte getLocchan() {
		return this.locchan;
	}

	public void setLocchan(byte locchan) {
		this.locchan = locchan;
	}

	public byte getSubslot() {
		return this.subslot;
	}

	public void setSubslot(byte subslot) {
		this.subslot = subslot;
	}

}