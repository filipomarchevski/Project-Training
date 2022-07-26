package eu.deltasource.SchoolManagementSystem.models;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
public class SchoolClass {

    private String name;

    private final List<Student> students = new ArrayList<>();

    public SchoolClass(String name) {
        setName(name);
    }

    public void setName(@NonNull String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty | blank spaces.");
        }
        this.name = name;
    }

    public void addStudent(@NonNull Student student) {
        students.add(student);
    }

    public void removeStudent(long id) {
        students.removeIf(student -> student.getId() == id);
    }

    public boolean hasStudent(long id) {
        for (Student student : students) {
            if (student.getId() == id) return true;
        }
        return false;
    }
}