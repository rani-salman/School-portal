
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalTime;
import javax.swing.*;
import blackBoardClasses.Announcement;
import users.Instructor;

@SuppressWarnings("serial")
public class CreateAnnouncementPage extends JFrame implements ActionListener{
	private Instructor instructor;
	private InstructorHomePage userHomePage;
	private JLabel title, body;
	private JTextField announcementTitleInput;
	private JTextArea announcementBodyInput;
	private JButton publishButton; 

	public CreateAnnouncementPage(Instructor instructor, InstructorHomePage homePage) {
		setInstructor(instructor);
		userHomePage = homePage;
		userHomePage.setVisible(false);
		
		this.setTitle("Add announcement page");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(555, 420);
		this.setLayout(null);
		ImageIcon image = new ImageIcon("lau-logo.jpg");
		this.setIconImage(image.getImage());
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				userHomePage.setVisible(true);
		    }  
		});
		
		title = new JLabel("Title:");
		title.setBounds(75, 5, 40, 30);
		announcementTitleInput = new JTextField();
		announcementTitleInput.setBounds(125, 5, 310, 30);
		this.add(title);
		this.add(announcementTitleInput);
		
		body = new JLabel("Announcement body", SwingConstants.CENTER);
		body.setBounds(0, 40, 540, 30);
		announcementBodyInput = new JTextArea();
		announcementBodyInput.setBounds(10, 70, 550, 230);
		this.add(body);
		this.add(announcementBodyInput);
		
		publishButton = new JButton("Publish announcement");
		publishButton.setBounds(170, 315, 200, 50);
		publishButton.addActionListener(this);
		this.add(publishButton);
		
		this.setVisible(true);
	}

	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
		
	public void actionPerformed(ActionEvent click) {
		if (click.getSource() == publishButton) {
			String title = announcementTitleInput.getText();
			String body = announcementBodyInput.getText().trim();
			String courseCode = instructor.getCourseTaught().getCourseCode();
			LocalTime currTime = LocalTime.now();
			instructor.addAnnouncement(new Announcement(title, body, courseCode, currTime));
			userHomePage.successfullPublish.setText("Announcement published successfully!");
			this.dispose();
			userHomePage.setVisible(true);
		}
	}
}