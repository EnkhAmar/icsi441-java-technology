package final_exam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// @student: G.Enkh-Amar
/*
Текст файлд оюутнуудын шалгалтын дүнгийн мэдээлэл хадгалагддаг. Оюутны овог, нэр, шалгалтын дүн (5 оноогоор дүгнэнэ) гэсэн мэдээллийг хадгална. Нэг бүлэгт 20-оос цөөн оюутан байна. Дараах мэдээллийг олох програм зохио:
•Бүх оюутныг мэдээллийг үзүүл
•Бүх шалгалтандаа 5 үнэлгээ авсан оюутнуудыг үзүүл
•Ядаж нэг шалгалтад муу (<=2) үнэлгээ авсан оюутнуудыг үзүүл
•Хоёроос олон хичээлд муу үнэлгээ авсан оюутнуудыг шалгалтын мэдээллийн сан (файл)-аас устгана
 */

public class StudentGrades {
    public static void main(String[] args) {
        /*
        "Ovog, Ner, dun1, dun2, dun3, dun4, dun5" гэсэн форматаар файлд оруулна
         */
        String fileName = "students.txt";

        if (!fileExists(fileName)) {
            seedData(fileName);
        }

        List<Student> students = readData(fileName);

        System.out.println("Бүх оюутныг мэдээлэл:");
        showAllStudents(students);

        System.out.println("\nБүх шалгалтандаа 5 үнэлгээ авсан оюутнууд:");
        showStudentsWithAll5(students);

        System.out.println("\nЯдаж нэг шалгалтад муу (<=2) үнэлгээ авсан оюутнууд:");
        showStudentsWithPoorScores(students);

        System.out.println("\nХоёроос олон хичээлд муу үнэлгээ авсан оюутнуудыг шалгалтын мэдээллийн сан (файл)-аас устгаж байна.");
        List<Student> filteredStudents = removeStudentsWithBadGrades(students);
        writeData(fileName, filteredStudents);
        System.out.println("Файлыг хадгалав.");
    }

    public static boolean fileExists(String fileName) {
        File file = new File(fileName);
        return file.exists() && !file.isDirectory();
    }

    public static void seedData(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Bat, Bold, 4, 5, 3, 5, 5\n");
            writer.write("Dorj, Baldan, 5, 5, 5, 5, 5\n");
            writer.write("Amar, Sukhee, 1, 2, 1, 2, 1\n");
            writer.write("Sugar, Naran, 5, 1, 2, 3, 5\n");
            writer.write("Baljin, Sergelen, 4, 2, 3, 5, 5\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readData(String fileName) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String surname = parts[0].trim();
                String firstName = parts[1].trim();
                List<Integer> examResults = new ArrayList<>();
                for (int i = 2; i < parts.length; i++) {
                    examResults.add(Integer.parseInt(parts[i].trim()));
                }
                students.add(new Student(surname, firstName, examResults));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }

    public static void writeData(String fileName, List<Student> students) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Student student : students) {
                writer.write(student.getSurname() + ", " + student.getFirstName() + ", ");
                List<String> examResults = student.getExamResults().stream()
                        .map(Object::toString)
                        .collect(Collectors.toList());
                writer.write(String.join(", ", examResults));
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showAllStudents(List<Student> students) {
        students.forEach(student ->
                System.out.println(student.getSurname() + ", " + student.getFirstName() +
                        ", " + student.getExamResults().stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", "))));
    }

    public static void showStudentsWithAll5(List<Student> students) {
        students.stream()
                .filter(student -> student.getExamResults().stream().allMatch(score -> score == 5))
                .forEach(student ->
                        System.out.println(student.getSurname() + " " + student.getFirstName()));
    }

    public static void showStudentsWithPoorScores(List<Student> students) {
        students.stream()
                .filter(student -> student.getExamResults().stream().anyMatch(score -> score <= 2))
                .forEach(student ->
                        System.out.println(student.getSurname() + " " + student.getFirstName()));
    }

    public static List<Student> removeStudentsWithBadGrades(List<Student> students) {
        return students.stream()
                .filter(student -> student.getExamResults().stream().filter(score -> score <= 2).count() <= 2)
                .collect(Collectors.toList());
    }
}
