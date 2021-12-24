
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;

import javax.swing.*;
import users.*;

@SuppressWarnings("serial")
public class ViewEnrolledStudentsPage extends JFrame{
	private InstructorHomePage userHomePage;
	private Instructor instructor;
	private JTextArea enrolledStudents;
	
	public ViewEnrolledStudentsPage(Instructor user, InstructorHomePage homePage) {
		instructor = user;
		userHomePage = homePage;
		userHomePage.setVisible(false);
		
		this.setTitle("Enrolled Students");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(300, 420);
		ImageIcon image = new ImageIcon("lau-logo.jpg");
		this.setIconImage(image.getImage());
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				userHomePage.setVisible(true);
		    }
		});
		
		enrolledStudents = new JTextArea();
        enrolledStudents.setBounds(5, 5, 290, 410);
        this.add(enrolledStudents);
        
		LinkedList<Student> students = instructor.getCourseTaught().getStudents();
		int i = 1;
		for (Student student : students)
			enrolledStudents.append(String.format("%d) %s %s %s\n\n",
					i++, student.getFirstName(), student.getLastName(), student.getEmail()));
		
		this.setVisible(true);
	}
}
