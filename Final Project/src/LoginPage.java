
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import exceptions.*;
import users.*;
import usersTextFile.UsersTextFile;

@SuppressWarnings("serial")
public class LoginPage extends JFrame implements ActionListener{
	private JButton loginButton;
	private JLabel email, password, unsuccessfullLogin;
	private JLabel successSignUP = new JLabel();
	private JTextField emailInput;
	private JPasswordField passwordInput;
	
	public LoginPage(boolean cameFromSignUp) {
		if (cameFromSignUp) {
			successSignUP.setText("Sign up succeeded! You can Log in to your account now.");
			successSignUP.setBounds(10, 0, 340, 20);
			successSignUP.setForeground(Color.BLUE);
			this.add(successSignUP);
		}
		this.setTitle("Log in page");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(360, 200);
		this.setLayout(null);
		ImageIcon image = new ImageIcon("lau-logo.jpg");
		this.setIconImage(image.getImage());
		
		email = new JLabel("email");
		email.setBounds(20 ,30, 80, 25);
		emailInput = new JTextField();
		emailInput.setBounds(90, 30, 183, 25);
		this.add(email);
		this.add(emailInput);
		
		password = new JLabel("password");
		password.setBounds(20, 60, 80, 25);
		passwordInput = new JPasswordField();
		passwordInput.setBounds(100, 60, 165, 25);
		this.add(password);
		this.add(passwordInput);
		
		unsuccessfullLogin = new JLabel();
		unsuccessfullLogin.setForeground(Color.red);
		unsuccessfullLogin.setBounds(105, 75, 160, 35);
		this.add(unsuccessfullLogin);
		
		loginButton = new JButton("Log in");
		loginButton.setBounds(125, 110, 100, 35);
		loginButton.addActionListener(this);
		this.add(loginButton);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent click) {
		if (click.getSource() == loginButton)
			try {
				String email = emailInput.getText().trim();
				@SuppressWarnings("deprecation")
				String password =  passwordInput.getText();
				LauUser user = UsersTextFile.getUser(email, password);
				unsuccessfullLogin.setText("");
				if (user instanceof Student)
					new StudentHomePage((Student) user);
				else
					new InstructorHomePage((Instructor) user);
				this.dispose();
			}
			catch(UserNotFoundException error){
				unsuccessfullLogin.setText(error.getMessage());
				successSignUP.setText("");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}

}
