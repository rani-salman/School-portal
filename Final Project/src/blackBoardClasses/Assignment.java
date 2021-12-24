package blackBoardClasses;

public class Assignment {
	private String title;
	private String instructions;
	private String courseCode;
	private String dueDate;
	
	public Assignment(String title, String instructions, String dueDate, String courseCode) {
		setTitle(title);
		setInstructions(instructions);
		setDueDate(dueDate);
		setCourseCode(courseCode);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String duedate) {
		dueDate = duedate;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	public String toString() {
		return String.format("%s: %s\n\n%s\n\nDue date: %s", 
			courseCode, title, instructions, 
		dueDate.equals("") ? "no due date for this assignment" : dueDate);
	}
}