package models;

import lombok.*;

import static utilityclasses.DataValidator.*;

import java.time.LocalDate;

@Data
public class PersonalData {

    private String firstName;

    private String lastName;

    private String PIN;

    private LocalDate dateOfBirth;

    private long phoneNumber;

    public PersonalData(String firstName, String lastName, String PIN, LocalDate dateOfBirth, long phoneNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setPIN(PIN);
        setDateOfBirth(dateOfBirth);
        setPhoneNumber(phoneNumber);
    }

    public void setFirstName(@NonNull String firstName) {
        validateString(firstName);
        this.firstName = firstName;
    }

    public void setLastName(@NonNull String lastName) {
        validateString(lastName);
        this.lastName = lastName;
    }

    public void setPIN(@NonNull String PIN) {
        validateString(lastName);
        this.PIN = PIN;
    }

    public void setDateOfBirth(@NonNull LocalDate dateOfBirth) {
        validateDate(dateOfBirth);
        this.dateOfBirth = dateOfBirth;
    }
}