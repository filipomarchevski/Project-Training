package eu.deltasource.SchoolManagementSystem.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentTest {

    @Test
    void addSubjectShouldCorrectlyAddSubjectToList() {
        Student student = new Student(123, "Petar", "Beron", "1234", LocalDate.of(1555,5,5), "12345", new SchoolClass("12-a"));
        Teacher teacher = new Teacher(1, "Boyko", "Borisov", "1234568", LocalDate.of(1555, 5, 5), "0877");
        Subject subject = new Subject(1, "Math", teacher);

        // When
        student.addSubject(subject);

        // Then
        assertTrue(student.hasSubject(1, "Math"));
    }

    @Test
    void removeSubjectShouldCorrectlyRemoveSubjectFromList() {
        // When
        Student student = new Student(123, "Petar", "Beron", "1234", LocalDate.of(1555,5,5), "12345", new SchoolClass("12-a"));
        Teacher teacher = new Teacher(1, "Boyko", "Borisov", "1234568", LocalDate.of(1555, 5, 5), "0877");
        Subject subject = new Subject(1, "Math", teacher);
        student.addSubject(subject);

        // When
        student.removeSubject(1, "Math");

        // Then
        assertFalse(student.hasSubject(1, "Math"));
    }

    @Test
    void hasSubjectShouldReturnTrueIfThereIsSubjectPresentInList() {
        // When
        Student student = new Student(123, "Petar", "Beron", "1234", LocalDate.of(1555,5,5), "12345", new SchoolClass("12-a"));
        Teacher teacher = new Teacher(1, "Boyko", "Borisov", "1234568", LocalDate.of(1555, 5, 5), "0877");
        Subject subject = new Subject(1, "Math", teacher);
        student.addSubject(subject);

        // When
        boolean hasSubject = student.hasSubject(1, "Math");

        // Then
        assertTrue(hasSubject);
    }

    @Test
    void hasSubjectShouldReturnFalseIfThereIsNoSubjectPresentInList() {
        // When
        Student student = new Student(123, "Petar", "Beron", "1234", LocalDate.of(1555,5,5), "12345", new SchoolClass("12-a"));
        Teacher teacher = new Teacher(1, "Boyko", "Borisov", "1234568", LocalDate.of(1555, 5, 5), "0877");
        Subject subject = new Subject(1, "Math", teacher);
        student.addSubject(subject);
        student.removeSubject(1, "Math");

        // When
        boolean hasSubject = student.hasSubject(1, "Math");

        // Then
        assertFalse(hasSubject);
    }
}