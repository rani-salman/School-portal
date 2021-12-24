package users;

import blackBoardClasses.*;
import exceptions.ContainsSpaceException;
import exceptions.InvalidEmailException;
import exceptions.InvalidPasswordException;
import exceptions.NameTooShortException;

public class Instructor extends LauUser {
	private Course courseTaught;
	
	public Instructor() {
		super();
	}
	public Instructor(String firstName, String lastName,String email, String password) 
			throws InvalidEmailException, InvalidPasswordException, ContainsSpaceException, NameTooShortException{
		super(firstName, lastName, email, password);
	}
	
	public Course getCourseTaught() {
		return courseTaught;
	}
	public void setCourseTaught(Course courseTaught) {
		this.courseTaught = courseTaught;
	}
	public void viewStudents() {
		courseTaught.getStudents();
	}
	public void addAnnouncement(Announcement announcement) {
		courseTaught.AddAnnouncement(announcement);
	}
	public void addAssignment(Assignment assignment) {
		courseTaught.AddAssignment(assignment);
	}
	public String toString() {
		return String.format("Instructor %s", super.toString());
	}
	
}
