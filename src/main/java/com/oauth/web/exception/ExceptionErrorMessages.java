package com.oauth.web.exception;

public enum ExceptionErrorMessages {
	INTERNAL_SERVER_ERROR("Something Went Wrong. Please Repeat This Operation Later."),
	RECORD_ALREADY_EXISTS(" Username is already exists.Try with different Username...!"), 
	RECORD_NOT_AVAILABLE("Account ID is not available in the dataBase..!"),
	USERNAME_NOT_AVAILABLE("Username is not available in the dataBase..!"),
	INVALID_ACTIVATION_KEY("Invalid user activation key");


	private String errMessage;

	ExceptionErrorMessages(String errorMessage) {
		this.errMessage = errorMessage;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

}
