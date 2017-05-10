package ui;

public class UiException extends RuntimeException {
	
	public UiException(String message) {
		super(message);
	}
	
	public UiException(String message, Exception original) {
		super(message, original);
	}
	
}
