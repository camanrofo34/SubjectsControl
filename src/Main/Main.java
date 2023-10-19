package Main;
import Subjects.LineSubject;
import Subjects.WellfareSubject;
import Users.Student;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Student> students = new ArrayList<Student>();
    static ArrayList<LineSubject> lineSubjects = new ArrayList<LineSubject>();
    static ArrayList<WellfareSubject> wellfareSubjects = new ArrayList<WellfareSubject>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean add = true;
        int idSubject=1;
        double creditValue=3;
        System.out.println("Enter the base subjects for the program: ");
        //Register many subjects
        while (add){
            System.out.println("LineSubject/WellfareSubject (L/W): ");
            String studyLine = scanner.next();
            scanner.nextLine();
            //Register if is a LineSubject
            if (studyLine.equalsIgnoreCase("l")) {
                System.out.println("Name of the Subject: ");
                String subjectName = scanner.next();
                scanner.nextLine();
                System.out.println("Credits of the Subject: ");
                int credits = scanner.nextInt();
                scanner.nextLine();
                double value = credits * creditValue;
                lineSubjects.add(new LineSubject(idSubject, subjectName, "LineSubject", null, credits, value));
                System.out.println("Subject added correctly.");
            }
            //Register if is WellfareSubject
            else if (studyLine.equalsIgnoreCase("w")){
                System.out.println("Name of the Subject: ");
                String subjectName = scanner.next();
                scanner.nextLine();
                System.out.println("Hours of the Subject: ");
                int hours = scanner.nextInt();
                scanner.nextLine();
                wellfareSubjects.add(new WellfareSubject(idSubject, subjectName, "WellfareSubject", null, hours));
                System.out.println("Subject added correctly.");
                }
            //Nothing to register
            else System.out.println("You haven't give an actual value");
            System.out.println("Do you want to add another subject? (Y/N) : ");
            add = (scanner.next().equalsIgnoreCase("y"));
            }
        //Everything is correct
        System.out.println("Base data for Subjects have been created correctly.");
        //Show Menu
        int option= Integer.parseInt(JOptionPane.showInputDialog(null, "Menu Option:\n1. Student Register\n2. Register a Subject by Student\n3. Statistics\n4. Exit Program\n"));
        switch (option){
            case 1:
                StudentRegister();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;
        }
    }
    public static void StudentRegister(){
        System.out.println("Write student's name: ");
        String studentName = scanner.next();
        scanner.nextLine();
        System.out.println("Write student's lastname: ");
        String studentLastName = scanner.next();
        scanner.nextLine();
        System.out.println("Write student's birthday (YYYY/MM/DD): ");
        String studentBirthday = scanner.next();
        scanner.nextLine();
        System.out.println("Write student's email: ");
        String studentEmail = scanner.next();
        scanner.nextLine();
        String [] separatedBirthday = studentBirthday.split("/");
        String id=separatedBirthday[0]+studentName+separatedBirthday[2];
        students.add(new Student(id, studentName, studentLastName,studentBirthday,studentEmail,null, null));
        System.out.println("Student have been registered correctly.");
        System.out.println("Your ID is: "+id+".");
    }

    public static void RegisterSubjectByStudent(){
        System.out.println("Write student's ID: ");
        String studentId = scanner.next();
        scanner.nextLine();
        Student student = SearchStudentById(studentId);
        System.out.println("LineSubject/WellfareSubject (L/W): ");
        String subjectLine = scanner.next();
        System.out.println("Search Subject by name: ");
        String subjectName = scanner.next();
        scanner.nextLine();
        if (subjectLine.equalsIgnoreCase("l")){
            LineSubject lineSubject= SearchLineSByName(subjectName);
        }
        else if (subjectLine.equalsIgnoreCase("w")){
            WellfareSubject wellfareSubject= SearchWellfareSByName(subjectName);
        }
        else ;



    }


}
