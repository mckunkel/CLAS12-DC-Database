package com.IKP.database.model.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.IKP.database.model.abstraction.AbstractTimestampEntity;

/**
 * The persistent class for the runRanges database table.
 * 
 */
@Entity
@Table(name = "runRanges")
@NamedQuery(name = "RunRange.findAll", query = "SELECT r FROM RunRange r")
public class RunRange extends AbstractTimestampEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String comment;

	private String name;

	private int runMax;

	private int runMin;

	public RunRange() {
	}

	public RunRange(String name, int runMax, int runMin, String comment) {
		this.comment = comment;
		this.name = name;
		this.runMax = runMax;
		this.runMin = runMin;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRunMax() {
		return this.runMax;
	}

	public void setRunMax(int runMax) {
		this.runMax = runMax;
	}

	public int getRunMin() {
		return this.runMin;
	}

	public void setRunMin(int runMin) {
		this.runMin = runMin;
	}

}