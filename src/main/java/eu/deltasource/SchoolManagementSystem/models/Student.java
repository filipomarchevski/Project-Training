package eu.deltasource.SchoolManagementSystem.models;

import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@ToString
@EqualsAndHashCode
public class Student extends Person {

    @NonNull
    @Getter
    @Setter
    private SchoolClass schoolClass;

    private final Set<Subject> subjects = new HashSet<>();

    public Student(int id, String firstName, String lastName, String pin, LocalDate dateOfBirth, String phoneNumber, SchoolClass schoolClass) {
        super(id, firstName, lastName, pin, dateOfBirth, phoneNumber);
        setSchoolClass(schoolClass);
    }

    public void addSubject(@NonNull Subject subject) {
        subjects.add(subject);
    }

    public void removeSubject(int level, @NonNull String subjectName) {
        subjects.removeIf(subject -> subject.getName().equals(subjectName) || subject.getLevel() == level);
    }

    public boolean hasSubject(int level, @NonNull String subjectName) {
        for (Subject subject : subjects) {
            if ((subject.getLevel() == level) && subject.getName().equals(subjectName)) {
                return true;
            }
        }
        return false;
    }
}