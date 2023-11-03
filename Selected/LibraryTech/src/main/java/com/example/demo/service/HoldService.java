package com.example.demo.service;
import com.example.demo.entity.Book;
import com.example.demo.entity.Hold;
import com.example.demo.entity.User;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.HoldRepository;
import com.example.demo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/**
 * @author LUO, QIUYU
 * @version 1.0
 */

@Service
public class HoldService {

    private final HoldRepository holdRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Autowired
    public HoldService(HoldRepository holdRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.holdRepository = holdRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public List<Hold> getAllHoldsByUser(User user) {
        return holdRepository.findByUser(user);
    }

    public Hold getHoldById(Long id) {
        return holdRepository.findById(id).orElse(null);
    }

    public Hold placeHold(Long userId, Long bookId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book not found"));

        Hold hold = new Hold();
        hold.setUser(user);
        hold.setBook(book);
        hold.setHoldDate(new Date());

        return holdRepository.save(hold);
    }

    public void cancelHold(Long holdId) {
        holdRepository.deleteById(holdId);
    }
    public void cancelHoldByBook(Long bookId) {
        holdRepository.deleteByBookId(bookId);
    }

}
