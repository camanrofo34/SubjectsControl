package Subjects;

import Methods.DiscountAssignment;

public class Subject {
    int id;
    String subjectName, studyLine, registeredDate;

    public Subject(int id, String subjectName, String studyLine, String registeredDate) {
        this.id = id;
        this.subjectName = subjectName;
        this.studyLine = studyLine;
        this.registeredDate = registeredDate;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }
}
