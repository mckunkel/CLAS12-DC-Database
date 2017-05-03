package com.IKP.database.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.IKP.database.model.UsedClass;
import com.IKP.database.model.abstraction.AbstractTimestampEntity;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User extends AbstractTimestampEntity implements UsedClass, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String info;

	private byte isDeleted;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	@Lob
	private String roles;

	@Transient
	private List<String> fieldList;

	public User() {
		createList();
	}

	private void createList() {
		this.fieldList = new ArrayList<String>();
		fieldList.add("Name");
		fieldList.add("Password");
		fieldList.add("Role");
		fieldList.add("Information");
		fieldList.add("IsDeleted");

	}

	public List<String> getFieldList() {
		return fieldList;
	}

	public User(String name, String password, String roles, String info, byte isDeleted) {
		this.info = info;
		this.isDeleted = isDeleted;
		this.name = name;
		this.password = password;
		this.roles = roles;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public byte getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(byte isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return this.roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getNamedQuery() {

		return "SELECT u FROM " + this.getClass().getSimpleName() + " u";
	}

	public UsedClass getEnityClass() {
		return this;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", info=" + info + ", roles=" + roles + "]";
	}

}