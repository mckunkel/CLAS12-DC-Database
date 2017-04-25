package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the senselayerrange database table.
 * 
 */
@Entity
@NamedQuery(name="Senselayerrange.findAll", query="SELECT s FROM Senselayerrange s")
public class Senselayerrange implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SenselayerrangePK id;

	public Senselayerrange() {
	}

	public SenselayerrangePK getId() {
		return this.id;
	}

	public void setId(SenselayerrangePK id) {
		this.id = id;
	}

}