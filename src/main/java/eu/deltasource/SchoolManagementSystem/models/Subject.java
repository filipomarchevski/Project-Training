package eu.deltasource.SchoolManagementSystem.models;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
@ToString
public class Subject {

    @Getter
    @Setter
    private int level;

    @Getter
    private String name;

    @Getter
    @Setter
    @NonNull
    private Teacher leadTeacher;

    private final Set<Teacher> substituteTeachers = new HashSet<>();

    private final Set<Student> studentsInSubject = new HashSet<>();

    public Subject(int level, String name, Teacher leadTeacher) {
        setLevel(level);
        setName(name);
        setLeadTeacher(leadTeacher);
    }

    public void setName(@NonNull String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty | blank spaces.");
        }
        this.name = name;
    }

    public void addSubstituteTeacher(@NonNull Teacher teacher) {
        substituteTeachers.add(teacher);
    }

    public void removeSubstituteTeacher(long teacherId) {
        substituteTeachers.removeIf(teacher -> teacher.getId() == teacherId);
    }

    public boolean hasSubstituteTeacher(long teacherId) {
        for (Teacher teacher : substituteTeachers) {
            if (teacher.getId() == teacherId) return true;
        }
        return false;
    }

    public void addStudent(@NonNull Student student) {
        studentsInSubject.add(student);
    }

    public void removeStudent(long studentId) {
        studentsInSubject.removeIf(student -> student.getId() == studentId);
    }

    public boolean hasStudent(long studentId) {
        for (Student student : studentsInSubject) {
            if (student.getId() == studentId) return true;
        }
        return false;
    }
}