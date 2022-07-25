package eu.deltasource.SchoolManagementSystem.models;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
@ToString
public class Teacher extends Person {

    private final Set<Subject> leadingSubjects = new HashSet<>();

    private final Set<Subject> substituteSubjects = new HashSet<>();

    public Teacher(int id, String firstName, String lastName, String pin, LocalDate dateOfBirth, String phoneNumber) {
        super(id, firstName, lastName, pin, dateOfBirth, phoneNumber);
    }

    public void addLeadingSubject(@NonNull Subject subject) {
        leadingSubjects.add(subject);
    }

    public void removeLeadingSubject(int subjectLevel, @NonNull String subjectName) {
        leadingSubjects.removeIf(subject -> subject.getLevel() == subjectLevel && subject.getName().equals(subjectName));
    }

    public boolean hasLeadingSubject(int subjectLevel, @NonNull String subjectName) {
        for (Subject subject : leadingSubjects) {
            if (subject.getLevel() == subjectLevel && subject.getName().equals(subjectName)) return true;
        }
        return false;
    }

    public void addSubstituteSubject(@NonNull Subject subject) {
        substituteSubjects.add(subject);
    }

    public void removeSubstituteSubject(int subjectLevel, @NonNull String subjectName) {
        substituteSubjects.removeIf(subject -> subject.getLevel() == subjectLevel && subject.getName().equals(subjectName));
    }

    public boolean hasSubstituteSubject(int subjectLevel, @NonNull String subjectName) {
        for (Subject subject : substituteSubjects) {
            if (subject.getLevel() == subjectLevel && subject.getName().equals(subjectName)) return true;
        }
        return false;
    }
}