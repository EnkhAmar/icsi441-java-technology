package midterm;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

/*
Видео хуурцаг.
CD, DVD хуурцагт киноны бичлэгээс гадна кинонд тоглосон жүжигчид, найруулагчийн тухай мэдээлэл бас хадгалагддаг.
Видео хуурцагт хадгалсан киноны мэдээллийн сан өгөгдсөн гэе.

Кино дараах мэдээлэл агуулна:
–нэр;
-найруулагч;
–жүжигчдийн нэрс;
–кино дэлгэцэнд гарсан огноо;
–киног бүтээсэн улс.

Жүжигчин, найруулагчийн хувьд дараах мэдээлэл хадгална:
–Овог нэр;
–төрсөн огноо

•Энэ онд болон өнгөрсөн онд дэлгэцэнд гарсан бүх киног ол
•Таны дуртай кинонд тоглосон жүжигчдийн мэдээллийг ол
•Хамгийн багадаа N удаа кинонд тоглосон жүжигчдийн мэдээллийг ол
•Ядаж нэг кинонд найруулагчаар ажилласан жүжигчний мэдээллийг ол
•Олон жилийн өмнө (N жилийн өмнө) бүтээгдсэн бүх киног устга
Энэ даалгаврыг хийж гүйцэтгэхэд цуглуулгын талаар мэдлэгээ хэрэглээрэй.
 */
public class Exam {
    String cdFilePath;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;
    ArrayList<Person> directors;
    ArrayList<Person> characters;
    ArrayList<Movie> movies;

    public static final String[] COUNTRIES = {"USA", "CHINA", "MONGOLIA", "RUSSIA", "KOREA", "INDIA"};

    void seedDataToFile(int directorsCount, int charactersCount, int moviesCount) throws IOException {
        outputStream = new ObjectOutputStream(new FileOutputStream(cdFilePath));
        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Person person = Person.generateRandomPerson();
            people.add(person);
        }
        System.out.println("GENERATING DIRECTORS");
        for (int i = 0; i < directorsCount; i++) {
            Person director = people.get(generateRandomInt(0, people.size()-1));
            directors.add(director);
            System.out.println(director);
        }
        System.out.println("GENERATING CHARACTERS");
        for (int i = 0; i < charactersCount; i++) {
            Person character = people.get(generateRandomInt(0, people.size()-1));
            characters.add(character);
            System.out.println(character);
        }
        System.out.println("GENERATING MOVIES");
        for (int i = 1; i <= moviesCount; i++) {
            ArrayList<String> characterNames = new ArrayList<>();
            for (int j = 0; j < generateRandomInt(1, 3); j++) {
                characterNames.add(characters.get(generateRandomInt(0, characters.size()-1)).getName());
            }
            String director = directors.get(generateRandomInt(0, directors.size()-1)).getName();
            LocalDate openingDate = LocalDate.of(generateRandomInt(2010, 2023), generateRandomInt(1, 12), generateRandomInt(1, 28));
            Movie movie = new Movie("Movie"+i, characterNames, director, openingDate, COUNTRIES[generateRandomInt(0, 5)]);
            movies.add(movie);
            System.out.println(movie);
            outputStream.writeObject(movie);
        }
        outputStream.close();
    }

    void printMoviesInGivenYear(int min, int max) {
        boolean atLeasOneFound = false;
        for (Movie movie : movies) {
            int year = movie.getOpeningDate().getYear();
            if (year >= min && year <= max) {
                atLeasOneFound = true;
                System.out.println(movie);
            }
        }
        if (!atLeasOneFound) {
            System.out.println("NO MATCH FOUND");
        }
    }

    void printMyFavourite() {
        // Хамгийн эхний кинонд дуртай гэж үзлээ. Яагаад гэвэл нэр рандомоор өөрчлөгдөнө seed хийх үед.
        Movie favMovie = movies.get(0);
        HashSet<Person> favourite = new HashSet<>();
        for (String name: favMovie.getCharacters()) {
            for (Person character: characters) {
                if (character.getName().equals(name)) {
                    favourite.add(character);
                }
            }
        }
        for (Person fav : favourite) {
            System.out.println("YOUR FAV CHARACTER: " + fav);
        }
    }

    void printNActored(int n) {
        HashMap<String, Integer> data = new HashMap<>();
        for (Movie movie : movies) {
            for (String name :
                    movie.characters) {
                if (data.containsKey(name)) {
                    data.put(name, data.get(name) + 1);
                } else {
                    data.put(name, 1);
                }
            }
        }
        Map<String, Integer> filtered = data.entrySet().stream().filter(entry -> entry.getValue() >= n).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(filtered);
    }

    void printActorWorkedAsDirector() {
        HashMap<String, ArrayList<String>> dirs = new HashMap<>();
        for (Movie movie : movies) {
            if (!dirs.containsKey(movie.getDirector())) {
                dirs.put(movie.getDirector(), new ArrayList<>());
            }
        }
        for (Movie movie : movies) {
            for (String name : movie.characters) {
                if (dirs.containsKey(name)) {
                    ArrayList<String> list = dirs.get(name);
                    list.add(movie.getTitle());
                    dirs.put(name, list);
                }
            }
        }
        System.out.println(dirs);
    }

    int getCurrentYear() {
        return Year.now().getValue();
    }

    void deleteNYearAgo(int n) {
        int year = getCurrentYear() - n;
        movies.removeIf(movie -> movie.getOpeningDate().getYear() < year);

        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public Exam(String cdFilePath) throws IOException {
        this.cdFilePath = cdFilePath;
        this.movies = new ArrayList<>();
        this.characters = new ArrayList<>();
        this.directors = new ArrayList<>();
        seedDataToFile(7, 20, 5);

        System.out.println("\nTASK 1. PRINT ALL MOVIES BETWEEN LAST YEAR AND THIS YEAR");
        printMoviesInGivenYear(getCurrentYear() - 1, getCurrentYear());

        System.out.println("\nTASK 2. FAVOURITE MOVIE ACTOR");
        printMyFavourite();

        System.out.println("\nTASK 3. N times");
        printNActored(2);

        System.out.println("\nTASK 4. ACTOR WHO WORKED AS DIRECTOR");
        printActorWorkedAsDirector();

        System.out.println("\nTASK 5. Remove n year ago");
        deleteNYearAgo(5);
    }

    static int generateRandomInt(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min;
        return randomNumber;
    }

    public static void main(String[] args) {
        String cdFilePath = "src/midterm/cd_file.bin";
        try {
            new Exam(cdFilePath);
        } catch (IOException e) {
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }
    }
}
