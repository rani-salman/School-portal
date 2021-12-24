
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class AppServer extends JFrame implements ActionListener{
	private JButton signUp;
	private JButton logIn;
	
	public AppServer(){
		this.setTitle("Home page");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(300, 225);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		ImageIcon image = new ImageIcon("lau-logo.jpg");
		this.setIconImage(image.getImage());
		
		JLabel welcome = new JLabel("Welcome to BlackBoard"); 
		welcome.setBounds(74, 5, 150, 25);
		this.add(welcome);
		JLabel PS =new JLabel("(PS: Closing this window will close the whole app)");
		PS.setForeground(Color.red);
		PS.setBounds(3, 150, 290, 50);
		this.add(PS);
		
		signUp = new JButton("click here to sign up");
		logIn = new JButton("click here to log in");
		signUp.setBounds(67, 40, 149 ,50);
		signUp.addActionListener(this);
		logIn.setBounds(67, 100, 149 ,50);
		logIn.addActionListener(this);
		this.add(signUp);
		this.add(logIn);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent click) {
		if (click.getSource() == signUp) 
			new SignupPage();
		if (click.getSource() == logIn) 
			new LoginPage(false);
	}
}
