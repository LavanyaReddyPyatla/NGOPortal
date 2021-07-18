package com.capgemini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Donor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int donorId;

	@Column(name = "name")
	private String donorName;

	@Column(name = "email")
	private String donorEmail;

	
	private String donorPhone;

	@Column(name = "user_name")
	private String donorUsername;

	@Column(name = "password")
	private String donorPassword;

	@OneToOne
	private Address address;

	public Donor(String donorName, String donorEmail, String donorPhone, String donorUsername, String donorPassword,
			Address address) {
		this.donorName = donorName;
		this.donorEmail = donorEmail;
		this.donorPhone = donorPhone;
		this.donorUsername = donorUsername;
		this.donorPassword = donorPassword;
		this.address = address;
	}

	public Donor() {
	}

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public String getDonorEmail() {
		return donorEmail;
	}

	public void setDonorEmail(String donorEmail) {
		this.donorEmail = donorEmail;
	}

	public String getDonorPhone() {
		return donorPhone;
	}

	public void setDonorPhone(String donorPhone) {
		this.donorPhone = donorPhone;
	}

	public String getDonorUsername() {
		return donorUsername;
	}

	public void setDonorUsername(String donorUsername) {
		this.donorUsername = donorUsername;
	}

	public String getDonorPassword() {
		return donorPassword;
	}

	public void setDonorPassword(String donorPassword) {
		this.donorPassword = donorPassword;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
