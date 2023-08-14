package it.demo.bank.exceptions;

public class FabrickApiException extends Exception {
	private static final long serialVersionUID = 1L;
	
    public FabrickApiException(String errorMessage) {
        super(errorMessage);
    }
    
	public FabrickApiException(String errorMessage, Throwable err) {
	    super(errorMessage, err);
	}
}
