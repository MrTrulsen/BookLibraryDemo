package no.ntnu.sysdev.spring_demo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowIndex) throws SQLException {
       return new Book(
               rs.getString("author"),
               rs.getString("title"),
               rs.getInt("id"));
    }
}
