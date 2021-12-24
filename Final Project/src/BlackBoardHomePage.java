
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import users.*;

@SuppressWarnings("serial")
public abstract class BlackBoardHomePage extends JFrame implements ActionListener {
	protected JButton courseAction, announcementAction, assignmentAction;
	private JLabel welcomeLabel;
	
	public BlackBoardHomePage(LauUser user){
		this.setTitle("BlackBoard home page");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(470, 300);
		this.setLayout(null);
		ImageIcon image = new ImageIcon("lau-logo.jpg");
		this.setIconImage(image.getImage());
		
		String welcomeMessage = String.format("Welcome %s %s", user.getFirstName(), user.getLastName());
		welcomeLabel = new JLabel(welcomeMessage, SwingConstants.CENTER);
		welcomeLabel.setBounds(0, 20, 470, 25);
		this.add(welcomeLabel);
		
		assignmentAction = new JButton();
		assignmentAction.setBounds(65, 60, 150, 60);
		assignmentAction.addActionListener(this);
		this.add(assignmentAction);
		
		announcementAction = new JButton();
		announcementAction.setBounds(245, 60, 150, 60);
		announcementAction.addActionListener(this);
		this.add(announcementAction);
		
		courseAction = new JButton();
		courseAction.setBounds(155, 150, 150, 60);
		courseAction.addActionListener(this);
		this.add(courseAction);
		
		this.setVisible(true);
	 }

	public abstract void actionPerformed(ActionEvent click);

}