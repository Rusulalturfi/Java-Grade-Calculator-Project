import java.util.Scanner;

public class GradeCalculator {

    public static char determineLetterGrade(double average) {
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Student Grade Calculator!");
        System.out.print("Enter student name: ");
        String studentName = input.nextLine();

        int numberOfGrades = 0;
        while (numberOfGrades <= 0) {
            System.out.print("How many grades would you like to enter? ");
            numberOfGrades = input.nextInt();
            if (numberOfGrades <= 0) {
                System.out.println("Please enter a number greater than 0.");
            }
        }

        double sumOfGrades = 0.0;
        for (int i = 1; i <= numberOfGrades; i++) {
            System.out.print("Enter grade " + i + " (0-100): ");
            double grade = input.nextDouble();

            while (grade < 0 || grade > 100) {
                System.out.println("Grade must be between 0 and 100. Please re-enter: ");
                grade = input.nextDouble();
            }

            sumOfGrades += grade;
        }

        double average = sumOfGrades / numberOfGrades;
        char letterGrade = determineLetterGrade(average);
        String status = (average >= 60) ? "Passing" : "Failing";

        System.out.println();
        System.out.println("Student: " + studentName);
        System.out.printf("Average grade: %.2f%n", average);
        System.out.println("Letter grade: " + letterGrade);
        System.out.println("Status: " + status);

        input.close();
    }
}
