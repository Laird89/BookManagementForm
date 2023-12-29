CREATE TABLE books
(
    id LONG PRIMARY KEY AUTO_INCREMENT,
    isbnNumber VARCHAR(255),
    bookName VARCHAR(255),
    authorName VARCHAR(255),
    userRole VARCHAR(255),
    creationDate TIMESTAMP
);