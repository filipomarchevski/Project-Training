package models;

import lombok.Data;
import lombok.NonNull;
import utilityclasses.DataValidator;

import java.util.List;

@Data
public class SchoolClass {

    private String name;

    private List<Teacher> leadTeachers;

    private List<Teacher> subTeachers;

    private List<Teacher> students;

    public SchoolClass(String name, @NonNull List<Teacher> leadTeachers, @NonNull List<Teacher> subTeachers, @NonNull List<Teacher> students) {
        setName(name);
        setLeadTeachers(leadTeachers);
        setSubTeachers(subTeachers);
        setStudents(students);
    }

    public void setName(String name) {
        DataValidator.validateString(name);
        this.name = name;
    }

    public void setLeadTeachers(@NonNull List<Teacher> leadTeachers) {
        DataValidator.validateListDoesNotContainNullElements(leadTeachers);
        this.leadTeachers = leadTeachers;
    }

    public void setSubTeachers(@NonNull List<Teacher> subTeachers) {
        DataValidator.validateListDoesNotContainNullElements(subTeachers);
        this.subTeachers = subTeachers;
    }

    public void setStudents(@NonNull List<Teacher> students) {
        DataValidator.validateListDoesNotContainNullElements(students);
        this.students = students;
    }
}