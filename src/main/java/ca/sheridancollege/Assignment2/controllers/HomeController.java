package ca.sheridancollege.Assignment2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.*;
import ca.sheridancollege.Assignment2.beans.Book;
import ca.sheridancollege.Assignment2.database.DatabaseAccess;

@Controller
public class HomeController {

    private DatabaseAccess database;

    public HomeController(DatabaseAccess database){
        this.database = database;
    }

    @GetMapping("/")
    public String home(Model model){

        List<Book> books = database.getBooks();

        model.addAttribute("bookList", books);
        model.addAttribute("book", new Book());

        return "index";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute Book book){
        
        int returnValue = database.addBook(book);

        System.out.println("return value is: " + returnValue);
        
        return "redirect:/";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable Long id){

        int returnValue = database.deleteBook(id);

        System.out.println("return value is: " + returnValue);

        return "redirect:/";
    }
}
