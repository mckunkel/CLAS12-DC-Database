package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hvsubslotchang database table.
 * 
 */
@Entity
@NamedQuery(name="Hvsubslotchang.findAll", query="SELECT h FROM Hvsubslotchang h")
public class Hvsubslotchang implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HvsubslotchangPK id;

	private byte locchan;

	private String wiretype;

	public Hvsubslotchang() {
	}

	public HvsubslotchangPK getId() {
		return this.id;
	}

	public void setId(HvsubslotchangPK id) {
		this.id = id;
	}

	public byte getLocchan() {
		return this.locchan;
	}

	public void setLocchan(byte locchan) {
		this.locchan = locchan;
	}

	public String getWiretype() {
		return this.wiretype;
	}

	public void setWiretype(String wiretype) {
		this.wiretype = wiretype;
	}

}