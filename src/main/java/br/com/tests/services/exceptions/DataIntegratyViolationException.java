package br.com.tests.services.exceptions;

public class DataIntegratyViolationException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public DataIntegratyViolationException(String message) {
		super(message);
		
	}
}
