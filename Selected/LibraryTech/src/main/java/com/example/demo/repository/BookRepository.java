package com.example.demo.repository;
import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;




/**
 * @author LUO, QIUYU
 * @version 1.0
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingOrAuthorContaining(String title, String author);
    List<Book> findByGenreInOrTopicIn(List<String> genres, List<String> topics);
}
