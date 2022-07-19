package models;

import lombok.Data;
import lombok.NonNull;

@Data
public class Student {

    @NonNull
    private PersonalData personalData;

    @NonNull
    private SchoolClass schoolClass;
}
