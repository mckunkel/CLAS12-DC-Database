package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the dchvstatus database table.
 * 
 */
@Entity
@NamedQuery(name="Dchvstatus.findAll", query="SELECT d FROM Dchvstatus d")
public class Dchvstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DchvstatusPK id;

	private Timestamp datebegstatus;

	private byte dchvchanloc;

	private byte dchvcrateloc;

	private byte dchvslotloc;

	private String locationkey;

	private String status;

	public Dchvstatus() {
	}

	public DchvstatusPK getId() {
		return this.id;
	}

	public void setId(DchvstatusPK id) {
		this.id = id;
	}

	public Timestamp getDatebegstatus() {
		return this.datebegstatus;
	}

	public void setDatebegstatus(Timestamp datebegstatus) {
		this.datebegstatus = datebegstatus;
	}

	public byte getDchvchanloc() {
		return this.dchvchanloc;
	}

	public void setDchvchanloc(byte dchvchanloc) {
		this.dchvchanloc = dchvchanloc;
	}

	public byte getDchvcrateloc() {
		return this.dchvcrateloc;
	}

	public void setDchvcrateloc(byte dchvcrateloc) {
		this.dchvcrateloc = dchvcrateloc;
	}

	public byte getDchvslotloc() {
		return this.dchvslotloc;
	}

	public void setDchvslotloc(byte dchvslotloc) {
		this.dchvslotloc = dchvslotloc;
	}

	public String getLocationkey() {
		return this.locationkey;
	}

	public void setLocationkey(String locationkey) {
		this.locationkey = locationkey;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}