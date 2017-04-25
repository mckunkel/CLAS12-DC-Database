package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the hvpINTolayer database table.
 * 
 */
@Entity
@NamedQuery(name="HvpINTolayer.findAll", query="SELECT h FROM HvpINTolayer h")
public class HvpINTolayer implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HvpINTolayerPK id;

	private String colorleft;

	private String colorright;

	private byte senselayerhigh;

	private byte senselayerlow;

	private String wirename;

	public HvpINTolayer() {
	}

	public HvpINTolayerPK getId() {
		return this.id;
	}

	public void setId(HvpINTolayerPK id) {
		this.id = id;
	}

	public String getColorleft() {
		return this.colorleft;
	}

	public void setColorleft(String colorleft) {
		this.colorleft = colorleft;
	}

	public String getColorright() {
		return this.colorright;
	}

	public void setColorright(String colorright) {
		this.colorright = colorright;
	}

	public byte getSenselayerhigh() {
		return this.senselayerhigh;
	}

	public void setSenselayerhigh(byte senselayerhigh) {
		this.senselayerhigh = senselayerhigh;
	}

	public byte getSenselayerlow() {
		return this.senselayerlow;
	}

	public void setSenselayerlow(byte senselayerlow) {
		this.senselayerlow = senselayerlow;
	}

	public String getWirename() {
		return this.wirename;
	}

	public void setWirename(String wirename) {
		this.wirename = wirename;
	}

}