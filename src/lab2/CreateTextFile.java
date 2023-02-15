package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

// Файлын утга нь n хүртэл мөр үүсгээд эхний мөрөнд латин, хоёрдугаар мөрөнд ab, дараагийн abcd
public class CreateTextFile {
    File toFile;
    File fromFile;
    public  CreateTextFile() throws FileNotFoundException {
        toFile = new File("test/resources/abc.txt");
        createIfNotExists(toFile);
        writeToFile(toFile);
        readFromFile(toFile);
    }
    void writeToFile(File file) throws FileNotFoundException {
        PrintWriter output = new PrintWriter(file);
        String line = "";
        for (char ch='a'; ch <= 'z'; ++ch) {
            line += ch;
            output.println(line);
        }
        output.close();
    }
    void readFromFile(File file) throws FileNotFoundException {
        fromFile = new File("resources/abc.txt");
        Scanner reader = new Scanner(fromFile);
        while (reader.hasNext()) {
            System.out.println(reader.nextLine());
        }
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

    public static String removePrefix(String s, String prefix)
    {
        if (s != null && prefix != null && s.startsWith(prefix)) {
            return s.substring(prefix.length());
        }
        return s;
    }

    public static String removeSuffix(final String s, final String suffix)
    {
        if (s != null && suffix != null && s.endsWith(suffix)) {
            return s.substring(0, s.length() - suffix.length());
        }
        return s;
    }
    public static void main(String[] args) throws FileNotFoundException {
        new CreateTextFile();
    }
}
