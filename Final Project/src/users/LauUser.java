package users;

import exceptions.*;

public abstract class LauUser {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	public LauUser() {}
	
	public LauUser(String firstName, String lastName, String email, String password)
			throws InvalidEmailException, InvalidPasswordException, ContainsSpaceException, NameTooShortException {
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPassword(password);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) throws ContainsSpaceException, NameTooShortException{
		firstName = firstName.trim();
		if (firstName.contains(" "))
			throw new ContainsSpaceException();
		if (firstName.length() < 2)
			throw new NameTooShortException();
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) throws ContainsSpaceException, NameTooShortException{
		lastName = lastName.trim();
		if (lastName.contains(" "))
			throw new ContainsSpaceException();
		if (lastName.length() < 2)
			throw new NameTooShortException();
		this.lastName = lastName;
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws InvalidEmailException {
		email = email.trim();
		if (email.matches("[a-z]+\\.[a-z0-9]+(@lau.edu)"))
			this.email = email;
		else
			throw new InvalidEmailException();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) throws InvalidPasswordException, ContainsSpaceException {
		password = password.trim();
		if (password.contains(" "))
			throw new ContainsSpaceException();
		if(password.length() < 8)
			throw new InvalidPasswordException();
		this.password = password;
		
	}
	public String toString() {
		return String.format("%s %s %s %s",firstName, lastName, email, password);
	}

}