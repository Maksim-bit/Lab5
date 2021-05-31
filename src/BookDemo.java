import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class BookDemo {
    public static void main(String[] args) {
        ArrayList<Book> booksArray = new ArrayList<Book>();
        booksArray.add(new Book("The Complete Reference", 2019, new ArrayList<String>(
                Arrays.asList("Herbert Schieldt"))));
        booksArray.add(new Book("Design Patterns", 2020, new ArrayList<String>(
                Arrays.asList("Eric Freeman", "Elisabeth Robson"))));
        booksArray.add(new Book("Head First Java", 2012, new ArrayList<String>(
                Arrays.asList("Kathy Sierra", "Bert Bates"))));
        booksArray.add(new Book("Effective Java", 2019, new ArrayList<String>(
                Arrays.asList("Joshua Bloch"))));
        booksArray.add(new Book("Data Structures and the Java Collection Framework", 2015, new ArrayList<String>(
                Arrays.asList("William J. Collins"))));
        booksArray.add(new Book("Head First JavaScript", 2018, new ArrayList<String>(
                Arrays.asList("Eric Freeman", "Elisabeth Robson"))));
        booksArray.add(new Book("Spring in Action", 2005, new ArrayList<String>(
                Arrays.asList("Craig Walls"))));
        booksArray.add(new Book("Spring 5 Recipes: a problem-solution approach", 2017, new ArrayList<String>(
                Arrays.asList("Marten Deinum"))));
        booksArray.add(new Book("Head First HTML & CSS", 2011, new ArrayList<String>(
                Arrays.asList("Eric Freeman"))));
        booksArray.add(new Book("Pro Spring 5", 2017, new ArrayList<String>(
                Arrays.asList("Iuliana Cosmina", "Rob Harrop, ", "Chris Schaefer", "Clarence Ho"))));


        System.out.println("Книга изданная раньше остальных"); //Создайте список книг*, найдите книгу, изданную раньше остальных (используя ArrayList).
        int firstBookIndex = 0;
        for (int i = 0; i < booksArray.size(); i++) {
            if (booksArray.get(i).getPubYear() <= booksArray.get(firstBookIndex).getPubYear()) {
                firstBookIndex = i;
            }
        }
        System.out.println(booksArray.get(firstBookIndex) + "\n");


        System.out.println("Книги которые написал один человек"); //Выведите в консоль книги, которые написал один человек, а не коллектив авторов (используя Iterator).
        for (Iterator<Book> iterator = booksArray.iterator(); iterator.hasNext(); ) {
            Book book = iterator.next();
            if (book.getAuthors().size() <= 1) {
                System.out.println(book);
            }
        }
        System.out.println("\n");


        System.out.println("Автор участвующий в написании других книг"); //Найдите автора, участвовавшего в написании наибольшего количества книг (используя Map).

        Map autorsMap = new HashMap();
        for (Book book : booksArray) {
            for (String autor : book.getAuthors()) {
                if (!autorsMap.containsKey(autor)) {
                    autorsMap.put(autor, 1);
                } else {
                    int value = (int) autorsMap.get(autor) + 1;
                    autorsMap.replace(autor, value);
                }
            }
        }
        int maxValue = 0;
        String maxAutor = "";
        Iterator iterator = autorsMap.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            Object value = autorsMap.get(key);
            if ((int) value > maxValue) {
                maxValue = (int) value;
                maxAutor = key.toString();
            }
        }
        System.out.println(maxAutor + "\n");


        System.out.println("Авторы участвовавшие в написании книг из списка по п.3");// Выведите в консоль авторов, участвовавших в написании книг из списка по п.3 (используя Set).

        HashSet<String> maxAutorCoAutors = new HashSet<>();
        for (Book book :booksArray) {
            if (book.getAuthors().contains(maxAutor)) {
                maxAutorCoAutors.addAll(book.getAuthors());
            }
        }
        maxAutorCoAutors.remove(maxAutor);
        System.out.println(maxAutorCoAutors);


    }
}
