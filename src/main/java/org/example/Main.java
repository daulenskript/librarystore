package org.example;


import org.example.LibraryService;
import org.example.Book;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();

        // Add some sample books
        libraryService.addNewBook("123456789", "The Great Gatsby", "F. Scott Fitzgerald");
        libraryService.addNewBook("987654321", "To Kill a Mockingbird", "Harper Lee");

        // Retrieve and display all books
        List<Book> books = libraryService.getAllAvailableBooks();
        System.out.println("Available Books:");
        books.forEach(System.out::println);
    }
}