package com.example.demo.controller;
import com.example.demo.entity.Hold;
import com.example.demo.entity.User;
import com.example.demo.service.HoldService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * @author LUO, QIUYU
 * @version 1.0
 */

@RestController
@RequestMapping("/api/holds")
public class HoldController {

    @Autowired
    private HoldService holdService;

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public List<Hold> getHoldsByUser(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return holdService.getAllHoldsByUser(user);
    }

    @PostMapping
    public ResponseEntity<Hold> placeHold(@RequestBody Map<String, Object> payload) {
        try {
            Long userId = Long.valueOf(String.valueOf(payload.get("userId")));
            Long bookId = Long.valueOf(String.valueOf(payload.get("bookId")));

            Hold newHold = holdService.placeHold(userId, bookId);

            return new ResponseEntity<>(newHold, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHold(@PathVariable Long id) {
        try {
            holdService.cancelHold(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<Void> deleteHoldByBookAndUser(@PathVariable Long bookId) {
        try {
            holdService.cancelHoldByBook(bookId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
