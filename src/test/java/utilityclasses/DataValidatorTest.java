package utilityclasses;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataValidatorTest {

    @Test
    void validateStringShouldThrowIllegalArgumentExceptionIfGivenStringIsEmpty() {
        // Given

        // When
        Executable validatingAnEmptyString = () -> DataValidator.validateString("");

        // Then
        assertThrows(IllegalArgumentException.class, validatingAnEmptyString, "'DateValidator.validateString()' should have thrown an exception when the string is empty.");
    }

    @Test
    void validateStringShouldThrowIllegalArgumentExceptionIfGivenStringIsBlank() {
        // Given

        // When
        Executable validatingABlankString = () -> DataValidator.validateString("   ");

        // Then
        assertThrows(IllegalArgumentException.class, validatingABlankString, "'DateValidator.validateString() should have thrown an exception when the string is blank.");
    }

    @Test
    void validateDateShouldThrowIllegalArgumentExceptionIfTheDateIsAfterThePresent() {
        // Given
        LocalDate dateInFuture = LocalDate.now().plusYears(1);

        // When
        Executable validatingADateInTheFuture = () -> DataValidator.validateDate(dateInFuture);

        // Then
        assertThrows(IllegalArgumentException.class, validatingADateInTheFuture, "'DateValidator.validateDate' should have thrown an exception when the date is after the present.");
    }

    @Test
    void validateListDoesNotContainNullElementsShouldThrowNullPointerExceptionIfAnNullElementIsPresentInTheList() {
        // Given
        List listWithNullElement = Arrays.asList(new Object(), null, new Object(), null);

        // When
        Executable validatingAListWithNullElement = () -> DataValidator.validateListDoesNotContainNullElements(listWithNullElement);

        // Then
        assertThrows(NullPointerException.class, validatingAListWithNullElement, "'DataValidator.validateListDoesNotContainNullElements()' should have thrown an exception when there is a null element in the list.");
    }

    @Test
    void validateDateIsMoreThanSevenYearsBeforeTheCurrentDay() {
        // Given
        LocalDate dateSixYearsBeforeTheCurrentDay = LocalDate.now().minusYears(6);

        // When
        Executable validatingADateLessThanSevenYearsInThePast = () -> DataValidator.validateDate(dateSixYearsBeforeTheCurrentDay);

        // Then
        assertThrows(IllegalArgumentException.class, validatingADateLessThanSevenYearsInThePast, "'DataValidator.validateDate' should have thrown an exception when the date is less than 7 years before the current date.");
    }
}