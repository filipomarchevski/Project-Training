package eu.deltasource.SchoolManagementSystem.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SchoolClassTest {

    @Test
    void illegalArgumentExceptionShouldBeThrownWhenInstantiatedWithEmptyName() {
        // Given

        // When
        Executable instantiatingWithEmptyName = () -> new SchoolClass("");

        // Then
        assertThrows(IllegalArgumentException.class, instantiatingWithEmptyName, "IllegalArgumentException should have been thrown, given empty name.");
    }

    @Test
    void illegalArgumentExceptionShouldBeThrownWhenInstantiatedWithBlankName() {
        // Given

        // When
        Executable instantiatingWithBlankName = () -> new SchoolClass("   ");

        // Then
        assertThrows(IllegalArgumentException.class, instantiatingWithBlankName, "IllegalArgumentException should have been thrown, given blank name.");
    }

    @Test
    void addStudentShouldCorrectlyAddStudentToList() {
        // Given
        Student student = new Student(123, "Petar", "Beron", "1234", LocalDate.of(1555, 5, 5), "12345", new SchoolClass("12-a"));
        SchoolClass schoolClass = new SchoolClass("12-a");

        // When
        schoolClass.addStudent(student);

        // Then
        assertTrue(schoolClass.hasStudent(123));
    }

    @Test
    void removeStudentShouldCorrectlyRemoveStudentFromList() {
        // Given
        Student student = new Student(123, "Petar", "Beron", "1234", LocalDate.of(1555, 5, 5), "12345", new SchoolClass("12-a"));
        SchoolClass schoolClass = new SchoolClass("12-a");
        schoolClass.addStudent(student);

        // When
        schoolClass.removeStudent(123);

        // Then

        assertFalse(schoolClass.hasStudent(123));
    }

    @Test
    void hasStudentShouldReturnTrueIfThereIsStudentPresentInList() {
        // Given
        Student student = new Student(123, "Petar", "Beron", "1234", LocalDate.of(1555, 5, 5), "12345", new SchoolClass("12-a"));
        SchoolClass schoolClass = new SchoolClass("12-a");
        schoolClass.addStudent(student);

        // When
        boolean hasStudent = schoolClass.hasStudent(123);

        // Then
        assertTrue(hasStudent);
    }

    @Test
    void hasStudentShouldReturnFalseIfThereIsNoStudentPresentInList() {
        // Given
        Student student = new Student(123, "Petar", "Beron", "1234", LocalDate.of(1555, 5, 5), "12345", new SchoolClass("12-a"));
        SchoolClass schoolClass = new SchoolClass("12-a");
        schoolClass.addStudent(student);
        schoolClass.removeStudent(123);

        // When
        boolean hasStudent = schoolClass.hasStudent(123);

        // Then
        assertFalse(hasStudent);
    }
}