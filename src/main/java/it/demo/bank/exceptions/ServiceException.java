package it.demo.bank.exceptions;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	
    public ServiceException(String errorMessage) {
        super(errorMessage);
    }
    
	public ServiceException(String errorMessage, Throwable err) {
	    super(errorMessage, err);
	}
}
