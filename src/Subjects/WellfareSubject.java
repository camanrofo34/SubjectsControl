package Subjects;

public class WellfareSubject extends Subject{
    int hours;

    public WellfareSubject(int id, String subjectName, String studyLine, String registeredDate, int hours) {
        super(id, subjectName, studyLine, registeredDate);
        this.hours = hours;
    }

    @Override
    public double assignDiscount() {
        return 0;
    }

    @Override
    public double assignDiscountBySituation(String situation) {
        return 0;
    }
}
