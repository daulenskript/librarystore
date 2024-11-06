package org.example;


import org.example.Book;
import org.example.BookDAO;
import org.example.FileLogger;
import java.sql.SQLException;
import java.util.List;

public class LibraryService {
    private BookDAO bookDAO;

    public LibraryService() {
        this.bookDAO = new BookDAO();
    }

    public void addNewBook(String isbn, String title, String author) {
        try {
            Book book = new Book(isbn, title, author);
            bookDAO.addBook(book);
            FileLogger.log("New book added: " + book.getTitle());
        } catch (SQLException e) {
            FileLogger.log("Error adding book: " + e.getMessage());
            throw new RuntimeException("Error adding book", e);
        }
    }

    public List<Book> getAllAvailableBooks() {
        try {
            List<Book> books = bookDAO.getAllBooks();
            FileLogger.log("Retrieved all books. Count: " + books.size());
            return books;
        } catch (SQLException e) {
            FileLogger.log("Error retrieving books: " + e.getMessage());
            throw new RuntimeException("Error retrieving books", e);
        }
    }
}

