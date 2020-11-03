package com.project.model;

public class Profiles {

	private int id;
	private String picUrl;
	private String status;
	private String bio;
	private String interests;

	public Profiles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profiles(String picUrl, String status, String bio, String interests) {
		super();
		this.picUrl = picUrl;
		this.status = status;
		this.bio = bio;
		this.interests = interests;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	@Override
	public String toString() {
		return "Profiles [id=" + id + ", picUrl=" + picUrl + ", status=" + status + ", bio=" + bio + ", interests="
				+ interests + "]";
	}
}
