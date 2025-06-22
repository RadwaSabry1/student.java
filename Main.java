import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("===== Student Grades Manager =====");


        while (true) {
            System.out.print("Enter student name (or type 'done' to finish): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter grade for " + name + ": ");
            double grade;
            try {
                grade = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid grade! Try again.");
                continue;
            }

            students.add(new Student(name, grade));
        }


        if (students.isEmpty()) {
            System.out.println("No student data entered.");
            return;
        }


        double total = 0;
        double highest = students.get(0).grade;
        double lowest = students.get(0).grade;

        for (Student s : students) {
            total += s.grade;
            if (s.grade > highest) highest = s.grade;
            if (s.grade < lowest) lowest = s.grade;
        }

        double average = total / students.size();


        System.out.println("\n===== Summary Report =====");
        for (Student s : students) {
            System.out.println(s.name + " - Grade: " + s.grade);
        }

        System.out.printf("\nAverage Grade: %.2f\n", average);
        System.out.printf("Highest Grade: %.2f\n", highest);
        System.out.printf("Lowest Grade: %.2f\n", lowest);
    }
}

