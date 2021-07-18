package com.capgemini.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.dto.LoginDto;
import com.capgemini.dto.LoginResponse;
import com.capgemini.dto.LoginSuccessMessage;
import com.capgemini.exception.LoginException;
import com.capgemini.model.Login;
import com.capgemini.service.ILoginService;
import com.capgemini.util.LoginConstants;

@RestController
public class LoginRestController {

	@Autowired
	private ILoginService service;

	Logger logger = LoggerFactory.getLogger(LoginRestController.class);

	/*
	 * Controller Method for Login
	 */

	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public LoginResponse doLoginController(@RequestBody LoginDto logindto) throws LoginException {
		if (service.getAuthMap().containsValue(logindto.getUserId()))
			throw new LoginException(LoginConstants.ALREADY_LOGGED_IN);
		Login login = service.doLogin(logindto.getUserId(), logindto.getPassword());
		LoginResponse response = new LoginResponse();
		response.setToken(service.generateToken(login));
		response.setUserName(login.getUserName());
		response.setRole(login.getRole());
		response.setUserId(logindto.getUserId());
		return response;
	}

	/*
	 * Controller method for logging out
	 */

	@GetMapping(value = "logout")
	@CrossOrigin(origins = "http://localhost:4200")
	public LoginSuccessMessage logout(@RequestHeader("token-id") String token) {
		service.getAuthMap().remove(token);
		return new LoginSuccessMessage(LoginConstants.LOGGED_OUT);
	}

}
