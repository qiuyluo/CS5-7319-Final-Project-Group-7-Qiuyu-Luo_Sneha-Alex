package com.example.demo.service;
import com.example.demo.entity.Book;
import com.example.demo.entity.Hold;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LUO, QIUYU
 * @version 1.0
 */
@Service
public class HoldService {

    public List<Hold> getAllHoldsByUser(User user) {
        return DataStore.getHolds().stream()
                .filter(hold -> hold.getUser().equals(user))
                .collect(Collectors.toList());
    }

    public Hold getHoldById(Long id) {
        return DataStore.getHolds().stream()
                .filter(hold -> hold.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Hold placeHold(Long userId, Long bookId) {
        User user = DataStore.getUsers().stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));

        Book book = DataStore.getBooks().stream()
                .filter(b -> b.getId().equals(bookId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Hold hold = new Hold();
        // Assuming Hold has an id, user, book, and date
        hold.setId(DataStore.getHolds().size() + 1L); // Simple way to generate new ID
        hold.setUser(user);
        hold.setBook(book);
        hold.setHoldDate(new Date());
        DataStore.getHolds().add(hold);

        return hold;
    }

    public void cancelHold(Long holdId) {
        DataStore.getHolds().removeIf(hold -> hold.getId().equals(holdId));
    }

    public void cancelHoldByBook(Long bookId) {
        DataStore.getHolds().removeIf(hold -> hold.getBook().getId().equals(bookId));
    }
}