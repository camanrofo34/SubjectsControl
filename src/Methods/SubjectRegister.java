package Methods;

import Subjects.LineSubject;
import Subjects.WellfareSubject;
import Users.Student;

import java.util.ArrayList;

public record SubjectRegister(ArrayList<Student> students) implements DiscountAssignment {
    public int returnSubjectCountByLineS(String subject){
        int controlSubjectCount=0;
        for (Student student : students){
            ArrayList<LineSubject> lineSubjects= student.getLineSubjects();
            for (LineSubject lineSubject : lineSubjects){
                if (subject.equalsIgnoreCase(lineSubject.getSubjectName())) controlSubjectCount++;
            }
        }
            return controlSubjectCount;
    }
    public int returnSubjectCountByWellfareS(String subject){
        int controlSubjectCount=0;
        for (Student student : students){
            ArrayList<WellfareSubject> wellfareSubjects= student.getWellfareSubjects();
            for (WellfareSubject wellfareSubject : wellfareSubjects){
                if (subject.equalsIgnoreCase(wellfareSubject.getSubjectName())) controlSubjectCount++;
            }
        }
        return controlSubjectCount;
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
