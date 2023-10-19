package Users;

import java.util.ArrayList;

public class Student extends Person{
    ArrayList lineSubjects = new ArrayList<>();
    ArrayList wellfareSubjects = new ArrayList<>();

    public Student(String id, String name, String lastName, String birthday, String mail, ArrayList lineSubjects, ArrayList wellfareSubjects) {
        super(id, name, lastName, birthday, mail);
        this.lineSubjects = lineSubjects;
        this.wellfareSubjects = wellfareSubjects;
    }

    public ArrayList getLineSubjects() {
        return lineSubjects;
    }

    public void setLineSubjects(ArrayList lineSubjects) {
        this.lineSubjects = lineSubjects;
    }

    public ArrayList getWellfareSubjects() {
        return wellfareSubjects;
    }

}
