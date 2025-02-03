package edu.ucalgary.oop;

import java.util.ArrayList;

/**
 * GradeManager class handles operations related to managing a list of students,
 * including adding students, retrieving them by ID, and calculating the class average.
 */
public class GradeManager {
    private ArrayList<Student> students;  // List to store student objects

    // Constructor to initialize the student list.
    public GradeManager() {
        students = new ArrayList<Student>();
    }

    /**
     * Adds a new student to the list if the student ID is unique.
     * @param student The Student object to be added.
     * @throws IllegalArgumentException if a student with the same ID already exists.
     */
    public void addStudent(Student student) {
        for (Student s : students) {
            if (s.getStudentID().equals(student.getStudentID())) {
                throw new IllegalArgumentException("Student with this ID already exists.");
            }
        }
        students.add(student);
    }

    /**
     * Retrieves a student by their unique student ID.
     * @param studentID The unique ID of the student.
     * @return The Student object if found, otherwise null.
     */
    public Student getStudentByID(String studentID) {
        for (Student s : students) {
            if (s.getStudentID().equals(studentID)) {
                return s;
            }
        }
        return null;  // Return null if no matching student is found
    }

    /**
     * Calculates the average grade of all students in the class.
     * If any student has no grades available, they are skipped.
     * @return The class average grade.
     * @throws IllegalStateException if no valid grades are available for calculation.
     */
    public double calculateClassAverage() {
        double total = 0;  // Accumulator for total grades
        int count = 0;     // Counter for number of students with valid grades

        for (Student s : students) {
            try {
                total += s.calculateAverage();  // Sum up the averages of all students
                count++;  // Increment count of students with valid grades
            } catch (IllegalStateException e) {
                // Handle students with no valid grades by skipping them and logging a message
                System.out.println("Skipping student " + s.getStudentID() + ": " + e.getMessage());
            }
        }

        if (count == 0) {
            throw new IllegalStateException("No students with valid grades to calculate average.");
        }

        return total;  // Return the calculated class average
    }

    /**
     * Returns the total number of students currently managed by the system.
     * @return The number of students in the list.
     */
    public int getTotalStudents() {
        return students.size() - 1;
    }

}