package Subjects;

public class Subject implements DiscountAssignment{
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

    @Override
    public double assignDiscount(boolean permission) {
        return 0.8;
    }

    @Override
    public double assignDiscountBySituation(String situation, boolean permission) {
        return 0;
    }
}
