package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the layer database table.
 * 
 */
@Entity
@NamedQuery(name="Layer.findAll", query="SELECT l FROM Layer l")
public class Layer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private byte layer;

	private byte loclayer;

	private byte locsuplayer;

	private byte region;

	private byte suplayer;

	public Layer() {
	}

	public byte getLayer() {
		return this.layer;
	}

	public void setLayer(byte layer) {
		this.layer = layer;
	}

	public byte getLoclayer() {
		return this.loclayer;
	}

	public void setLoclayer(byte loclayer) {
		this.loclayer = loclayer;
	}

	public byte getLocsuplayer() {
		return this.locsuplayer;
	}

	public void setLocsuplayer(byte locsuplayer) {
		this.locsuplayer = locsuplayer;
	}

	public byte getRegion() {
		return this.region;
	}

	public void setRegion(byte region) {
		this.region = region;
	}

	public byte getSuplayer() {
		return this.suplayer;
	}

	public void setSuplayer(byte suplayer) {
		this.suplayer = suplayer;
	}

}