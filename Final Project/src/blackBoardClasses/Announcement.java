package blackBoardClasses;

import java.time.LocalTime;

public class Announcement implements Comparable<Announcement>{
	private String title;
	private String body;
	private String courseCode;
	private LocalTime timeOfPublication;
	
	public Announcement(String title, String body, String courseCode, LocalTime currTime) {
		setTitle(title);
		setBody(body);
		setCourseCode(courseCode);
		setTimeOfPublication(currTime);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public LocalTime getTimeOfPublication() {
		return timeOfPublication;
	}
	public void setTimeOfPublication(LocalTime timeOfPublication) {
		this.timeOfPublication = timeOfPublication;
	}

	public String toString() {
		return String.format("%s: %s\n\n%s\n\nTime of publication: %s", courseCode, title, body, 
				timeOfPublication.toString().substring(0, 8));
	}

	public int compareTo(Announcement announcement) {
		return this.getTimeOfPublication().compareTo(announcement.getTimeOfPublication());
	}
}