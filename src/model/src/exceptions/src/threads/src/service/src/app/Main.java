package app;

import model.Student;
import service.StudentManager;
import exceptions.StudentNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        try {
            System.out.print("Enter Roll No (Integer): ");
            Integer rollNo = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            System.out.print("Enter Marks (Double): ");
            Double marks = Double.parseDouble(sc.nextLine());

            if (marks < 0 || marks > 100)
                throw new IllegalArgumentException("Marks must be between 0 and 100.");

            Student s = new Student(rollNo, name, email, course, marks);
            manager.addStudent(s);

            manager.viewStudent(rollNo);

        } catch (StudentNotFoundException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Number Input! Use proper integer/double values.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("\nProgram execution completed.");
        }
    }
}
