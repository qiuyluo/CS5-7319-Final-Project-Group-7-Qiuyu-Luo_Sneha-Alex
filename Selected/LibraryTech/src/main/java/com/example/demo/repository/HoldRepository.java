package com.example.demo.repository;
import com.example.demo.entity.Book;
import com.example.demo.entity.Hold;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author LUO, QIUYU
 * @version 1.0
 */

@Repository
public interface HoldRepository extends JpaRepository<Hold, Long> {
    List<Hold> findByUser(User user);
    List<Hold> findByBook(Book book);
}
