package com.example.demo.service;
import com.example.demo.entity.Book;
import com.example.demo.entity.Hold;
import com.example.demo.entity.User;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.HoldRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author LUO, QIUYU
 * @version 1.0
 */

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HoldRepository holdRepository;


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }


    public List<Book> searchBooksByKeyword(String keyword) {
        return bookRepository.findByTitleContainingOrAuthorContaining(keyword, keyword);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> recommendBooksForUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return Collections.emptyList();
        }

        // Get user's history of reservations and books borrowed
        List<Hold> userHolds = holdRepository.findByUser(user);
        List<Book> borrowedBooks = new ArrayList<>();
        for (Hold hold : userHolds) {
            borrowedBooks.add(hold.getBook());
        }

        // Get the features for each book
        List<String> genres = borrowedBooks.stream().map(Book::getGenre).collect(Collectors.toList());
        List<String> topics = borrowedBooks.stream().map(Book::getTopic).collect(Collectors.toList());

        // Find similar books based on book characteristics from user history
        List<Book> recommendedBooks = bookRepository.findByGenreInOrTopicIn(genres, topics);

        // Remove books that have been borrowed or reserved by the user from the list of recommended books
        recommendedBooks.removeAll(borrowedBooks);

        return recommendedBooks;
    }

}
