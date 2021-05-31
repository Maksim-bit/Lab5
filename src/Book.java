import java.util.ArrayList;
import java.util.Objects;


public class Book {
    private String title;
    private int pubYear;
    private ArrayList<String> authors;


    public Book(String title, int pubYear, ArrayList<String> authors) {
        this.title = title;
        this.pubYear = pubYear;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public int getPubYear() {
        return pubYear;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pubYear == book.pubYear &&
                Objects.equals(title, book.title);

    }

    @Override
    public int hashCode() {
        return Objects.hash(title, pubYear);
    }

    @Override
    public String toString() {
        return String.format("Название книги: %s от %d года. Авторы: %s", getTitle(), getPubYear(), String.join(", ", getAuthors()));
    }

}

