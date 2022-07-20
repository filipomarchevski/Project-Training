package models;

import lombok.*;
import utilityclasses.DataValidator;

import java.util.List;

@Data
public class Teacher {

    @NonNull
    private PersonalData personalData;

    private List<SchoolClass> leadClasses;

    private List<SchoolClass> subClasses;

    public Teacher(PersonalData personalData, List<SchoolClass> leadClasses, List<SchoolClass> subClasses) {
        setPersonalData(personalData);
        setLeadClasses(leadClasses);
        setSubClasses(subClasses);
    }

    public void setLeadClasses(@NonNull List<SchoolClass> leadClasses) {
        DataValidator.validateListDoesNotContainNullElements(leadClasses);
        this.leadClasses = leadClasses;
    }

    public void setSubClasses(@NonNull List<SchoolClass> subClasses) {
        DataValidator.validateListDoesNotContainNullElements(leadClasses);
        this.subClasses = subClasses;
    }
}