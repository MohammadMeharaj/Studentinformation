import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int Id;
    private String course;

    public Student(String name, int Id, String course) {
        this.name = name;
        this.Id = Id;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return Id;
    }

    public String getCourse() {
        return course;
    }


    public String display() {
        return "Name: " + name + ", Student ID: " + Id + ", Course: " + course;
    }
}

public class StudentInformation {
    public static void main(String[] args) {
        ArrayList studentList = new ArrayList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Student Information System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int Id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter course: ");
                    String course = scanner.nextLine();
                    Student student = new Student(name, Id, course);
                    studentList.add(student);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.println("List of Students:");
                    for (Student s : studentList) {
                        System.out.println(s);
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();
                    boolean found = false;
                    for (Student s : studentList) {
                        if (s.getId() == searchId) {
                            System.out.println("Student found: " + s);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();
                    for (Student s : studentList) {
                        if (s.getId() == removeId) {
                            studentList.remove(s);
                            System.out.println("Student removed successfully.");
                            break;
                        }
                    }
                    System.out.println("Student not found.");
                    break;

                case 5:
                    System.out.println("Exiting Student Information System.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
