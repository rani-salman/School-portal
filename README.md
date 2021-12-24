# CSC245-Final-Project

Lebanese American University
Department of Computer Science & Mathematics
Object and Data Abstraction
 
Final-project

Instructor: Dr. Azzam Mourad

Team 19
--------------
Rani Salman
202001002
Mohamad Khalifeh¬
202000865
Ali Youssef Solh
202004405

Project report: BlackBoard
--------------------------

Project overview
----------------
This project is a clone/simplified version of BlackBoard. It includes:
•	A sign-up and log-in system for all users
•	A course registration system that allows: 
o	Instructors to teach and take control over a course
o	Students to register (add/drop) courses
•	An announcement/assignment manager that enables:
o	Instructors to publish assignments/announcements
o	Students to view announcements and their assignments
•	A GPA calculator feature for students


Summary of the code:
--------------------
•	Sign up: The sign-up page consists of the user entering his personal information, and this information will be written and stored in a text file. The inputs of the user will be validated using exception handling.

•	Log in: The log-in page consists of the user entering his email and password that he/she chose earlier during the sign-up process. We read from the users' text file to check if the credentials entered are valid or not.

•	OOP design: We built many classes to represent different objects in our application. These classes applied all four of the main object-oriented programming concepts. We respected encapsulation in the design of the classes. We also used inheritance and polymorphism, for example, the abstract LAUuser class. We used interfaces in the GUI classes as well. We also applied composition in many different classes.

•	Data structures: We used many data structures to manage the course registration process and to store the information communicated between the instructors and students. Here are the use cases of each data structure
o	we have an Array that stores all of the courses in our application 
o	we used the ArrayList data structure to store all of the published announcements/assignments (instructors can publish announcements or assignments; these publications are getting appended to a list: The ArrayList data structure is best suited for this type of operation)
o	we used LinkedList data structure to store the registered courses of all students (since the student can add/drop courses a LinkedList is better suited for this operation than other data structures since it adds and removes elements in constant time) 
o	we used the Stack data structure is the GPA calculator feature.

•	User Interface: We built the graphical user interface (GUI) with the Java Swing and AWT libraries.
