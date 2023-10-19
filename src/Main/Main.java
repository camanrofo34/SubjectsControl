package Main;
import Methods.Password;
import Methods.SubjectRegister;
import Subjects.LineSubject;
import Subjects.WellfareSubject;
import Users.Admin;
import Users.Student;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<LineSubject> lineSubjects = new ArrayList<>();
    static ArrayList<WellfareSubject> wellfareSubjects = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static Password[] passwords = Password.values();

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
                System.out.println("Do you have any discount? (Y/N): ");
                String discountApplication = scanner.next();
                scanner.nextLine();
                double value=0.0;
                Admin admin = new Admin(null, null, null, null, null, false);
                if (discountApplication.equalsIgnoreCase("Y")){
                    System.out.println("Enter admin's password: ");
                    String password = scanner.next();
                    scanner.nextLine();
                    for (Password password1 : passwords){
                        if (password.equals(password1.name())){
                            admin = new Admin(null, null, null, null, null, true);
                        }
                    }
                }
                value = credits * creditValue;
                LineSubject lineSubject = new LineSubject(idSubject, subjectName, "LineSubject", "", credits, value);
                if (admin.isPermission()) lineSubject.setValue(lineSubject.getValue()*new SubjectRegister(students).assignDiscount(admin.isPermission()) );
                else System.out.println("The password wasn't the correct and the register failed.");
                lineSubjects.add(lineSubject);
                System.out.println("Subject added correctly.");
                System.out.println("The value of this subject is: "+lineSubject.getValue());
            }
            //Register if is WellfareSubject
            else if (studyLine.equalsIgnoreCase("w")){
                System.out.println("Name of the Subject: ");
                String subjectName = scanner.next();
                scanner.nextLine();
                System.out.println("Hours of the Subject: ");
                int hours = scanner.nextInt();
                scanner.nextLine();
                wellfareSubjects.add(new WellfareSubject(idSubject, subjectName, "WellfareSubject", "", hours));
                System.out.println("Subject added correctly.");
                }
            //Nothing to register
            else System.out.println("You haven't give an actual value");
            System.out.println("Do you want to add another subject? (Y/N) : ");
            add = (scanner.next().equalsIgnoreCase("y"));
            }
        //Everything is correct
        System.out.println("Base data for Subjects have been created correctly.");
        int option=0;
        //Show Menu
        do {
            option= Integer.parseInt(JOptionPane.showInputDialog(null, "Menu Option:\n1. Student Register\n2. Register a Subject by Student\n3. Statistics\n4. Exit Program\n"));
            switch (option) {
                case 1:
                    StudentRegister();
                    break;
                case 2:
                    RegisterSubjectByStudent();
                    break;
                case 3:
                    getStatistics();
                    break;
                case 4:
                    System.out.println("Thanks for using our services, please comeback again.");
                    break;
                default:
                    System.out.println("You didn't enter a correct value, please try again.");
                    break;
            }
        }while (option !=4);
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
        students.add(new Student(id, studentName, studentLastName,studentBirthday,studentEmail,new ArrayList<LineSubject>(), new ArrayList<WellfareSubject>()));
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
            System.out.println("Enter the day of registration (YYYY/MM/AA): ");
            String date = scanner.next();
            scanner.nextLine();
            Objects.requireNonNull(lineSubject).setRegisteredDate(date);
            Objects.requireNonNull(student).getLineSubjects().add(lineSubject);
        }
        else if (subjectLine.equalsIgnoreCase("w")){
            WellfareSubject wellfareSubject= SearchWellfareSByName(subjectName);
            System.out.println("Enter the day of registration (YYYY/MM/AA): ");
            String date = scanner.next();
            scanner.nextLine();
            Objects.requireNonNull(wellfareSubject).setRegisteredDate(date);
            Objects.requireNonNull(student).getWellfareSubjects().add(wellfareSubject);
        }
        else System.out.println("You didn't choose a correct option.");
        System.out.println("Process finished with success.");
    }

    public static Student SearchStudentById(String studentId){
        for (Student student: students){
            if (student.getId().equals(studentId)) return student;
        }
        return null;
    }

    public static LineSubject SearchLineSByName(String subjectName){
        for (LineSubject lineSubject: lineSubjects){
            if (lineSubject.getSubjectName().equalsIgnoreCase(subjectName)) return lineSubject;
        }
        return null;
    }
    public static WellfareSubject SearchWellfareSByName(String subjectName){
        for (WellfareSubject wellfareSubject: wellfareSubjects){
            if (wellfareSubject.getSubjectName().equalsIgnoreCase(subjectName)) return wellfareSubject;
        }
        return null;
    }
    public static void getStatistics(){
        System.out.println("The number of registered students of the Line Subjects are: ");
        for (LineSubject lineSubject : lineSubjects){
            String subjectName = lineSubject.getSubjectName();
            int count = new SubjectRegister(students).returnSubjectCountByLineS(subjectName);
            System.out.println(subjectName + ": "+count);
        }
        System.out.println("The number of registered students of the Wellfare Subjects are: ");
        for (WellfareSubject wellfareSubject : wellfareSubjects){
            String subjectName = wellfareSubject.getSubjectName();
            int count = new SubjectRegister(students).returnSubjectCountByWellfareS(subjectName);
            System.out.println(subjectName + ": "+count);
        }
    }

}
