package Subjects;

public abstract class Subject implements DiscountAssignment{
    int id;
    String subjectName, studyLine, registeredDate;

    public Subject(int id, String subjectName, String studyLine, String registeredDate) {
        this.id = id;
        this.subjectName = subjectName;
        this.studyLine = studyLine;
        this.registeredDate = registeredDate;
    }
}
