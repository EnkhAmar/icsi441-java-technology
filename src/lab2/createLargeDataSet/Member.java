package lab2.createLargeDataSet;

public class Member {
    String firstName, lastName;
    int rank;
    double salary;
    static String[] ranks = {"assistant", "associate", "full"};
    final static int ASSISTANT = 0;
    final static int ASSOCIATE = 1;
    final static int FULL = 2;

    public Member(String firstName, String lastName, int rank, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rank = rank;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + ranks[rank] + " " + String.format("%.2f",salary);
    }
}
