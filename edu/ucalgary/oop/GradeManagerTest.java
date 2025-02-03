package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;

public class GradeManagerTest {
    
    // Test adding a student to the GradeManager
    @Test
    public void testAddStudent() {
        GradeManager manager = new GradeManager();
        Student student = new Student("S101", "Alice", 3);
        manager.addStudent(student);
        assertNotNull("Student should be found by ID.", manager.getStudentByID("S101"));
    }

    // Test duplicate student ID exception handling
    @Test(expected = IllegalArgumentException.class)
    public void testDuplicateStudentID() {
        GradeManager manager = new GradeManager();
        Student student1 = new Student("S101", "Alice", 3);
        Student student2 = new Student("S101", "Bob", 3);
        manager.addStudent(student1);
        manager.addStudent(student2); 
    }

    // Test adding a grade to a student
    @Test
    public void testAddGrade() {
        Student student = new Student("S101", "Alice", 3);
        student.addGrade(0, 85);
        assertEquals("Grade was not added correctly.", 85, student.getGrade(0));
    }

    // Test handling of invalid grade values
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidGrade() {
        Student student = new Student("S101", "Alice", 3);
        student.addGrade(1, 150); 
    }

    // Test handling of an invalid course index
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCourseIndex() {
        Student student = new Student("S101", "Alice", 3);
        student.addGrade(3, 90);  
    }

    // Test calculating the average grade of a student with valid grades
    @Test
    public void testCalculateStudentAverage() {
        Student student = new Student("S102", "Bob", 3);
        student.addGrade(0, 80);
        student.addGrade(1, 90);
        assertEquals("Average grade calculation is incorrect.", 85.0, student.calculateAverage(), 0.01);
    }

    // Test calculating student average when no grades are entered
    @Test(expected = IllegalStateException.class)
    public void testCalculateStudentAverageNoGrades() {
        Student student = new Student("S103", "Charlie", 3);
        student.calculateAverage();  
    }

    // Test calculating the class average with multiple students
    @Test
    public void testCalculateClassAverage() {
        GradeManager manager = new GradeManager();
        Student student1 = new Student("S101", "Alice", 3);
        Student student2 = new Student("S102", "Bob", 3);
        student1.addGrade(0, 80);
        student2.addGrade(0, 90);
        manager.addStudent(student1);
        manager.addStudent(student2);
        assertEquals("Class average calculation is incorrect.", 85.0, manager.calculateClassAverage(), 0.01);
    }

    // Test handling calculation of class average with no students
    @Test(expected = IllegalStateException.class)
    public void testCalculateClassAverageNoStudents() {
        GradeManager manager = new GradeManager();
        manager.calculateClassAverage();  
    }

    // Test calculating class average when some students have no grades
    @Test
    public void testCalculateClassAverageSkippingUngradedStudents() {
        GradeManager manager = new GradeManager();
        Student student1 = new Student("S101", "Alice", 3);
        Student student2 = new Student("S102", "Bob", 3);
        student1.addGrade(0, 80);
        manager.addStudent(student1);
        manager.addStudent(student2);  

        assertEquals("Class average calculation with ungraded student is incorrect.", 
                     80.0, manager.calculateClassAverage(), 0.01);
    }

    // Test retrieving the total number of students in the system
    @Test
    public void testGetTotalStudents() {
        GradeManager manager = new GradeManager();
        manager.addStudent(new Student("S103", "Charlie", 2));
        assertEquals("Total students count is incorrect.", 1, manager.getTotalStudents());
    }

    // Test handling of negative grade values
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeGrade() {
        Student student = new Student("S104", "David", 3);
        student.addGrade(1, -10);  
    }

    // Test handling of grade addition to an invalid course index
    @Test(expected = IllegalArgumentException.class)
    public void testAddGradeToInvalidCourseIndex() {
        Student student = new Student("S105", "Eve", 3);
        student.addGrade(3, 50);  
    }

    // Test retrieving a grade with an invalid negative index
    @Test(expected = IllegalArgumentException.class)
    public void testGetGradeInvalidIndex() {
        Student student = new Student("S106", "Frank", 3);
        student.getGrade(-1);  
    }

    // Test calculating the average grade with a mix of failing and passing grades
    @Test
    public void testCalculateAverageWithMixedGrades() {
        Student student = new Student("S107", "Helen", 3);
        student.addGrade(0, 50);
        student.addGrade(1, 100);
        student.addGrade(2, 0);
        assertEquals("Incorrect average with mixed grades.", 50.0, student.calculateAverage(), 0.01);
    }
}
