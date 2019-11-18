package com.heartisan.domain.user.exception;

public class UserNotFoundException extends Exception {

	public static final String ERROR_CODE = "USR-404";
    public static final String ERROR_MESSAGE = "Sorry, requested user not found.";
    
    private String code;
    private String message;
    
    public UserNotFoundException() {
    	super();
    	this.code = ERROR_CODE;
    	this.message = ERROR_MESSAGE;
    }
    
    @Override
    public String getMessage() {
        return message;
    }
    
    public String getCode() {
    	return code;
    }
}
