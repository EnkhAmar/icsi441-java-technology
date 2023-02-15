package lab2.createLargeDataSet;

// @student: G.Enkh-Amar /18b1num0399/
/* Exercise 12.14.
(Create large dataset) Create a data file with 1,000 lines. Each line in the file
consists of a faculty member’s first name, last name, rank, and salary. The
faculty member’s first name and last name for the ith line are FirstNamei and
LastNamei. The rank is randomly generated as assistant, associate, and full.
The salary is randomly generated as a number with two digits after the decimal
point. The salary for an assistant professor should be in the range from 50,000
to 80,000, for associate professor from 60,000 to 110,000, and for full professor
from 75,000 to 130,000. Save the file in Salary.txt. Here are some sample data:
FirstName1 LastName1 assistant 60055.95
FirstName2 LastName2 associate 81112.45
. . .
FirstName1000 LastName1000 full 92255.21
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class CreateLargeDataSet {
    ArrayList<Member> memberList = new ArrayList<>();
    File file;
    Member member;
    Random random = new Random();

    public CreateLargeDataSet() throws FileNotFoundException {
        file = new File("test/created_large_data_set.txt");
        createIfNotExists(file);
        for (int i = 1; i <= 1000; i++) {
            int rank = generateRandomInt(Member.ASSISTANT, Member.FULL);
            member = new Member("Firstname"+i, "Lastname"+i, rank, getRandomSalary(rank));
            memberList.add(member);
        }
        writeToFile(file);
    }

    void writeToFile(File file) throws FileNotFoundException {
        PrintWriter output = new PrintWriter(file);
        for (Member member :memberList) {
            output.println(member.toString());
        }
        output.close();
    }

    public static int generateRandomInt(int min, int max) {
        Random rd = new Random();
        return rd.nextInt(max-min+1)+min;
    }

    public static double generateRandomDouble(int min, int max) {
        Random rd = new Random();
        return rd.nextDouble(max-min+1)+min;
    }

    public double getRandomSalary(int rank) {
        switch (rank) {
            case Member.ASSISTANT:
                return generateRandomDouble(50000, 80000);
                case Member.ASSOCIATE:
                    return generateRandomDouble(60000, 110000);
                    case Member.FULL:
                        return generateRandomInt(75000, 110000);
        }
        return 0.0;
    }

    void createIfNotExists(File file) {
        if (file.exists()) return;
        String dirToCreate = removeSuffix(file.getAbsolutePath(), file.getName());
        File f = new File(dirToCreate);
        f.mkdirs();
        String fileToCreate = dirToCreate + file.getName();
        File createdF = new File(fileToCreate);
        try {
            createdF.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String removeSuffix(final String s, final String suffix)
    {
        if (s != null && suffix != null && s.endsWith(suffix)) {
            return s.substring(0, s.length() - suffix.length());
        }
        return s;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new CreateLargeDataSet();
    }
}
