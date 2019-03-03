package no.ntnu.sysdev.spring_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private final JdbcTemplate jdbcTemplate;
    private RowMapper<Book> rowMapper = new BookRowMapper();

    @Autowired
    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();

        //This is basically the same as under!
        return jdbcTemplate.query("SELECT * FROM books", rowMapper);

        //SqlRowSet rs = jdbcTemplate.queryForRowSet("SELECT * FROM books");
        //while(rs.next()){
        //    Book b = new Book(rs.getString("author"), rs.getString("title"));
        //    books.add(b);
        //}
        //books.add(new Book("Jk Rowling","Harry Potter 1"));
        //books.add(new Book("Jk Rowling","Harry Potter 2"));
        //books.add(new Book("Jk Rowling","Harry Potter 3"));
        //books.add(new Book("Jk Rowling","Harry Potter 4"));
       // return books;
    }

    /**
     * Delete all the books in the database.
     * @return true when some books were deleted, false if there were no books to delete
     */
    public boolean clear() {
        int numRows = jdbcTemplate.update("DELETE FROM books");
        return numRows > 0;
    }

    /**
     * Add a book to the database
     * @param book
     * @return Return true on success, false otherwise.
     */
    public String add(Book book) {
        String query = "INSERT INTO books (title, author, id) VALUES (?, ?, ?)";
        try {
            int numRows = jdbcTemplate.update(query, book.getTitle(), book.getAuthor(), book.getId());
            if(numRows == 1){
                return null;
            }
            else {
                return "Could not add new book";
            }
        }
        catch(Exception ex){
            return "Could not add new book: " + ex.getMessage();
        }
    }
}
