package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sensewirerange database table.
 * 
 */
@Entity
@NamedQuery(name="Sensewirerange.findAll", query="SELECT s FROM Sensewirerange s")
public class Sensewirerange implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SensewirerangePK id;

	public Sensewirerange() {
	}

	public SensewirerangePK getId() {
		return this.id;
	}

	public void setId(SensewirerangePK id) {
		this.id = id;
	}

}