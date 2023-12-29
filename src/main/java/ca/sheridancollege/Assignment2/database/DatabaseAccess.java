package ca.sheridancollege.Assignment2.database;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ca.sheridancollege.Assignment2.beans.Book;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class DatabaseAccess {
    
    private NamedParameterJdbcTemplate jdbc;

    public DatabaseAccess(NamedParameterJdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public List<Book> getBooks(){

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "SELECT * FROM books";

        BeanPropertyRowMapper<Book> bookMapper = new BeanPropertyRowMapper<Book>(Book.class);

        List<Book> books = jdbc.query(query, namedParameters, bookMapper);

        return books;

    }

    public int addBook(Book book){


        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        String query = "INSERT INTO books (isbnNumber, bookName, authorName, userRole, creationDate) " +
                        "VALUES (:isbnNumber, :bookName, :authorName, :userRole, :creationDate)";


        namedParameters.addValue("isbnNumber", book.getIsbnNumber())
                        .addValue("bookName", book.getBookName())
                        .addValue("authorName", book.getAuthorName())
                        .addValue("userRole", book.getUserRole())
                        .addValue("creationDate", LocalDateTime.now());

        int returnValue = jdbc.update(query, namedParameters);

        return returnValue;
    }

    public int deleteBook(Long id){

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        String query = "DELETE FROM books WHERE id = :id";

        namedParameters.addValue("id", id);

        int returnValue = jdbc.update(query, namedParameters);

        return returnValue;
    }
}
