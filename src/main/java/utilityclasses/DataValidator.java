package utilityclasses;

import java.time.LocalDate;
import java.util.List;

public final class DataValidator {

    public static void validateString(String text) {
        validateStringNotBlank(text);
    }

    /**
     * If the date is less than 7 years before the present, it will throw an exception.
     */
    public static void validateDate(LocalDate date) {
        validateDateIsNotInFuture(date);
        validateDateIsInCorrectDiapason(date, LocalDate.now().minusYears(7));
    }

    public static void validateListDoesNotContainNullElements(List list) {
        if (list.contains(null)) {
            throw new NullPointerException("The list contains a null value.");
        }
    }

    private static void validateStringNotBlank(String text) {
        if (text.isBlank()) {
            throw new IllegalArgumentException("Tbe value can't be a blank string.");
        }
    }

    private static void validateDateIsNotInFuture(LocalDate date) {
        if (date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("The date must be in the past.");
        }
    }

    private static void validateDateIsInCorrectDiapason(LocalDate dateToValidate, LocalDate referenceDate) {
        if (dateToValidate.isAfter(referenceDate)) {
            throw new IllegalArgumentException("The date must be before " + referenceDate.toString());
        }
    }
}