package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Hold;
import com.example.demo.entity.User;
import com.example.demo.service.DataStore;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LUO, QIUYU
 * @version 1.0
 */

@Service
public class BookService {

    // Instead of @Autowired repositories, we're going to use the static methods from DataStore

    public List<Book> getAllBooks() {
        return DataStore.getBooks();
    }

    public Book getBookById(Long id) {
        return DataStore.getBooks().stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Book> searchBooksByKeyword(String keyword) {
        return DataStore.getBooks().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                        book.getAuthor().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Since we don't have a database, we simulate saving a book by adding it to the list
    public Book saveBook(Book book) {
        List<Book> books = DataStore.getBooks();
        book.setId((long) (books.size() + 1)); // Simulate auto-increment ID
        books.add(book);
        return book;
    }

    // Simulate delete by removing the book from the list
    public void deleteBook(Long id) {
        List<Book> books = DataStore.getBooks();
        books.removeIf(book -> book.getId().equals(id));
    }

    public List<Book> recommendBooksForUser(Long userId) {
        User user = DataStore.getUsers().stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst()
                .orElse(null);
        if (user == null) {
            return Collections.emptyList();
        }

        List<Hold> userHolds = DataStore.getHolds().stream()
                .filter(hold -> hold.getUser().getId().equals(userId))
                .collect(Collectors.toList());

        List<Book> borrowedBooks = userHolds.stream()
                .map(Hold::getBook)
                .collect(Collectors.toList());

        // Assuming genre and topic are the features used for recommendations
        List<String> genres = borrowedBooks.stream().map(Book::getGenre).collect(Collectors.toList());
        List<String> topics = borrowedBooks.stream().map(Book::getTopic).collect(Collectors.toList());

        List<Book> recommendedBooks = DataStore.getBooks().stream()
                .filter(book -> genres.contains(book.getGenre()) || topics.contains(book.getTopic()))
                .collect(Collectors.toList());

        recommendedBooks.removeAll(borrowedBooks);

        return recommendedBooks;
    }

}
