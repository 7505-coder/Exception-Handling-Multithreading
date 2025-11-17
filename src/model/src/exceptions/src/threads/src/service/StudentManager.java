package service;

import model.Student;
import exceptions.StudentNotFoundException;
import threads.Loader;
import java.util.*;

public class StudentManager {

    private Map<Integer, Student> records = new HashMap<>();

    public void addStudent(Student s) {
        Thread loader = new Thread(new Loader());
        loader.start();

        try {
            loader.join();
            if (recordExists(s.rollNo)) {
                throw new IllegalArgumentException("Duplicate Roll Number! Cannot add.");
            }
            records.put(s.rollNo, s);
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewStudent(Integer rollNo) throws StudentNotFoundException {
        if (!recordExists(rollNo)) {
            throw new StudentNotFoundException("Student with roll no " + rollNo + " not found.");
        }
        records.get(rollNo).display();
    }

    public void viewAllStudents() {
        if (records.isEmpty()) {
            System.out.println("No records available.");
            return;
        }
        for (Student s : records.values()) {
            s.display();
            System.out.println("----------------------");
        }
    }

    private boolean recordExists(Integer rollNo) {
        return records.containsKey(rollNo);
    }
}
