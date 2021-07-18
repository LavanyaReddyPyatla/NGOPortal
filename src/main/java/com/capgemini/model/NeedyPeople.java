package com.capgemini.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class NeedyPeople {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@OneToOne
	private Address address;
	
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
