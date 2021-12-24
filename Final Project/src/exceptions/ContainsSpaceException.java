package exceptions;

@SuppressWarnings("serial")
public class ContainsSpaceException extends Exception {
	public ContainsSpaceException() {
		super();
	}
	public ContainsSpaceException(String message) {
		super(message);
	}
}
