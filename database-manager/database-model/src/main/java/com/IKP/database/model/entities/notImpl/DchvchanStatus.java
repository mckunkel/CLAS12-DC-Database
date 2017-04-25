package com.IKP.database.model.entities.notImpl;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the dchvchan_status database table.
 * 
 */
@Entity
@Table(name="dchvchan_status")
@NamedQuery(name="DchvchanStatus.findAll", query="SELECT d FROM DchvchanStatus d")
public class DchvchanStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DchvchanStatusPK id;

	private Timestamp datebegstatus;

	private byte dchvchanloc;

	private byte dchvcrateloc;

	private byte dchvslotloc;

	private String status;

	public DchvchanStatus() {
	}

	public DchvchanStatusPK getId() {
		return this.id;
	}

	public void setId(DchvchanStatusPK id) {
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}