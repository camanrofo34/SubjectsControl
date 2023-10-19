package Subjects;

public class WellfareSubject extends Subject{
    int hours;

    public WellfareSubject(int id, String subjectName, String studyLine, String registeredDate, int hours) {
        super(id, subjectName, studyLine, registeredDate);
        this.hours = hours;
    }

}
