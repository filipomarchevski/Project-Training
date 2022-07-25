package eu.deltasource.SchoolManagementSystem.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SubjectTest {

    @Test
    void illegalArgumentExceptionShouldBeThrownWhenInstantiatedWithEmptyName() {
        // Given
        Teacher teacher = new Teacher(123, "Boyko", "Borisov", "1234568", LocalDate.of(1555, 5, 5), "087745");

        // When
        Executable instantiatingWithEmptyName = () -> new Subject(1, "", teacher);

        // Then
        assertThrows(IllegalArgumentException.class, instantiatingWithEmptyName, "IllegalArgumentException should have been thrown, given empty name.");
    }

    @Test
    void illegalArgumentExceptionShouldBeThrownWhenInstantiatedWithBlankName() {
        // Given
        Teacher teacher = new Teacher(123, "Boyko", "Borisov", "1234568", LocalDate.of(1555, 5, 5), "087745");

        // When
        Executable instantiatingWithBlankName = () -> new Subject(1, "  ", teacher);

        // Then
        assertThrows(IllegalArgumentException.class, instantiatingWithBlankName, "IllegalArgumentException should have been thrown, given blank name.");
    }

    @Test
    void addSubstituteTeacherShouldCorrectlyAddTeacherToList() {
        // Given
        Teacher teacher = new Teacher(123, "Boyko", "Borisov", "1234568", LocalDate.of(1555, 5, 5), "087745");
        Subject subject = new Subject(1, "Math", teacher);

        // When
        subject.addSubstituteTeacher(teacher);

        // Then
        assertTrue(subject.hasSubstituteTeacher(123));
    }

    @Test
    void removeSubstituteTeacherShouldCorrectlyRemoveTeacherFromList() {
        // Given
        Teacher teacher = new Teacher(123, "Boyko", "Borisov", "1234568", LocalDate.of(1555, 5, 5), "087745");
        Subject subject = new Subject(1, "Math", teacher);
        subject.addSubstituteTeacher(teacher);

        // When
        subject.removeSubstituteTeacher(123);

        // Then
        assertFalse(subject.hasSubstituteTeacher(123));
    }

    @Test
    void hasSubstituteTeacherShouldReturnTrueIfTeacherIsPresentInList() {
        // Given
        Teacher teacher = new Teacher(123, "Boyko", "Borisov", "1234568", LocalDate.of(1555, 5, 5), "087745");
        Subject subject = new Subject(1, "Math", teacher);
        subject.addSubstituteTeacher(teacher);

        // When
        boolean hasSubstituteTeacher = subject.hasSubstituteTeacher(123);

        // Then
        assertTrue(hasSubstituteTeacher);
    }

    @Test
    void hasSubstituteTeacherShouldReturnFalseIfTeacherIsNotPresentInList() {
        // Given
        Teacher teacher = new Teacher(123, "Boyko", "Borisov", "1234568", LocalDate.of(1555, 5, 5), "087745");
        Subject subject = new Subject(1, "Math", teacher);

        subject.addSubstituteTeacher(teacher);
        subject.removeSubstituteTeacher(123);

        // When
        boolean hasSubstituteTeacher = subject.hasSubstituteTeacher(123);

        // Then
        assertFalse(hasSubstituteTeacher);
    }

    @Test
    void addStudentShouldCorrectlyAddStudentToList() {
        // Given
        Student student = new Student(123, "Petar", "Beron", "1234", LocalDate.of(1555, 5, 5), "12345", new SchoolClass("12-a"));
        Teacher teacher = new Teacher(123, "Boyko", "Borisov", "1234568", LocalDate.of(1555, 5, 5), "087745");
        Subject subject = new Subject(1, "Math", teacher);

        // When
        subject.addStudent(student);

        // Then
        assertTrue(subject.hasStudent(123));
    }

    @Test
    void removeStudentShouldCorrectlyRemoveStudentFromList() {
        // Given
        Student student = new Student(123, "Petar", "Beron", "1234", LocalDate.of(1555, 5, 5), "12345", new SchoolClass("12-a"));
        Teacher teacher = new Teacher(123, "Boyko", "Borisov", "1234568", LocalDate.of(1555, 5, 5), "087745");
        Subject subject = new Subject(1, "Math", teacher);
        subject.addStudent(student);

        // When
        subject.removeStudent(123);

        // Then
        assertFalse(subject.hasStudent(123));
    }

    @Test
    void hasStudentShouldReturnTrueIfStudentIsPresentInList() {
        // Given
        Student student = new Student(123, "Petar", "Beron", "1234", LocalDate.of(1555, 5, 5), "12345", new SchoolClass("12-a"));
        Teacher teacher = new Teacher(123, "Boyko", "Borisov", "1234568", LocalDate.of(1555, 5, 5), "087745");
        Subject subject = new Subject(1, "Math", teacher);
        subject.addStudent(student);

        // When
        boolean hasStudent = subject.hasStudent(123);

        // Then
        assertTrue(hasStudent);
    }

    @Test
    void hasStudentShouldReturnFalseIfStudentIsNotPresentInList() {
        // Given
        Student student = new Student(123, "Petar", "Beron", "1234", LocalDate.of(1555, 5, 5), "12345", new SchoolClass("12-a"));
        Teacher teacher = new Teacher(123, "Boyko", "Borisov", "1234568", LocalDate.of(1555, 5, 5), "087745");
        Subject subject = new Subject(1, "Math", teacher);
        subject.addStudent(student);
        subject.removeStudent(123);

        // When
        boolean hasStudent = subject.hasStudent(123);

        // Then
        assertFalse(hasStudent);
    }
}