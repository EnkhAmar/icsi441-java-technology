package midterm;

import java.time.LocalDate;
import java.util.Random;

public class Person {
    private static final String[] FIRST_NAMES = {"John", "Mary", "David", "Lisa", "James", "Karen", "Sarah", "Michael", "Emily", "Daniel", "Laura", "Robert", "Jennifer", "William", "Jessica", "Richard", "Amanda", "Christopher", "Megan", "Matthew"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Brown", "Davis", "Garcia", "Wilson", "Martinez", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Moore", "Allen", "Young", "King", "Scott", "Lee"};
    String lastName;
    String firstName;
    LocalDate dob;

    public Person(String lastName, String firstName, LocalDate dob) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.dob = dob;
    }

    public String getName() {
        return lastName + " " + firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Director{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", dob=" + dob +
                '}';
    }

    static int generateRandomInt(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min;
        return randomNumber;
    }

    static Person generateRandomPerson() {
        Random random = new Random();
        String firstname = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastname = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        LocalDate dob = LocalDate.of(generateRandomInt(1970, 2004), generateRandomInt(1, 12), generateRandomInt(1, 28));
        return new Person(lastname, firstname, dob);
    }
}
