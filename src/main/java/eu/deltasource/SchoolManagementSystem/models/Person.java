package eu.deltasource.SchoolManagementSystem.models;

import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode
@ToString
@Getter
public abstract class Person {

    @Setter
    private long id;

    private String firstName;

    private String lastName;

    private String pin;

    private LocalDate dateOfBirth;

    private String phoneNumber;

    public Person(long id, String firstName, String lastName, String pin, LocalDate dateOfBirth, String phoneNumber) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setPIN(pin);
        setDateOfBirth(dateOfBirth);
        setPhoneNumber(phoneNumber);
    }

    public void setFirstName(@NonNull String firstName) {
        if (firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be empty | blank spaces.");
        }
        this.firstName = firstName;
    }

    public void setLastName(@NonNull String lastName) {
        if (lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be empty | blank spaces.");
        }
        this.lastName = lastName;
    }

    public void setPIN(@NonNull String pin) {
        if (pin.isBlank()) {
            throw new IllegalArgumentException("PIN cannot be empty | blank spaces.");
        }
        this.pin = pin;
    }

    public void setDateOfBirth(@NonNull LocalDate dateOfBirth) {
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Enter a valid birth date.");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhoneNumber(@NonNull String phoneNumber) {
        if (phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone number cannot be empty | blank spaces.");
        }
        this.phoneNumber = phoneNumber;
    }
}