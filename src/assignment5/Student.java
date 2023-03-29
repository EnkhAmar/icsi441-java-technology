package assignment5;

import java.util.*;
import java.util.stream.Collectors;


// @student: G.Enkh-Amar /18b1num0399/
/*
Бодлого No1.
Дараах талбарууд бүхий STUDENT классыг зохио:
−NAME –оюутны нэр;
−GROUP –хөтөлбөрийн нэр(буюу код);
−SES –голч оноо.
Дараах үйлдлүүдийг гүйцэтгэдэг програм зохио:
•STUDENT төрлийн 10 объект хадгалдаг ямар нэгэн цуглуулга үүсгэнэ.
•Энэцуглуулгаа GROUP талбарын хувьд өсөхөөр эрэмбэлнэ
•Голч оноо нь 3.5-аас их байх оюутнуудын нэр, хөтөлбөрийннэрийг дэлгэцэнд хэвлэнэ, хэрэв ийм оюутан байхгүй бол энэ талаар мэдэгдэнэ
 */

public class Student implements Comparable<Student> {
    private static final String[] NAMES = {"John", "Mary", "David", "Lisa", "James", "Karen", "Sarah", "Michael", "Emily", "Daniel", "Laura", "Robert", "Jennifer", "William", "Jessica", "Richard", "Amanda", "Christopher", "Megan", "Matthew"};
    private static final String[] GROUPS = {"freshman", "sophomore", "junior", "senior"};
    private String name;
    private String group;
    private double ses;

    public Student(String name, String group, double ses) {
        this.name = name;
        this.group = group;
        this.ses = ses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public double getSes() {
        return ses;
    }

    public void setSes(double ses) {
        this.ses = ses;
    }

    @Override
    public String toString() {
        String fSes = String.format("%.2f", this.ses);
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", ses=" + fSes +
                '}';
    }

    public static double generateRandomDouble(double min, double max) {
        Random random = new Random();
        return min + (max-min) * random.nextDouble();
    }

    public static Student generateRandomStudent() {
        Random random = new Random();
        String name = NAMES[random.nextInt(NAMES.length)];
        String group = GROUPS[random.nextInt(GROUPS.length)];
        Double ses = generateRandomDouble(1, 4);
        return new Student(name, group, ses);
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i <10; i++) {
            students.add(generateRandomStudent());
        }

        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.compareTo(o2);
            }
        };
        Collections.sort(students, comparator);

        System.out.println("SORTED STUDENTS");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\nHigh ses students");
        List<Student> filteredStudents = students.stream()
                .filter(student -> student.getSes() > 3.5)
                .collect(Collectors.toList());
        if (filteredStudents.size() > 0) {
            for (Student student : filteredStudents) {
                System.out.println(student);
            }
        } else {
            System.out.println("No students with ses > 3.5");
        }
    }

    @Override
    public int compareTo(Student o) {
        List<String> groups = Arrays.asList(GROUPS);
        int indexOfThis = groups.indexOf(this.getGroup());
        int indexOfObj = groups.indexOf(o.getGroup());
        return indexOfThis - indexOfObj;
    }
}
