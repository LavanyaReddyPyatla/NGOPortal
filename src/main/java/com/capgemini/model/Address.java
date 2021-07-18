package com.capgemini.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressId;
	private String city;
	private String state;
	private String pin;
	private String landmark;

	public Address(int addressId, String city, String state, String pin, String landmark) {
		this.addressId = addressId;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.landmark = landmark;
	}

	public Address(String city, String state, String pin, String landmark) {
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.landmark = landmark;
	}

	public Address() {
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
}
