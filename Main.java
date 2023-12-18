package JavaProject;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//Takes input from user

        System.out.println("Welcome to the Student Registration Portal!");

        System.out.print("Enter the number of students to register: ");
        int numStudents = scanner.nextInt();
            //try to know the whole number of student who get registered
        Student[] students = new Student[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nStudent " + (i + 1) + " Details:");

            System.out.println("Enter student ID (max 7 digits):");
            String id = scanner.next();

            if (id.length() > 7) {
                System.out.println("Invalid ID. Please enter a valid ID with max 6 digits.");
              //  continue;
                // }
                try {
                    throw new InvalidIDException("Invalid ID provided");
                } catch (InvalidIDException e) {
                    System.out.println("Caught InvalidIDException: " + e.getMessage());
                }
            }
            System.out.println("Enter student UID (max 6 digits):");
            String UID = scanner.next();
            //if the UID is more than 6 digits it will jump this part by telling it is invalid UID
            if (UID.length() > 6) {
                System.out.println("Invalid UID. Please enter a valid UID with max 6 digits.");
              //  continue;
           // }
            try {
                throw new InvalidUIDException("Invalid UID provided");
            } catch (InvalidUIDException e) {
                System.out.println("Caught InvalidUIDException: " + e.getMessage());
            }
        }
              //asks the previous grade of student to decide the department
            System.out.println("Enter previous grade:");
            double previousGrade = scanner.nextDouble();
            //asks the user to inter their name
            System.out.print("Enter the student name: ");
            String name = scanner.next();
              //the list of the department
            System.out.print("Choose the department" + " (1 - Software Engineering, 2 - Computer Science, 3 - Information System, 4 - Information Technology, 5 - Statistics): ");
            int departmentChoice = scanner.nextInt();
            String StudentDepartment = switch (departmentChoice) {
                case 1 -> "Software Engineering";
                case 2 -> "Computer Science";
                case 3 -> "Information System";
                case 4 -> "Information Technology";
                case 5 -> "Statistics";
                default -> "Unknown";
            };

            students[i] = new Student(id, UID, previousGrade, name, StudentDepartment);
              //This code check, if student want software they have to get above 3.6
            if (StudentDepartment.equals("Software Engineering") && previousGrade < 3.6) {
                System.out.println("Invalid previous grade. Minimum previous grade required for Software Engineering is 3.6.");
                try {
                    throw new NullPointerException("Null value encountered");
                } catch (NullPointerException e) {
                    System.out.println("Caught NullPointerException: " + e.getMessage());
                }

                try {
                    throw new InvalidDepartmentException("Invalid department specified");
                } catch (InvalidDepartmentException e) {
                    System.out.println("Caught InvalidDepartmentException: " + e.getMessage());
                }
            }
        }
         //This is the part where all the information we gathered executed
        System.out.println("\nRegistration Successful!");
        System.out.println("Registered Students:");

        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getId());
            System.out.println("UID: " + student.getUID());
            System.out.println("Department: " + Student.getDepartment());
            System.out.println("Previous Grade: " + student.getPreviousGrade());
            System.out.println();
        }
    }
}
