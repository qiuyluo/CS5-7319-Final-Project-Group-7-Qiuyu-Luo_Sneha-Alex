package com.example.demo.service;
import com.example.demo.entity.Book;
import com.example.demo.entity.Hold;
import com.example.demo.entity.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author LUO, QIUYU
 * @version 1.0
 */

public class DataStore {

    private static final Book book1 = new Book(1L,"The Great Gatsby", "F. Scott Fitzgerald", "Novel", "A story about the mysterious millionaire Jay Gatsby.");
    private static final Book book2 = new Book(2L,"Moby Dick", "Herman Melville", "Novel", "The story of Captain Ahab's quest to avenge the whale.");
    private static final Book book3 = new Book(3L,"To Kill a Mockingbird", "Harper Lee", "Novel", "A novel about racism in the American South.");
    private static final Book book4 = new Book(4L,"1984", "George Orwell", "Novel", "Dystopian society and surveillance.");
    private static final Book book5 = new Book(5L,"Brave New World", "Aldous Huxley", "Novel", "Dystopian future and technological control.");
    private static final Book book6 = new Book(6L,"Pride and Prejudice", "Jane Austen", "Novel", "Romance and social commentary in early 19th century England.");
    private static final Book book7 = new Book(7L,"Sense and Sensibility", "Jane Austen", "Novel", "The lives and loves of the Dashwood sisters.");

    private static final User user1 = new User(4L, "Lucy", "123", "USER");
    private static final User user2 = new User(5L, "librarian", "123", "LIBRARIAN");

    private static final Date date1 = new Date();
    private static final Date date2 = new Date(date1.getTime() - 86400000L);
    private static final List<Book> books = Arrays.asList(
         book1, book2, book3, book4, book5, book6, book7
    );

    private static final List<User> users = Arrays.asList(
            user1, user2
    );

    // 模拟 holds 表
    private static final List<Hold> holds = Arrays.asList(
            new Hold(1L, user1, book1, date1),
            new Hold(2L, user1, book2, date2)
    );

    // Getters
    public static List<Book> getBooks() {
        return books;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static List<Hold> getHolds() {
        return holds;
    }

    public static Optional<User> getUserById(Long id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    public static Optional<User> getUserByUserId(String userId) {
        return users.stream().filter(u -> u.getUserId().equals(userId)).findFirst();
    }

    public static User saveUser(User user) {
        users.removeIf(u -> u.getId().equals(user.getId()));
        users.add(user);
        return user;
    }

    public static void deleteUser(Long id) {
        users.removeIf(u -> u.getId().equals(id));
    }

    public static List<User> getAllUsers() {
        return users;
    }
}
