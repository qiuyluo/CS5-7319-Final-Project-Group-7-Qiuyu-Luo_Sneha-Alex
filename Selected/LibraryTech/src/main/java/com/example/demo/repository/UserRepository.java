package com.example.demo.repository;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author LUO, QIUYU
 * @version 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);
}
