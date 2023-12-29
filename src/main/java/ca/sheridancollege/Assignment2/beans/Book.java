package ca.sheridancollege.Assignment2.beans;

import lombok.Data;
import java.time.LocalDateTime;


@Data
public class Book {
    private Long id;
    private String isbnNumber;
    private String bookName;
    private String authorName;
    private String userRole;
    private final String[] userRoles = {"ADMIN","USER"};
    private LocalDateTime creationDate;

}
