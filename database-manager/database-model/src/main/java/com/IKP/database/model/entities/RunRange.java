package com.IKP.database.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.IKP.database.model.UsedClass;
import com.IKP.database.model.abstraction.AbstractTimestampEntity;

/**
 * The persistent class for the runRanges database table.
 * 
 */
@Entity
@Table(name = "runRanges")
@NamedQuery(name = "RunRange.findAll", query = "SELECT r FROM RunRange r")
public class RunRange extends AbstractTimestampEntity implements UsedClass, Serializable {
	private static final long serialVersionUID = 1L;

	// @Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	// private int id;

	@Lob
	private String comment;

	private String name;

	private int runMax;

	private int runMin;

	@Transient
	private List<String> fieldList;

	public RunRange() {
		createList();
	}

	private void createList() {
		this.fieldList = new ArrayList<String>();
		fieldList.add("Name");
		fieldList.add("Run Min");
		fieldList.add("Run Max");
		// fieldList.add("Entry Created");
		// fieldList.add("Event Occurance");
		fieldList.add("Comment");

	}

	public List<String> getFieldList() {
		return fieldList;
	}

	public RunRange(String name, int runMax, int runMin, String comment) {
		this.comment = comment;
		this.name = name;
		this.runMax = runMax;
		this.runMin = runMin;
	}

	// public int getId() {
	// return this.id;
	// }
	//
	// public void setId(int id) {
	// this.id = id;
	// }

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

	public String getNamedQuery() {
		return "SELECT u FROM " + this.getClass().getSimpleName() + " u";
	}

	public UsedClass getEnityClass() {
		return this;
	}

	@Override
	public String toString() {
		return "RunRange [name=" + name + ", runMax=" + runMax + ", runMin=" + runMin + "]";
	}

}