package eu.deltasource.SchoolManagementSystem.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    @Test
    void addLeadingSubjectShouldCorrectlyAddSubjectToList() {
        // Given
        Teacher teacher = new Teacher(1, "Boyko", "Borisov", "1234568", LocalDate.of(1555, 5, 5), "087745");
        Subject subject = new Subject(1, "Math", teacher);

        // When
        teacher.addLeadingSubject(subject);

        // Then
        assertTrue(teacher.hasLeadingSubject(1, "Math"));
    }

    @Test
    void removeLeadingSubjectShouldCorrectlyRemoveSubjectFromList() {
        // Given
        Teacher teacher = new Teacher(1, "Boyko", "Borisov", "1234568", LocalDate.of(1555, 5, 5), "087745");
        Subject subject = new Subject(1, "Math", teacher);
        teacher.addLeadingSubject(subject);

        // When
        teacher.removeLeadingSubject(1, "Math");

        // Then
        assertFalse(teacher.hasLeadingSubject(1, "Math"));
    }

    @Test
    void hasLeadingSubjectShouldReturnTrueIfASubjectIsPresentInTheList() {
        // Given
        Teacher teacher = new Teacher(1, "Boyko", "Borisov", "1234568", LocalDate.of(1555, 5, 5), "087745");
        Subject subject = new Subject(1, "Math", teacher);
        teacher.addLeadingSubject(subject);

        // When
        boolean hasLeadingSubject = teacher.hasLeadingSubject(1, "Math");

        // Then
        assertTrue(hasLeadingSubject);
    }

    @Test
    void hasLeadingSubjectShouldReturnFalseIfASubjectIsNotPresentInTheList() {
        // Given
        Teacher teacher = new Teacher(1, "Boyko", "Borisov", "1234568", LocalDate.of(1555, 5, 5), "087745");
        Subject subject = new Subject(1, "Math", teacher);
        teacher.addLeadingSubject(subject);
        teacher.removeLeadingSubject(1, "Math");

        // When
        boolean hasLeadingSubject = teacher.hasLeadingSubject(1, "Math");

        // Then
        assertFalse(hasLeadingSubject);
    }

    @Test
    void addSubstituteSubjectShouldCorrectlyAddSubjectToList() {
        // Given
        Teacher teacher = new Teacher(1, "Boyko", "Borisov", "1234568", LocalDate.of(1555, 5, 5), "087745");
        Subject subject = new Subject(1, "Math", teacher);

        // When
        teacher.addSubstituteSubject(subject);

        // Then
        assertTrue(teacher.hasSubstituteSubject(1, "Math"));
    }

    @Test
    void removeSubstituteSubjectShouldCorrectlyRemoveSubjectFromList() {
        // Given
        Teacher teacher = new Teacher(1, "Boyko", "Borisov", "1234568", LocalDate.of(1555, 5, 5), "087745");
        Subject subject = new Subject(1, "Math", teacher);
        teacher.addSubstituteSubject(subject);

        // When
        teacher.removeSubstituteSubject(1, "Math");

        // Then
        assertFalse(teacher.hasSubstituteSubject(1, "Math"));
    }

    @Test
    void hasSubstituteSubjectShouldReturnTrueIfASubjectIsPresentInTheList() {
        // Given
        Teacher teacher = new Teacher(1, "Boyko", "Borisov", "1234568", LocalDate.of(1555, 5, 5), "087745");
        Subject subject = new Subject(1, "Math", teacher);
        teacher.addSubstituteSubject(subject);

        // When
        boolean hasSubstituteSubject = teacher.hasSubstituteSubject(1, "Math");

        // Then
        assertTrue(hasSubstituteSubject);
    }

    @Test
    void hasSubstituteSubjectShouldReturnFalseIfASubjectIsNotPresentInTheList() {
        // Given
        Teacher teacher = new Teacher(1, "Boyko", "Borisov", "1234568", LocalDate.of(1555, 5, 5), "087745");
        Subject subject = new Subject(1, "Math", teacher);
        teacher.addSubstituteSubject(subject);
        teacher.removeSubstituteSubject(1, "Math");

        // When
        boolean hasSubstituteSubject = teacher.hasSubstituteSubject(1, "Math");

        // Then
        assertFalse(hasSubstituteSubject);
    }
}