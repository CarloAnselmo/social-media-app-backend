package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "verif")
public class Verify {

	@Id
	private int code;

	@Column(nullable = false, unique = true)
	private int userId;

	@Column(name="used")
	private boolean used;

	public Verify(int code, int userId, boolean used) {
		super();
		this.code = code;
		this.userId = userId;
		this.used = used;
	}

	public Verify() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

}
