package exceptions;

@SuppressWarnings("serial")
public class UserAlreadySignedUpException extends Exception {
	private String message = "This email is being used for another account";
	
	public UserAlreadySignedUpException() {
		super();
	}
	public UserAlreadySignedUpException(String message) {
		super(message);
	}
	public String getMessage() {
		return message;
	}
	
}
