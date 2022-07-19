package models;

import lombok.*;
import utilityclasses.DataValidator;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PersonalData {

    @Setter(AccessLevel.NONE)
    private String firstName;

    @Setter(AccessLevel.NONE)
    private String lastName;

    @Setter(AccessLevel.NONE)
    private String PIN;

    @Setter(AccessLevel.NONE)
    private LocalDate dateOfBirth;

    private long phoneNumber;

    public void setFirstName(String firstName) {
        DataValidator.validateString(firstName);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        DataValidator.validateString(lastName);
        this.lastName = lastName;
    }

    public void setPIN(String PIN) {
        DataValidator.validateString(lastName);
        this.PIN = PIN;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DataValidator.validateDate(dateOfBirth);
        this.dateOfBirth = dateOfBirth;
    }
}
