package com.IKP.database.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.IKP.database.model.abstraction.AbstractTimestampEntity;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User extends AbstractTimestampEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String info;

	// @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
	private byte isDeleted;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	@Lob
	private String roles;

	public User() {
	}

	public User(String name, String password, String roles, String info, byte isDeleted) {
		// this.created = created;
		this.info = info;
		this.isDeleted = isDeleted;
		// this.lastActionTime = lastActionTime;
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

	@Override
	public String toString() {
		return "User [name=" + name + ", info=" + info + ", roles=" + roles + "]";
	}

}