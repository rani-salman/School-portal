package blackBoardClasses;

import java.util.ArrayList;
import java.util.LinkedList;
import users.*;

public class Course {
	private String title;
	private String courseCode;
	private int creditHours;
	private double grade;
	private Instructor instructor;
	private LinkedList<Student> students = new LinkedList<Student>();
	private ArrayList<Announcement> announcements = new ArrayList<Announcement>();
	private ArrayList<Assignment> assignments = new ArrayList<Assignment>();
	
	public Course(String title, String courseCode, int creditHours) {
		setTitle(title);
		setCourseCode(courseCode);
		setCreditHours(creditHours);
	}
	
	public Course(String courseName, double grade, int creditHours) {
		setTitle(courseName);
		setGrade(grade);
		setCreditHours(creditHours);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseNumber) {
		this.courseCode = courseNumber;
	}
	public int getCreditHours() {
		return creditHours;
	}
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	public LinkedList<Student> getStudents() {
		return students;
	}
	public void AddStudent(Student s) {
		students.add(s);
	}
	public void removeStudent(Student s) {
		for (Student student : students) 
			if (student.equals(s)) {
				students.remove(student);
				return;
			}
	}
	public ArrayList<Announcement> getAnnouncements() {
		return announcements;
	}
	public ArrayList<Assignment> getAssignments() {
		return assignments;
	}
	public void AddAssignment(Assignment A) {
		assignments.add(A);
	}
	public void AddAnnouncement(Announcement A) {
		announcements.add(A);
	}
	public String toString() {
		return String.format("%s (%s)", courseCode, title);
	}

}