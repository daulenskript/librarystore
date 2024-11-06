package org.example;

import org.example.Book;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class BookDAO {
    private Connection connection;

    public BookDAO() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public void addBook(Book book) throws SQLException {
        String sql = "INSERT INTO books (isbn, title, author, is_available) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, book.getIsbn());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.setBoolean(4, book.isAvailable());
            stmt.executeUpdate();
        }
    }

    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Book book = new Book(
                        rs.getString("isbn"),
                        rs.getString("title"),
                        rs.getString("author")
                );
                book.setAvailable(rs.getBoolean("is_available"));
                books.add(book);
            }
        }
        return books;
    }
}