package exceptions;

@SuppressWarnings("serial")
public class InvalidPasswordException extends Exception {
	private String message = "Password must contain at least 8 characters";
			
	public InvalidPasswordException() {
		super();
	}
	public InvalidPasswordException(String message) {
		super(message);
	}
	public String getMessage() {
		return message;
	}
}
