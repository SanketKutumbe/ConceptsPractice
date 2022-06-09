package Java8.stream;

import java.util.Arrays;
import java.util.List;

public class TestingStreams {

    public static void main(String[] args) {

        List<Book> book = Arrays.asList
                (
                        new Book(1, "RAW", "Author: Sanket Kutumbe"),
                        new Book(2, "Mahabharat", "Author: Sanket Kutumbe")
                );

        System.out.println(function2(book));

    }

    private static Book function2(List<Book> book) {

        return book.stream().filter(t -> t.getId() == 2).findFirst().get();
    }
}
