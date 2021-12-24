
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import blackBoardClasses.Course;
import blackBoardClasses.CourseList;
import users.Instructor;

@SuppressWarnings("serial")
public class TeachCoursePage extends JFrame implements ListSelectionListener{
	private JList<Course> courses;
	private Instructor instructor;
	private InstructorHomePage userHomePage;
	private JLabel instruction;
	
	public TeachCoursePage(Instructor user, InstructorHomePage homePage) {
		instructor = user;
		userHomePage = homePage;
		userHomePage.setVisible(false);
		
		this.setTitle("Teach Course ");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(330, 300);
		this.setLayout(null);
		ImageIcon image = new ImageIcon("lau-logo.jpg");
		this.setIconImage(image.getImage());
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				userHomePage.setVisible(true);
		    }  
		});	
		
		instruction = new JLabel("Select course to teach",SwingConstants.CENTER);
		instruction.setBounds(0, 15, 320, 25);
		instruction.setFont(new Font("",Font.PLAIN,14));
		this.add(instruction);
		
		DefaultListModel<Course> defaultModel = new DefaultListModel<>();
		for (Course course : CourseList.courses)
			defaultModel.addElement(course);
		courses = new JList<>(defaultModel);
		courses.setBounds(45, 50, 230, 180);
		courses.addListSelectionListener(this);
		this.add(courses);

		this.setVisible(true);
	}

	public void valueChanged(ListSelectionEvent selection) {
	    if (!selection.getValueIsAdjusting()) {
	    	Course courseTaught = courses.getSelectedValue();
	    	userHomePage.teachingCourse.setText("Course taught: " + courseTaught);
	    	userHomePage.noCourseSelected.setText("");
	    	instructor.setCourseTaught(courseTaught);
	    	this.dispose();
	    	userHomePage.setVisible(true);
	    	userHomePage.courseAction.setEnabled(false);
	    }
	}
}