package exceptions;

@SuppressWarnings("serial")
public class NameTooShortException extends Exception {
	private String message = "First/Last name must contain at least 2 characters";
	
	public NameTooShortException() {
		super();
	}
	public NameTooShortException(String message) {
		super(message);
	}
	public String getMessage() {
		return message;
	}
}
