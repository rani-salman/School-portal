
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import blackBoardClasses.Assignment;
import users.Instructor;

@SuppressWarnings("serial")
public class CreateAssignmentPage extends JFrame implements ActionListener {
	private Instructor instructor;
	private InstructorHomePage userHomePage;
	private JLabel title, instructions, dueDateLabel;
	private JTextField assignmentTitleInput;
	private JTextArea assignmentInstructionsInput;
	private JButton pickDateButton, publishButton; 
	private String dueDate = "";
	
	public CreateAssignmentPage(Instructor instructor, InstructorHomePage homePage) {
		this.instructor = instructor;
		userHomePage = homePage;
		userHomePage.setVisible(false);
		
		this.setTitle("Add assignment page");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(555, 500);
		this.setLayout(null);
		ImageIcon image = new ImageIcon("lau-logo.jpg");
		this.setIconImage(image.getImage());
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				userHomePage.setVisible(true);
		    }  
		});
		
		this.setVisible(true);
		
		title = new JLabel("Title:");
		title.setBounds(75, 5, 40, 30);
		assignmentTitleInput = new JTextField();
		assignmentTitleInput.setBounds(125, 5, 310, 30);
		this.add(title);
		this.add(assignmentTitleInput);
		
		instructions = new JLabel("Assignment Instructions", SwingConstants.CENTER);
		instructions.setBounds(0, 40, 540, 30);
		assignmentInstructionsInput = new JTextArea();
		assignmentInstructionsInput.setBounds(10, 70, 520, 230);
		this.add(instructions);
		this.add(assignmentInstructionsInput);
		
		pickDateButton = new JButton("pick due date");
		pickDateButton.setBounds(202, 310, 130, 30);
		pickDateButton.addActionListener(this);
		this.add(pickDateButton);
		
		dueDateLabel = new JLabel("Due Date: ", SwingConstants.CENTER);
		dueDateLabel.setBounds(0, 345, 540, 30);
		this.add(dueDateLabel);
		
		publishButton = new JButton("Publish assignment");
		publishButton.setBounds(182, 380, 170, 60);
		publishButton.setForeground(Color.blue);
		publishButton.addActionListener(this);
		this.add(publishButton);
	}
		
	public void actionPerformed(ActionEvent click) {
		if (click.getSource() == pickDateButton) {
			dueDate = new DatePicker(this).getPickedDate();
			dueDateLabel.setText("Due Date: " + dueDate);
		}
		if (click.getSource() == publishButton){
			String title = assignmentTitleInput.getText();
			String instructions = assignmentInstructionsInput.getText().trim();
			String courseCode = instructor.getCourseTaught().getCourseCode();
			instructor.addAssignment(new Assignment(title, instructions, dueDate, courseCode));
			userHomePage.successfullPublish.setText("Assignment published successfully!");
			this.dispose();
			userHomePage.setVisible(true);
		}
	}
}