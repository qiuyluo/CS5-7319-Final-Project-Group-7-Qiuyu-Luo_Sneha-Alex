package com.example.demo.service;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * @author LUO, QIUYU
 * @version 1.0
 */

@Service
public class UserService {

    public User getUserById(Long id) {
        return DataStore.getUserById(id).orElse(null);
    }

    public User getUserByUserId(String userId) {
        return DataStore.getUserByUserId(userId).orElse(null);
    }

    public User saveUser(User user) {
        return DataStore.saveUser(user);
    }

    public void deleteUser(Long id) {
        DataStore.deleteUser(id);
    }

    public List<User> getAllUsers() {
        return DataStore.getAllUsers();
    }
}


