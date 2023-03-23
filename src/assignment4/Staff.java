package assignment4;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

// @student: G.Enkh-Amar
/*
Лабораторийн ажилтнуудын талаар дараах мэдээллийг хадгалдаг  файл өгөгдөв:
овог нэр, төрсөн он, хүйс, боловсрол (дунд, дээд), ажилд орсон он.
Дээд боловсролтой, 28 хүртэлх бүх ажилтны мэдээллийг олж хэвлэнэ үү.
 */

public class Staff implements Serializable {
    private static final String[] FIRST_NAMES = {"John", "Mary", "David", "Lisa", "James", "Karen", "Sarah", "Michael", "Emily", "Daniel", "Laura", "Robert", "Jennifer", "William", "Jessica", "Richard", "Amanda", "Christopher", "Megan", "Matthew"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Brown", "Davis", "Garcia", "Wilson", "Martinez", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Moore", "Allen", "Young", "King", "Scott", "Lee"};
    private static final Character[] GENDERS = {'M', 'F'};
    private static final String[] EDUCATIONS = {"UNDERGRADUATE", "GRADUATE"};
    private String lastname;
    private String firstname;
    private LocalDate dob;
    private Character gender;
    private String education;
    private int yearJoined;

    public Staff(String lastname, String firstname, LocalDate dob, Character gender, String education, int yearJoined) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.dob = dob;
        this.gender = gender;
        this.education = education;
        this.yearJoined = yearJoined;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        Period period = Period.between(dob, today);
        return period.getYears();
    }

    @Override
    public String toString() {
        return "Staff{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", dob=" + dob +
                ", gender=" + gender +
                ", education='" + education + '\'' +
                ", yearJoined=" + yearJoined +
                ", age=" + getAge() +
                '}';
    }

    static int generateRandomInt(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min;
        return randomNumber;
    }

    static Staff generateRandomStaff() {
        Random random = new Random();
        String firstname = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastname = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        LocalDate dob = LocalDate.of(generateRandomInt(1970, 2004), generateRandomInt(1, 12), generateRandomInt(1, 28));
        Character gender = GENDERS[random.nextInt(GENDERS.length)];
        String education = EDUCATIONS[random.nextInt(EDUCATIONS.length)];
        int yearJoined = generateRandomInt(dob.getYear()+18, 2023);
        return new Staff(lastname, firstname, dob, gender, education, yearJoined);
    }

    static void createFile(String file) throws IOException {
        System.out.println("GENERATING RANDOM DATA");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        for (int i = 0; i < 10; i++) {
            Staff staff = generateRandomStaff();
            objectOutputStream.writeObject(staff);
            System.out.println(staff);
        }
        System.out.println("FINISHED\n");
        objectOutputStream.close();
    }

    static void printMatchingStaffs(String file, int maxAge, String education) throws IOException, ClassNotFoundException {
        System.out.println("PRINTING MATCHING STAFFS");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        try {
            while (true) {
                Staff staff = (Staff) objectInputStream.readObject();
                if (staff.getAge() <= maxAge && staff.education.equals(education)) {
                    System.out.println(staff);
                }
            }
        } catch (EOFException e) {

        } finally {
            objectInputStream.close();
        }
    }
    public static void main(String[] args) {
        String file = "test/resources/assignment4-staff.bin";
        try {
            createFile(file);
            printMatchingStaffs(file, 28, EDUCATIONS[1]);
        } catch (IOException e) {
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
