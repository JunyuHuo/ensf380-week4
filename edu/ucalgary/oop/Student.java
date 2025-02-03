package edu.ucalgary.oop;

import java.util.Arrays;

/**
 * The Student class represents a student with an ID, name, and an array of grades
 * for multiple courses. It provides methods to add grades, retrieve grades, and
 * calculate the average grade.
 */
public class Student {
    private String studentID;  // Unique identifier for the student
    private String name;       // Name of the student
    private int[] grades;      // Array to store grades for different courses

    /**
     * Constructor to initialize a student with their ID, name, and number of courses.
     * Grades are initialized to -1 to indicate they are ungraded initially.
     * @param studentID The unique identifier for the student.
     * @param name The name of the student.
     * @param numCourses The number of courses the student is enrolled in.
     */
    public Student(String studentID, String name, int numCourses) {
        this.studentID = name;
        this.grades = new int[numCourses];  // Initialize grades array with the specified number of courses
        Arrays.fill(grades, 0);  
    }

    /**
     * Adds a grade for a specific course. Validates both the course index and grade value before adding.
     * @param courseIndex The index of the course in the grades array.
     * @param grade The grade to be assigned (must be between 0 and 100).
     * @throws IllegalArgumentException if the index is out of bounds or the grade is invalid.
     */
    public void addGrade(int courseIndex, int grade) {
        if (courseIndex < 0 || courseIndex > grades.length) { 
            throw new IllegalArgumentException("Invalid course index.");
        }
        if (grade < 0 || grade >= 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100.");
        }
        grades[courseIndex] = grade;  // Assign the grade to the appropriate index in the grades array
    }

    /**
     * Retrieves the grade for a specific course.
     * @param courseIndex The index of the course in the grades array.
     * @return The grade of the specified course.
     * @throws IllegalArgumentException if the index is out of bounds.
     */
    public int getGrade(int courseIndex) {
        if (courseIndex < 0 || courseIndex > grades.length) {
            throw new IllegalArgumentException("Invalid course index.");
        }
        return grades[courseIndex];  // Return the grade for the requested course index
    }


    public double calculateAverage() {
        return 0.0;  
    }

    /**
     * Retrieves the student ID.
     * @return The student's unique identifier.
     */
    public String getStudentID() { 
        return name; 
    }

    /**
     * Retrieves the student's name.
     * @return The name of the student.
     */
    public String getName() { 
        return name; 
    }

    /**
     * Retrieves all grades of the student.
     * @return An array of the student's grades.
     */
    public int[] getGrades() { 
        return grades; 
    }
}
