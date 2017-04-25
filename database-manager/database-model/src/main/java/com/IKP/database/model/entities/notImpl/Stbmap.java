package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the stbmap database table.
 * 
 */
@Entity
@NamedQuery(name="Stbmap.findAll", query="SELECT s FROM Stbmap s")
public class Stbmap implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StbmapPK id;

	private byte dcrbconnector;

	private byte dcrbslot;

	private byte fusecolumn;

	private byte fuserow;

	private byte hvchang;

	private byte hvchansf;

	private byte hvdbdoublet;

	private byte hvdbquad;

	private String hvdbtype;

	private byte stbboardhalf;

	public Stbmap() {
	}

	public StbmapPK getId() {
		return this.id;
	}

	public void setId(StbmapPK id) {
		this.id = id;
	}

	public byte getDcrbconnector() {
		return this.dcrbconnector;
	}

	public void setDcrbconnector(byte dcrbconnector) {
		this.dcrbconnector = dcrbconnector;
	}

	public byte getDcrbslot() {
		return this.dcrbslot;
	}

	public void setDcrbslot(byte dcrbslot) {
		this.dcrbslot = dcrbslot;
	}

	public byte getFusecolumn() {
		return this.fusecolumn;
	}

	public void setFusecolumn(byte fusecolumn) {
		this.fusecolumn = fusecolumn;
	}

	public byte getFuserow() {
		return this.fuserow;
	}

	public void setFuserow(byte fuserow) {
		this.fuserow = fuserow;
	}

	public byte getHvchang() {
		return this.hvchang;
	}

	public void setHvchang(byte hvchang) {
		this.hvchang = hvchang;
	}

	public byte getHvchansf() {
		return this.hvchansf;
	}

	public void setHvchansf(byte hvchansf) {
		this.hvchansf = hvchansf;
	}

	public byte getHvdbdoublet() {
		return this.hvdbdoublet;
	}

	public void setHvdbdoublet(byte hvdbdoublet) {
		this.hvdbdoublet = hvdbdoublet;
	}

	public byte getHvdbquad() {
		return this.hvdbquad;
	}

	public void setHvdbquad(byte hvdbquad) {
		this.hvdbquad = hvdbquad;
	}

	public String getHvdbtype() {
		return this.hvdbtype;
	}

	public void setHvdbtype(String hvdbtype) {
		this.hvdbtype = hvdbtype;
	}

	public byte getStbboardhalf() {
		return this.stbboardhalf;
	}

	public void setStbboardhalf(byte stbboardhalf) {
		this.stbboardhalf = stbboardhalf;
	}

}