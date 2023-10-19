package Subjects;

public class LineSubject extends Subject{
    int credits;
    double value;

    public LineSubject(int id, String subjectName, String studyLine, String registeredDate, int credits, double value) {
        super(id, subjectName, studyLine, registeredDate);
        this.credits = credits;
        this.value = value;
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
