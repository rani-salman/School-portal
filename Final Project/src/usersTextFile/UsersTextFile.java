package usersTextFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.*;
import users.*;
;public class UsersTextFile {
	
	private static File users = new File("Users.txt");
	
	private static boolean isUserAlreadySignedUp(LauUser user) throws FileNotFoundException{
		Scanner sc = new Scanner(users);
		boolean isSignedUp = false;
		while(sc.hasNext()) {
			String line = sc.nextLine();
			String[] parameters = line.split(" "); 
			if(parameters[3].equals(user.getEmail())){
				isSignedUp = true;
				break;
			}
		}
		sc.close();
		return isSignedUp;
	}
	
	public static void addUser(LauUser user) throws IOException, UserAlreadySignedUpException{
		if (isUserAlreadySignedUp(user)) 
			throw new UserAlreadySignedUpException();
		else {
			FileWriter fw = new FileWriter(users, true);
			fw.write(user.toString()+"\n");
			fw.close();
		}
	}
	
	public static LauUser getUser(String email, String password) 
			throws FileNotFoundException, UserNotFoundException, InvalidEmailException, InvalidPasswordException, 
			ContainsSpaceException, NameTooShortException{
		Scanner sc = new Scanner(users);
		while(sc.hasNext()) {
			String line = sc.nextLine();
			String[] user = line.split(" ");
			if (user[3].equals(email) && user[4].equals(password)) {
				sc.close();
				if (user[0].equals("Student"))
					return new Student (user[1], user[2], user[3], user[4]);
				else 
					return new Instructor(user[1], user[2], user[3], user[4]);
			}
		}
		sc.close();
		throw new UserNotFoundException();
	}
	
	public static ArrayList<LauUser> getUsers() 
			throws FileNotFoundException, InvalidEmailException, InvalidPasswordException, ContainsSpaceException, NameTooShortException{
		ArrayList<LauUser> lauUsers = new ArrayList<LauUser>();
		Scanner sc = new Scanner(users);
		while (sc.hasNext()) {
			String line = sc.nextLine();
			String[] parameters = line.split(" "); 
			if (parameters[0].equals("Student")) 
				lauUsers.add(new Student(parameters[1], parameters[2], parameters[3], parameters[4]));
			else if (parameters[0].equals("Instructor")) 
				lauUsers.add(new Instructor(parameters[1], parameters[2], parameters[3], parameters[4]));
		}
		sc.close();
		return lauUsers;
	}
}
