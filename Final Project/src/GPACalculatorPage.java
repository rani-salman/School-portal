
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Stack;
import javax.swing.*;
import blackBoardClasses.Course;
import users.Student;

@SuppressWarnings("serial")
public class GPACalculatorPage extends JFrame implements ActionListener{
	private StudentHomePage userHomePage;
	private Student student;
	private JLabel courseName, grade, creditNumber;
	private JTextField courseNameInput;
	private JComboBox<String> gradeInput, creditNumberInput;
	private JButton calculate, clear, addCourse;
	private JLabel gpaResult;
	private Stack<Course> courses = new Stack<Course>();
	private JTextArea coursesAdded;
	
	public GPACalculatorPage(Student user, StudentHomePage homePage) {
		student = user;
		userHomePage = homePage;
		userHomePage.setVisible(false);
		
		this.setTitle("GPA calculator");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setSize(550, 420);
		this.setLayout(null);
		ImageIcon image = new ImageIcon("lau-logo.jpg");
		this.setIconImage(image.getImage());
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				userHomePage.setVisible(true);
		    }
		});
		
		courseName = new JLabel("Course Name");
		courseName.setBounds(30, 10, 100, 30);
		this.add(courseName);
		courseNameInput = new JTextField();
		courseNameInput.setBounds(25, 40, 130, 30);
		this.add(courseNameInput);
		
		grade = new JLabel("Expected grade");
		grade.setBounds(195, 10, 100, 30);
		this.add(grade);
		String[] letterGrades = {
				"A", "A-", "B+", "B", "B-","C+", "C", "C-", "D+", "D", "F" 
		};
		gradeInput = new JComboBox<String>(letterGrades);
		gradeInput.setBounds(180, 40, 120, 30); 
		this.add(gradeInput);
		
		creditNumber = new JLabel("Credits");
		creditNumber.setBounds(355, 10, 100, 30);
		this.add(creditNumber);
		String[] creditNumbers = {"1", "2", "3", "4", "5", "6"};
		creditNumberInput = new JComboBox<String>(creditNumbers);
		creditNumberInput.setBounds(335, 40, 100, 30); 
		this.add(creditNumberInput);
		
		addCourse = new JButton("+");
        addCourse.setBounds(455, 40, 50, 30);
        addCourse.addActionListener(this);
        this.add(addCourse);
        
        coursesAdded = new JTextArea();
        coursesAdded.setBounds(170, 100, 210, 150);
        this.add(coursesAdded);
        
        gpaResult = new JLabel("", SwingConstants.CENTER);
        gpaResult.setBounds(0, 260, 540, 30);
        gpaResult.setForeground(Color.red);
        gpaResult.setFont(new Font(null, Font.PLAIN, 14));
        this.add(gpaResult);
        
		calculate = new JButton("Calculate GPA");
        calculate.setBounds(100, 310, 150, 50);
        calculate.addActionListener(this);
        this.add(calculate);
        
        clear = new JButton("Clear input");
        clear.setBounds(300, 320, 130, 30);
        clear.addActionListener(this);
        this.add(clear);
        
        this.setVisible(true);
	}
	
	private static double convertGradeToDouble(String letterGrade) {
		switch (letterGrade) {
			case "A":
				return 4.0;
			case "A-":
				return 3.67;
			case "B+":
				return 3.33;
			case "B":
				return 3.0;
			case "B-":
				return 2.67;
			case "C+":
				return 2.33;
			case "C":
				return 2.0;
			case "C-":
				return 1.67;
			case "D+":
				return 1.33;
			case "D":
				return 1.0;
			default: //F
				return 0.0;
		}
	}
	private double calculateGPA(){
		double totalCredits = 0;
		double totalGrades = 0;
		Course temp;
		while (!courses.empty()) {
			temp = courses.pop();
			totalGrades += (temp.getGrade() * temp.getCreditHours());
			totalCredits += temp.getCreditHours();
		}
        return totalGrades/totalCredits;        
    }

	public void actionPerformed(ActionEvent click) {
		if (click.getSource() == addCourse) {
			String courseName = courseNameInput.getText();
			String letterGrade = gradeInput.getItemAt(gradeInput.getSelectedIndex());
			double grade = convertGradeToDouble(letterGrade);
			String creditNumber = creditNumberInput.getItemAt(creditNumberInput.getSelectedIndex());
			courses.push(new Course(courseName, grade, Integer.parseInt(creditNumber)));
			coursesAdded.append(String.format("%s \t %s \t %s\n", courseName, letterGrade, creditNumber));
			courseNameInput.setText("");
		}
		if (click.getSource() == calculate ) {
			String output = String.format("%s, your GPA will be: %.2f", student.getFirstName(), calculateGPA());
			gpaResult.setText(output);
		}
		if (click.getSource() == clear) {
			courseNameInput.setText("");
			coursesAdded.setText("");
			gpaResult.setText("");
		}
	}
}
