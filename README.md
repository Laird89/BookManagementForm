# BookManagementForm

This was an assignment for third semester java class.

<img width="539" alt="EnterBooksAssignment" src="https://github.com/Laird89/BookManagementForm/assets/117320855/1d4ee43a-1534-4f85-a64a-8bfe15cd5c74">

This project allows users to add books through a web form, displays a list of books on the home page, and provides an option to delete books. The data is stored in a MySQL database, and the application is built using the Spring Framework and Thymeleaf templating engine.

Bean (Book.java):

Represents a book with attributes such as ID, ISBN number, book name, author name, user role, user roles array, and creation date.
Uses Lombok annotations (@Data) to automatically generate getters, setters, and other boilerplate code.

Controller (HomeController.java):

Acts as a controller for handling HTTP requests.
Defines methods for handling home page rendering (/), adding a book (/addBook), and deleting a book (/deleteBook/{id}).
Uses the DatabaseAccess class to interact with the database.
Retrieves a list of books and adds it to the model for rendering on the home page.
Supports adding and deleting books.

Database Access (DatabaseAccess.java):

Manages database operations using Spring JDBC.
Provides methods to get a list of books (getBooks), add a book (addBook), and delete a book (deleteBook).

HTML Template (index.html):

A Thymeleaf template for the web interface.
Contains a form for entering book details, a table for displaying the list of books, and JavaScript for confirming book deletion.
Utilizes Thymeleaf expressions to dynamically render data from the model.
