
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import exceptions.*;
import users.*;
import usersTextFile.UsersTextFile;

@SuppressWarnings("serial")
public class SignupPage extends JFrame implements ActionListener{
	private JButton signupButton;
	private JLabel firstName, lastName, userType, email, password;
	private JLabel invalidNames, invalidEmail, invalidPassword, alreadySignedUp1, alreadySignedUp2;
	private JRadioButton student, instructor;
	private ButtonGroup bg;
	private JTextField firstNameInput, lastNameInput, emailInput, passwordInput;
	
	public SignupPage() {
		this.setTitle("Sign up page");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(360, 350);
		this.setLayout(null);
		ImageIcon image = new ImageIcon("lau-logo.jpg");
		this.setIconImage(image.getImage());
		
		firstName = new JLabel("First Name:");
		firstName.setBounds(70 ,10, 80, 25);
		firstNameInput = new JTextField();
		firstNameInput.setBounds(140, 10, 100, 25);
		this.add(firstName);
		this.add(firstNameInput);
		lastName = new JLabel("Last Name: ");
		lastName.setBounds(70, 40, 80, 25);
		lastNameInput = new JTextField();
		lastNameInput.setBounds(140, 40, 100, 25);
		this.add(lastName);
		this.add(lastNameInput);
		invalidNames = new JLabel("" , SwingConstants.CENTER);
		invalidNames.setBounds(30, 65, 300, 20);
		invalidNames.setForeground(Color.red);
		this.add(invalidNames);
		
		userType = new JLabel("User type:");
		student = new JRadioButton("Student");    
		instructor = new JRadioButton("Instructor");  
		userType.setBounds(35, 90, 60, 25);
		student.setBounds(105, 90, 70, 25);   
		instructor.setBounds(195, 90, 80, 25);
		bg = new ButtonGroup();
		bg.add(student);
		bg.add(instructor);
		student.setSelected(true);
		this.add(userType);
		this.add(student);
		this.add(instructor);
		
		email = new JLabel("LAU Email:");
		email.setBounds(36 ,125, 80, 25);
		emailInput = new JTextField();
		emailInput.setBounds(100, 125, 180, 25);
		this.add(email);
		this.add(emailInput);
		invalidEmail = new JLabel();
		invalidEmail.setBounds(65, 145, 200, 20);
		invalidEmail.setForeground(Color.red);
		this.add(invalidEmail);
		
		password = new JLabel("Password:");
		password.setBounds(70, 170, 80, 25);
		passwordInput = new JTextField();
		passwordInput.setBounds(140, 170, 100, 25);
		this.add(password);
		this.add(passwordInput);
		invalidPassword = new JLabel("" ,SwingConstants.CENTER);
		invalidPassword.setBounds(40, 190, 255, 20);
		invalidPassword.setForeground(Color.red);
		this.add(invalidPassword);
		
		alreadySignedUp1 = new JLabel();
		alreadySignedUp2 = new JLabel();
		alreadySignedUp1.setBounds(35, 220, 255, 20);
		alreadySignedUp2.setBounds(48, 235, 255, 20);
		alreadySignedUp1.setForeground(Color.red);
		alreadySignedUp2.setForeground(Color.red);
		this.add(alreadySignedUp1);
		this.add(alreadySignedUp2);
		
		signupButton = new JButton("Sign up");
		signupButton.setBounds(125, 260, 100, 35);
		signupButton.addActionListener(this);
		this.add(signupButton);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent click) {
		if (click.getSource() == signupButton)
			try {
				boolean validEmail = false;
				boolean validPassword = false;
				boolean validNames = false;
				
				String userType = student.isSelected() ? "Student" : "Instructor";
				LauUser user;
				if(userType.equals("Student"))
					user  = new Student();
				else 
					user = new Instructor();
				student.setEnabled(false);
				instructor.setEnabled(false);
				
				String firstName = firstNameInput.getText();
				String lastName = lastNameInput.getText();
				try {
					user.setFirstName(firstName);
					user.setLastName(lastName);
					firstNameInput.setEditable(false);
					lastNameInput.setEditable(false);
					validNames = true;
					invalidNames.setText("");
				}
				catch(NameTooShortException e) {
					invalidNames.setText(e.getMessage());
				}
				catch(ContainsSpaceException e) {
					invalidNames.setText("First/Last name can not contain spaces");
				}
				
				String email = emailInput.getText();
				String password =  passwordInput.getText();
				try {
					user.setEmail(email);
					invalidEmail.setText("");
					emailInput.setEditable(false);
					validEmail = true;
				}
				catch(InvalidEmailException e) {
					invalidEmail.setText(e.getMessage());
				}
				try {
					user.setPassword(password);
					invalidPassword.setText("");
					passwordInput.setEditable(false);
					validPassword = true;
				}
				catch (InvalidPasswordException e){
					invalidPassword.setText(e.getMessage());
				}
				catch (ContainsSpaceException e) {
					invalidPassword.setText("Password can not contain spaces");
				}
				if (validEmail && validPassword && validNames)
					try {
						UsersTextFile.addUser(user);
						alreadySignedUp1.setText("");
						alreadySignedUp2.setText("");
						new LoginPage(true); 
						this.dispose();
					}
					catch (UserAlreadySignedUpException e){
						emailInput.setEditable(true);
						alreadySignedUp1.setText(e.getMessage());
						alreadySignedUp2.setText("either log in with it or use another email");
					}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}

}
