package final_exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student {
    private String surname;
    private String firstName;
    private List<Integer> examResults;

    public Student(String surname, String firstName, List<Integer> examResults) {
        this.surname = surname;
        this.firstName = firstName;
        this.examResults = examResults;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public List<Integer> getExamResults() {
        return examResults;
    }
}