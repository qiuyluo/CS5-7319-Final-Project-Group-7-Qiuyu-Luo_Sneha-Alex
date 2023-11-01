package com.example.demo.controller;
import com.example.demo.entity.Hold;
import com.example.demo.entity.User;
import com.example.demo.service.HoldService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
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
    public Hold placeHold(@RequestBody Hold hold) {
        return holdService.placeHold(hold);
    }

    @DeleteMapping("/{id}")
    public void cancelHold(@PathVariable Long id) {
        holdService.cancelHold(id);
    }
}
