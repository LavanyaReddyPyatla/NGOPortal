package com.capgemini.util;

public class NgoPortalConstants {
	public static final String REGISTRATION_SUCCESSFUL = " Registration Successful";

	public static final String INVALID_NAME = "Invalid Name, Name shouldn't contain numbers or special characters";
	public static final String INVALID_EMAIL = "Invalid Email, please \"give abc@xyz.mn\" format";
	public static final String INVALID_PHONE = "Invalid Phone Number, please enter only 10 digits";
	public static final String INVALID_USERNAME = "Invalid Username";
	public static final String INVALID_PASSWORD = "Invalid Password";

	public static final String INVALID_CITY = "Invalid City";
	public static final String INVALID_STATE = "Invalid State";
	public static final String INVALID_PIN = "Invalid Pin";
	public static final String INVALID_LANDMARK = "Invalid Landmark";

	public static final String NAME_PATTERN = "^[\\p{L} .'-]+$";
	public static final String EMAIL_PATTERN = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
	public static final String PHONE_PATTERN = "\\d{10}";

	public static final String USERNAME_PATTERN = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";

	public static final String PASSWORD_PATTERN = "[a-zA-Z0-9]{8,24}$";

	public static final String CITY_PATTERN = "^[a-zA-Z]+(?:[\s-][a-zA-Z]+)*$";
	public static final String STATE_PATTERN = "[a-zA-Z]+(?:[\s-][a-zA-Z]+)*$";
	public static final String PIN_PATTERN = "^[1-9]{1}[0-9]{2}[0-9]{3}$";
	public static final String LANDMARK_PATTERN = "^.{5,50}$";
	public static final String DONOR_EXISTS = "Donor already Registered";

	public static final String INVALID_DETAILS = "Invalid Details";

	public static final String NEEDYPEOPLE_NOT_FOUND = "Needy People not Found";

	public static final String EMPLOYEE_NOT_FOUND = "Employee doesn't exist in records";
	
	public static final String REQUEST_NOT_FOUND = "Request doesn't exist in records";


	public static final String NEEDY_PERSON_NOT_FOUND = "Needy People not Found";

	public static final String ADDRESS_NOT_FOUND = "Address Not Found";

	public static final String NEEDY_PERSON_REGISTERED = "Already Registered";

	public static final String EMPLOYEE_ADDED = "Employee Added Successfully";

	public static final String EMPLOYEE_UPDATED = "Employee Updated Successfully";

	public static final String EMPLOYEE_REMOVED = "Employee Removed Successfully";

	public static final String EMPLOYEE_EXISTS = "Employee Already Exists";

	public static final String NO_REQUESTS = "No Requests Currently";

	public static final String AMOUNT_ADDED = "Amount Added Successfully";

	public static final String INVALID_AMOUNT = "Amount should be minimum 500 and less than ";
	
	public static final String STATUS_UPDATED = "Status had been updated ";

	public static final String REQUEST_SUCCESSFUL = "Request has been made";

	public static final String EMPLOYEE = "employee";
	
	public static final String DONOR = "donor";
	
	public static final String NEEDY = "needy";

	public static final Double ZERO = 0.00;
	
	

	


}
