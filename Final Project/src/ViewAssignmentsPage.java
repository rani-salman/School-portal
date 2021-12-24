
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import blackBoardClasses.Assignment;
import javax.swing.*;
import users.Student;

@SuppressWarnings("serial")
public class ViewAssignmentsPage extends JFrame{
	private StudentHomePage userHomePage;
	private Student student;
	private JScrollPane display;
	private JLabel nothingHere;
	
	public ViewAssignmentsPage(Student user, StudentHomePage homePage) {
		student = user;
		userHomePage = homePage;
		userHomePage.setVisible(false);
		
		this.setTitle("Assignments Page");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(600, 450);
		ImageIcon image = new ImageIcon("lau-logo.jpg");
		this.setIconImage(image.getImage());
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				userHomePage.setVisible(true);
		    }  
		});
		ArrayList<Assignment> assignments = student.viewAllAssignments();
		if (assignments.size() == 0 ) {
			nothingHere = new JLabel("No assignments yet....", SwingConstants.CENTER);
			nothingHere.setFont(new Font(null, Font.PLAIN, 14));
			nothingHere.setBounds(0, 200, 320, 40);
			this.add(nothingHere);
		}
		else {
			JTextArea textArea = new JTextArea();
			String output = "";
			for (Assignment a : assignments) {
				output += (a.toString() );
				output += "\n-------------------------------------------------------------------------------------------------------------------------------------------------\n";
			}
			textArea.setText(output);
			display = new JScrollPane(textArea);
			this.getContentPane().add(display, BorderLayout.CENTER);
		}
		this.setVisible(true);
	}
}
