
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.*;
import blackBoardClasses.Course;
import users.Student;

@SuppressWarnings("serial")
public class StudentHomePage extends BlackBoardHomePage{
	private JButton goToGpaCalculator, gotoTODOList;
	protected JLabel registeredCoursesLabel, creditsLimitReached;
	private Student student;
	
	public StudentHomePage(Student student) {
		super(student);
		setStudent(student);
		announcementAction.setText("View annoucements");
		assignmentAction.setText("View assignments");
		courseAction.setText("Add/Drop courses");
		
		ImageIcon gpaCalcImage = new ImageIcon("Gpa_Calculator_Logo.png");
		goToGpaCalculator = new JButton(gpaCalcImage);
		goToGpaCalculator.setBounds(0, 0, 50, 50);
		goToGpaCalculator.addActionListener(this);
		this.add(goToGpaCalculator);
		
		ImageIcon todoListImage = new ImageIcon("todoListImage.png");
		gotoTODOList = new JButton(todoListImage);
		gotoTODOList.setBounds(405, 0, 50, 50);
		gotoTODOList.addActionListener(this);
		this.add(gotoTODOList);
		
		creditsLimitReached = new JLabel("", SwingConstants.CENTER);
		creditsLimitReached.setForeground(Color.red);
		creditsLimitReached.setBounds(5, 120, 450, 30);
		this.add(creditsLimitReached);
		
		String registeredCourses = "Registered courses: ";
		if (student.getRegisteredCourses().size() == 0)
			registeredCourses += "__";
		for (Course course : student.getRegisteredCourses()) 
			registeredCourses += course.getCourseCode() + "  ";
		registeredCoursesLabel = new JLabel(registeredCourses, SwingConstants.CENTER);
		registeredCoursesLabel.setBounds(0, 220, 450, 25);
		this.add(registeredCoursesLabel);
	}

	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public void actionPerformed(ActionEvent click) {
		if (click.getSource() == assignmentAction) {
			new ViewAssignmentsPage(student, this);
			creditsLimitReached.setText("");
		}
		if (click.getSource() == gotoTODOList) {
			new AssignmentToDoList(student, this);
			creditsLimitReached.setText("");
		}
		if (click.getSource() == announcementAction) { 
			new ViewAnnouncementsPage(student, this);
			creditsLimitReached.setText("");
		}
		if (click.getSource() == courseAction) {
			new RegistrationPage(student, this);
			creditsLimitReached.setText("");
		}
		if (click.getSource() == goToGpaCalculator) {
			new GPACalculatorPage(student, this);
			creditsLimitReached.setText("");
		}
	}
}
