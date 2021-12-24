
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import javax.swing.*;
import blackBoardClasses.Announcement;
import users.Student;

@SuppressWarnings("serial")
public class ViewAnnouncementsPage extends JFrame {
	private StudentHomePage userHomePage;
	private Student student;
	private JScrollPane display;
	private JLabel nothingHere;
	
	public ViewAnnouncementsPage(Student user, StudentHomePage homePage) {
		student = user;
		userHomePage = homePage;
		userHomePage.setVisible(false);
		
		this.setTitle("Announcements Page");
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
		LinkedList<Announcement> announcements = student.viewAllAnnouncements();
		if (announcements.size() == 0 ) {
			nothingHere = new JLabel("No announcements yet....", SwingConstants.CENTER);
			nothingHere.setFont(new Font(null, Font.PLAIN, 14));
			nothingHere.setBounds(0, 200, 320, 40);
			this.add(nothingHere);
		}
		else {
			JTextArea textArea = new JTextArea();
			String output = "";
			for (Announcement announcement : announcements) {
				output += (announcement.toString());
				output += "\n-------------------------------------------------------------------------------------------------------------------------------------------------\n";
			}
	        textArea.setText(output);
			display = new JScrollPane(textArea);
			this.getContentPane().add(display, BorderLayout.CENTER);
		}
		this.setVisible(true);
	}
}
