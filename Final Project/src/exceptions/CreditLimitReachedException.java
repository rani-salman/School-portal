package exceptions;

@SuppressWarnings("serial")
public class CreditLimitReachedException extends Exception{
	private String message = "Credits limit reached (cannot take more than 12 credits)";
	
	public CreditLimitReachedException() {
		super();
	}
	public CreditLimitReachedException(String message) {
		super(message);
	}
	public String getMessage() {
		return message;
	}
}
