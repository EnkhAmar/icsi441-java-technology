package lab1;

import java.util.Scanner;

// @student: G.Enkh-Amar /18b1num0399/
// Exercise 4.18. (Student major and status)
public class StudentMajorStatus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter two characters: ");
        String status = in.next();
        char major = Character.toUpperCase(status.charAt(0));
        char year = status.charAt(1);
        String courseName = "";
        String yearName = "";
        if (major == 'I' || major == 'C' || major == 'A') {
            switch (major) {
                case 'I' -> courseName = "Information Management";
                case 'C' -> courseName = "Computer Science";
                case 'A' -> courseName = "Accounting";
                default -> {
                }
            }
            switch (year) {
                case '1':
                    yearName = "Freshman";
                    break;
                case '2':
                    yearName = "Sophomore";
                    break;
                case '3':
                    yearName = "Junior";
                    break;
                case '4':
                    yearName = "Senior";
                    break;
                default:
                    break;
            }
            System.out.printf("%s %s%n", courseName, yearName);
        } else {
            System.out.printf("Invalid input.%n");
        }
    }
}