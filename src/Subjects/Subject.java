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

    @Override
    public double assignDiscount() {
        return 0;
    }

    @Override
    public double assignDiscountBySituation(String situation) {
        return 0;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }
}
