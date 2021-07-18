package com.capgemini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login_module_login")
public class Login {

	@Id
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "login_password", length = 25)
	private String password;

	@Column(name = "login_role", length = 25)
	private String role;

	@Column(name = "user_name", length = 30)
	private String userName;

	public Login(Integer userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}

	public Login() {

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
