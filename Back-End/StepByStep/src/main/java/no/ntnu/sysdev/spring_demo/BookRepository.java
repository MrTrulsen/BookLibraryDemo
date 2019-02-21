package no.ntnu.sysdev.spring_demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Jk Rowling","Harry Potter 1"));
        books.add(new Book("Jk Rowling","Harry Potter 2"));
        books.add(new Book("Jk Rowling","Harry Potter 3"));
        books.add(new Book("Jk Rowling","Harry Potter 4"));
        return books;
    }
}
