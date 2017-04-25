package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the dchvboard_status database table.
 * 
 */
@Entity
@Table(name="dchvboard_status")
@NamedQuery(name="DchvboardStatus.findAll", query="SELECT d FROM DchvboardStatus d")
public class DchvboardStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DchvboardStatusPK id;

	private Timestamp datebegstatus;

	private byte dchvchanloc;

	private byte dchvcrateloc;

	private byte dchvslotloc;

	private String locationkey;

	private String status;

	public DchvboardStatus() {
	}

	public DchvboardStatusPK getId() {
		return this.id;
	}

	public void setId(DchvboardStatusPK id) {
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