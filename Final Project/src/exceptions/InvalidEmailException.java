package exceptions;

@SuppressWarnings("serial")
public class InvalidEmailException extends Exception {
	private String message = "The email is not a valid LAU email";
	
	public InvalidEmailException() {
		super();
	}
	public InvalidEmailException(String message) {
		super(message);
	}
	public String getMessage() {
		return message;
	}
}
