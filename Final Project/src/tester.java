
//import java.util.Scanner;
//import blackBoardClasses.*;

import exceptions.*;
import users.*;

public class tester {
	
	public static void main(String[] args) throws InvalidEmailException, InvalidPasswordException, ContainsSpaceException, NameTooShortException {
		Instructor i = new Instructor("Azzam", "Mourad", "moafds.fadsf@lau.edu","fsaadfsfads");
		new InstructorHomePage(i);
//
//		Student s = new Student("Mohamad", "Khalife", "moafds.fadsf@lau.edu","fsaadfsfads");
//		new StudentHomePage(s);
//		
//		Student h = new Student("Mohamad", "Khalife", "moafgdfds.fadsf@lau.edu","fsaadfsfads");
//		new StudentHomePage(h);
//		
//		Student d = new Student("Mohamad", "Khalife", "moafdsasfdafs.fadsf@lau.edu","fsaadfsfads");
//		new StudentHomePage(d);
		
//		new AppServer(); //start point of application
		
//		Scanner sc = new Scanner(System.in);
//		sc.nextLine();
//		System.out.println(s.getRegisteredCourses());
//		sc.nextLine();
//		System.out.println(s.getRegisteredCourses());
//		sc.close();
	}

}
