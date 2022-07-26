package eu.deltasource.SchoolManagementSystem.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonTest {

    @Test
    void illegalArgumentExceptionShouldBeThrownWhenInstantiatingWithEmptyFirstName() {
        // Given

        // When
        Executable creatingAnInstanceWithEmptyFirstName = () -> {
            new Student(123, "", "lastName", "pin", LocalDate.of(1955, 5, 5), "0877", new SchoolClass("12-a"));
        };

        // Then
        assertThrows(IllegalArgumentException.class, creatingAnInstanceWithEmptyFirstName, "IllegalArgumentException should have been thrown, given empty first name.");
    }

    @Test
    void illegalArgumentExceptionShouldBeThrownWhenInstantiatingWithBlankFirstName() {
        // Given

        // When
        Executable creatingAnInstanceWithBlankFirstName = () -> {
            new Student(123, "   ", "lastName", "pin", LocalDate.of(1955, 5, 5), "0877", new SchoolClass("12-a"));
        };

        // Then
        assertThrows(IllegalArgumentException.class, creatingAnInstanceWithBlankFirstName, "IllegalArgumentException should have been thrown, given blank first name.");
    }

    @Test
    void illegalArgumentExceptionShouldBeThrownWhenInstantiatingWithEmptyLastName() {
        // Given

        // When
        Executable creatingAnInstanceWithEmptyLastName = () -> {
            new Student(123, "firstName", "", "pin", LocalDate.of(1955, 5, 5), "0877", new SchoolClass("12-a"));
        };

        // Then
        assertThrows(IllegalArgumentException.class, creatingAnInstanceWithEmptyLastName, "IllegalArgumentException should have been thrown, given empty last name.");
    }

    @Test
    void illegalArgumentExceptionShouldBeThrownWhenInstantiatingWithBlankLastName() {
        // Given

        // When
        Executable creatingAnInstanceWithBlankLastName = () -> {
            new Student(123, "firstName", "   ", "pin", LocalDate.of(1955, 5, 5), "0877", new SchoolClass("12-a"));
        };

        // Then
        assertThrows(IllegalArgumentException.class, creatingAnInstanceWithBlankLastName, "IllegalArgumentException should have been thrown, given blank last name.");
    }

    @Test
    void illegalArgumentExceptionShouldBeThrownWhenInstantiatingWithEmptyPin() {
        // Given

        // When
        Executable creatingAnInstanceWithEmptyPin = () -> {
            new Student(123, "firstName", "lastName", "", LocalDate.of(1955, 5, 5), "0877", new SchoolClass("12-a"));
        };

        // Then
        assertThrows(IllegalArgumentException.class, creatingAnInstanceWithEmptyPin, "IllegalArgumentException should have been thrown, given empty pin.");
    }

    @Test
    void illegalArgumentExceptionShouldBeThrownWhenInstantiatingWithBlankPin() {
        // Given

        // When
        Executable creatingAnInstanceWithBlankPin = () -> {
            new Student(123, "firstName", "lastName", "  ", LocalDate.of(1955, 5, 5), "0877", new SchoolClass("12-a"));
        };

        // Then
        assertThrows(IllegalArgumentException.class, creatingAnInstanceWithBlankPin, "IllegalArgumentException should have been thrown, given blank pin.");
    }


    @Test
    void illegalArgumentExceptionShouldBeThrownWhenInstantiatingWithEmptyPhoneNumber() {
        // Given

        // When
        Executable creatingAnInstanceWithEmptyPhoneNumber = () -> {
            new Student(123, "firstName", "lastName", "pin", LocalDate.of(1955, 5, 5), "", new SchoolClass("12-a"));
        };

        // Then
        assertThrows(IllegalArgumentException.class, creatingAnInstanceWithEmptyPhoneNumber, "IllegalArgumentException should have been thrown, given empty phone number.");
    }

    @Test
    void illegalArgumentExceptionShouldBeThrownWhenInstantiatingWithBlankPhoneNumber() {
        // Given

        // When
        Executable creatingAnInstanceWithBlankPhoneNumber = () -> {
            new Student(123, "firstName", "lastName", "pin", LocalDate.of(1955, 5, 5), "  ", new SchoolClass("12-a"));
        };

        // Then
        assertThrows(IllegalArgumentException.class, creatingAnInstanceWithBlankPhoneNumber, "IllegalArgumentException should have been thrown, given blank phone number.");
    }

    @Test
    void illegalArgumentExceptionShouldBeThrownWhenInstantiatingWithBirthDateBeingInTheFuture() {
        // Given

        // When
        Executable creatingAnInstanceWithFutureBirthDate = () -> {
            new Student(123, "firstName", "lastName", "pin", LocalDate.of(2025, 5, 5), "  ", new SchoolClass("12-a"));
        };

        // Then
        assertThrows(IllegalArgumentException.class, creatingAnInstanceWithFutureBirthDate, "IllegalArgumentException should have been thrown, given a birth date in the future.");
    }
}