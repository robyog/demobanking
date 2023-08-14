package it.demo.bank.exceptions;

import lombok.Data;

@Data
public class ControllerException extends Exception {

	private int httpCode;

	public ControllerException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ControllerException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ControllerException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ControllerException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ControllerException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ControllerException(String message, int httpCode) {
		super(message);
		this.httpCode=httpCode;
		
	}

	public ControllerException(String message, int httpCode,
			Throwable cause) {
		super(message,cause);
		this.httpCode=httpCode;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
	
	public String getDeepCause() {
		return super.getCause()!=null?super.getCause().getMessage():"";
	}
}
 