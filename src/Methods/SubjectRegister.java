package Methods;

import Subjects.LineSubject;
import Subjects.WellfareSubject;

import java.util.ArrayList;

public record SubjectRegister(ArrayList<String> subjectsName, ArrayList<LineSubject> lineSubjects, ArrayList<WellfareSubject> wellfareSubjects) {
    public int countRegisteredBySubject(){
        return 0;
    }


}
