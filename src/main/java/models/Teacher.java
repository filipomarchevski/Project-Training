package models;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class Teacher {

    @NonNull
    private PersonalData personalData;

    @NonNull
    private List<SchoolClass> leadClasses;

    @NonNull
    private List<SchoolClass> subClasses;
}
