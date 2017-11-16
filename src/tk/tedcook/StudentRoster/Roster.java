package tk.tedcook.StudentRoster;
import java.util.ArrayList;

public class Roster {

    private static ArrayList<Student> studentRoster = new ArrayList<>();

    public static void main(String[] args) {
        add("1", "John", "Smith", "John1989@gmail.com", 20, 88, 79, 59);
        add("2", "Suzan", "Erickson", "Erickson_1990@gmailcom", 19, 91, 72, 85);
        add("3", "Jack", "Napoli", "The_lawyer99yahoo.com", 19, 85, 84, 82);
        add("4", "Erin", "Black", "Erin.black@comcast.net", 22, 91, 98, 82);
        add("5", "Ted", "Cook", "tcook77@wgu.edu", 23, 95, 98, 97);
        print_all();
        print_invalid_emails();
        for (Student record : studentRoster) {
            print_average_grade(record.getStudentID());
        }
        remove("3");
        remove("3");
    }

    //Method that adds student records to roster
    public static void add(String studentID, String firstName, String lastName, String email, int age, int grade1, int grade2, int grade3) {
        int[] grades = {grade1, grade2, grade3};
        Student newItem = new Student(studentID, firstName, lastName, email, age, grades);
        studentRoster.add(newItem);
    }

    //Method that removes student record from roster by student ID
    public static void remove(String studentID) {
        for (int i = 0; i < studentRoster.size(); i++) {
            if (studentRoster.get(i).getStudentID().equals(studentID)) {
                studentRoster.remove(i);
                return;
            }
        }
        System.out.println("No record was found for a student with student ID " + studentID + ".");
    }

    //Method that prints all student records in tab-separated format
    public static void print_all() {
        for (Student record : studentRoster) {
            record.print();
        }
    }

    //Method that prints all invalid email records
    public static void print_invalid_emails() {
        for (Student record : studentRoster) {
            String email = record.getEmail();
            String studentID = record.getStudentID();
            if (!email.contains("@") || !email.contains(".") || email.contains(" ")) {
                System.out.println("Student record with student ID " + studentID + " contains the following invalid email address: " + email);
            }
        }
    }

    //Method that prints average grade by student ID
    public static void print_average_grade(String studentID) {
        for (int i = 0; i < studentRoster.size(); i++) {
            if (studentRoster.get(i).getStudentID().equals(studentID)) {
                double average = (studentRoster.get(i).getGrades()[0] + studentRoster.get(i).getGrades()[1] + studentRoster.get(i).getGrades()[2]) / 3.0;
                System.out.print("Student with student ID " + studentID + " has an average grade of ");
                System.out.printf("%.2f", average);
                System.out.println(".");
                return;
            }
        }
        System.out.println("No record was found for a student with student ID " + studentID + ".");
    }

}