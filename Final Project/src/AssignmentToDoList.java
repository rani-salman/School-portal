
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.*;
import blackBoardClasses.Assignment;
import users.Student;

@SuppressWarnings("serial")
public class AssignmentToDoList extends JFrame{
	private StudentHomePage userHomePage;
	private Student student;
	private JLabel head, nothingHere;
	private ImageIcon checked, unchecked;
	
	public AssignmentToDoList(Student user, StudentHomePage homePage) {
		student = user;
		userHomePage = homePage;
		userHomePage.setVisible(false);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		ImageIcon image = new ImageIcon("lau-logo.jpg");
		this.setIconImage(image.getImage());
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				userHomePage.setVisible(true);
		    }  
		});
		
		JPanel header = new JPanel(new GridLayout(1, 1));
		header.setPreferredSize(new Dimension(400, 40));
		head = new JLabel("Assignments to do list:", SwingConstants.CENTER);
		head.setFont(new Font(null, Font.ROMAN_BASELINE, 14));
		head.setForeground(Color.blue);
		head.setBounds(0, 10, 500, 30);
		header.add(head);
		this.add(header, BorderLayout.NORTH);
		this.pack();
		
		ArrayList<Assignment> assignments = student.viewAllAssignments();
		int numberOfAssignments = assignments.size();

		if (numberOfAssignments != 0) {
			checked = new ImageIcon("true.png");
			unchecked = new ImageIcon("false.png");
			JCheckBox[] assignmentsButtons = new JCheckBox[numberOfAssignments];
			JPanel panel = new JPanel(new GridLayout((numberOfAssignments %2 == 0 ? numberOfAssignments/2  : numberOfAssignments/2 + 1), 2));
			for (int i = 0; i < numberOfAssignments; i++) {
				String description = "<html>" + assignments.get(i).toString().replace("\n", "<br>");
				assignmentsButtons[i] = new JCheckBox(description);
				assignmentsButtons[i].setIcon(unchecked);
				assignmentsButtons[i].setSelectedIcon(checked);
				panel.add(assignmentsButtons[i]);
			}
			this.add(panel, BorderLayout.SOUTH);
			this.pack();
		}
		else {
			JPanel noAssignments = new JPanel(new GridLayout(1, 1));
			noAssignments.setPreferredSize(new Dimension(400, 200));
			nothingHere = new JLabel("No assignments yet....", SwingConstants.CENTER);
			nothingHere.setFont(new Font(null, Font.PLAIN, 14));
			noAssignments.add(nothingHere);
			this.add(noAssignments, BorderLayout.SOUTH);
			this.pack();
		}
		this.setVisible(true);
	}

}

