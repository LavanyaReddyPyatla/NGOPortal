package com.capgemini.dto;

public class NeedyPeopleDto {

	private int needyPersonId;
	private String needyPersonName;
	private String phone;
	private double familyIncome;
	private String email;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String city;
	private String state;
	private String pin;
	private String landmark;

	public NeedyPeopleDto() {
		super();
	}

	public NeedyPeopleDto(int needyPersonId, String needyPersonName, String phone, double familyIncome, String city,
			String state, String pin, String landmark) {
		super();
		this.needyPersonId = needyPersonId;
		this.needyPersonName = needyPersonName;
		this.phone = phone;
		this.familyIncome = familyIncome;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.landmark = landmark;
	}

	public NeedyPeopleDto(String needyPersonName, String phone, double familyIncome, String email, String password,
			String city, String state, String pin, String landmark) {
		super();
		this.needyPersonName = needyPersonName;
		this.phone = phone;
		this.familyIncome = familyIncome;
		this.email = email;
		this.password = password;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.landmark = landmark;
	}

	public NeedyPeopleDto(int needyPersonId, String needyPersonName, String phone, double familyIncome, String email,
			String password, String city, String state, String pin, String landmark) {
		super();
		this.needyPersonId = needyPersonId;
		this.needyPersonName = needyPersonName;
		this.phone = phone;
		this.familyIncome = familyIncome;
		this.email = email;
		this.password = password;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.landmark = landmark;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getNeedyPersonId() {
		return needyPersonId;
	}

	public void setNeedyPersonId(int needyPersonId) {
		this.needyPersonId = needyPersonId;
	}

	public String getNeedyPersonName() {
		return needyPersonName;
	}

	public void setNeedyPersonName(String needyPersonName) {
		this.needyPersonName = needyPersonName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getFamilyIncome() {
		return familyIncome;
	}

	public void setFamilyIncome(double familyIncome) {
		this.familyIncome = familyIncome;
	}

}
