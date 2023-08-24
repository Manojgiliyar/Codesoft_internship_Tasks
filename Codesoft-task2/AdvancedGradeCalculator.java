import java.util.Scanner;

public class AdvancedGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student's name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int[] marks = new int[numSubjects];
        int totalMarks = 0;
        int highestMark = Integer.MIN_VALUE;
        int lowestMark = Integer.MAX_VALUE;

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];

            if (marks[i] > highestMark) {
                highestMark = marks[i];
            }

            if (marks[i] < lowestMark) {
                lowestMark = marks[i];
            }
        }

        double averagePercentage = ((double) totalMarks / (numSubjects * 100)) * 100;
        char grade = calculateGrade(averagePercentage);
        String remarks = generateRemarks(averagePercentage);

        System.out.println("\nResults for " + studentName + ":");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
        System.out.println("Highest Mark: " + highestMark);
        System.out.println("Lowest Mark: " + lowestMark);

        displaySubjectGrades(marks);

        scanner.close();
    }

    public static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static String generateRemarks(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "Excellent performance!";
        } else if (averagePercentage >= 80) {
            return "Good job!";
        } else if (averagePercentage >= 70) {
            return "Well done!";
        } else if (averagePercentage >= 60) {
            return "Keep it up!";
        } else {
            return "Work harder to improve.";
        }
    }

    public static void displaySubjectGrades(int[] marks) {
        System.out.println("\nSubject-wise Grades:");
        for (int i = 0; i < marks.length; i++) {
            char subjectGrade = calculateGrade((double) marks[i] / 100 * 100);
            System.out.println("Subject " + (i + 1) + " Grade: " + subjectGrade);
        }
    }
}
