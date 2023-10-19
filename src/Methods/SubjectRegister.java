package Methods;

import Subjects.LineSubject;
import Subjects.WellfareSubject;
import Users.Student;

import java.util.ArrayList;

public record SubjectRegister(ArrayList<LineSubject> lineSubjects, ArrayList<WellfareSubject> wellfareSubjects, ArrayList<Student> students) {
    public int returnMostSubjectByLineS(){
        //Ask the teacher
        int controlMostSubject=0;
        for (LineSubject lineSubject : lineSubjects){
            int i = 0;
            for (Student student : students){
                ArrayList<LineSubject> lineSubjects1= student.getLineSubjects();
                for (LineSubject lineSubject1 : lineSubjects1){
                    if (lineSubject.getSubjectName().equalsIgnoreCase(lineSubject1.getSubjectName())) i++;
                }
            }
            controlMostSubject= Math.max(i, controlMostSubject);
        }
        return controlMostSubject;
    }

    public int returnMostSubjectByWellfareS(){
        //Ask the teacher
        int controlMostSubject=0;
        for (WellfareSubject wellfareSubject : wellfareSubjects){
            int i = 0;
            for (Student student : students){
                ArrayList<WellfareSubject> wellfareSubjects1= student.getWellfareSubjects();
                for (WellfareSubject wellfareSubject1: wellfareSubjects1){
                    if (wellfareSubject.getSubjectName().equalsIgnoreCase(wellfareSubject1.getSubjectName())) i++;
                }
            }
            controlMostSubject= Math.max(i, controlMostSubject);
        }
        return controlMostSubject;
    }

    public int returnLessSubjectByLineS(){
        //Ask the teacher
        int controlLessSubject=1000;
        for (LineSubject lineSubject : lineSubjects){
            int i = 0;
            for (Student student : students){
                ArrayList<LineSubject> lineSubjects1= student.getLineSubjects();
                for (LineSubject lineSubject1 : lineSubjects1){
                    if (lineSubject.getSubjectName().equalsIgnoreCase(lineSubject1.getSubjectName())) i++;
                }
            }
            controlLessSubject= Math.min(i, controlLessSubject);
        }
        return controlLessSubject;
    }

    public int returnLessSubjectByWellfareS(){
        //Ask the teacher
        int controlLessSubject=1000;
        for (WellfareSubject wellfareSubject : wellfareSubjects){
            int i = 0;
            for (Student student : students){
                ArrayList<WellfareSubject> wellfareSubjects1= student.getWellfareSubjects();
                for (WellfareSubject wellfareSubject1: wellfareSubjects1){
                    if (wellfareSubject.getSubjectName().equalsIgnoreCase(wellfareSubject1.getSubjectName())) i++;
                }
            }
            controlLessSubject= Math.min(i, controlLessSubject);
        }
        return controlLessSubject;
    }




}
