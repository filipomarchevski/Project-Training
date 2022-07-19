package models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;
import utilityclasses.DataValidator;

import java.util.List;

@Data
public class SchoolClass {

    @Setter(AccessLevel.NONE)
    private String name;

    @NonNull
    private List<Teacher> leadTeachers;

    @NonNull
    private List<Teacher> subTeachers;

    @NonNull
    private List<Student> students;

    public SchoolClass(String name, @NonNull List<Teacher> leadTeachers, @NonNull List<Teacher> subTeachers, @NonNull List<Student> students) {
        setName(name);
        this.leadTeachers = leadTeachers;
        this.subTeachers = subTeachers;
        this.students = students;
    }

    public void setName(String name) {
        DataValidator.validateString(name);
        this.name = name;
    }
}