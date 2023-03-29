package midterm;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Movie implements Serializable {
    String title;
    ArrayList<String> characters;
    String director;
    LocalDate openingDate;
    String country;

    public Movie(String title, ArrayList<String> characters, String director, LocalDate openingDate, String country) {
        this.title = title;
        this.characters = characters;
        this.director = director;
        this.openingDate = openingDate;
        this.country = country;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<String> characters) {
        this.characters = characters;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", characters=" + characters +
                ", director=" + director +
                ", openingDate=" + openingDate +
                ", country='" + country + '\'' +
                '}';
    }
}
