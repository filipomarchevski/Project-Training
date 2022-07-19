package utilityclasses;

import lombok.NonNull;

import java.time.LocalDate;

public final class DataValidator {

    public static void validateString(String text) {
        validateStringNotEmpty(text);
    }

    public static void validateDate(@NonNull LocalDate date) {
        validateDateIsNotInFuture(date);
    }

    private static void validateStringNotEmpty(String text) {
        if (text.isEmpty()) {
            throw new IllegalArgumentException("The value can't be an empty string.");
        }
        validateStringNotBlank(text);
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
}