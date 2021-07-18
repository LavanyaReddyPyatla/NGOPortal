package com.capgemini.dto;


public class EmployeeDto {

	

	private int employeeId;
	private String employeeName;
	private String email;
	private String phone;
	private String username;
	private String password;
	private String city;
	private String state;
	private String pin;
	private String landmark;
	private boolean status;

	public EmployeeDto() {
		super();
	}
	
	public EmployeeDto(int employeeId, String employeeName, String email, String phone, String username,
			String password, String city, String state, String pin, String landmark) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.landmark = landmark;
	}

	public EmployeeDto(String employeeName, String email, String phone, String username, String password, String city,
			String state, String pin, String landmark) {
		super();
		this.employeeName = employeeName;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.landmark = landmark;
	}
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	

}