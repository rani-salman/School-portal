package exceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {
	private String message = "Invalid username/password";
	
	public UserNotFoundException() {
		super();
	}
	public UserNotFoundException(String message) {
		super(message);
	}
	public String getMessage() {
		return message;
	}
}
