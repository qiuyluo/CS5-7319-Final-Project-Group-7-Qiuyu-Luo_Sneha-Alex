package com.example.demo.service;
import com.example.demo.entity.Hold;
import com.example.demo.entity.User;
import com.example.demo.repository.HoldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * @author LUO, QIUYU
 * @version 1.0
 */

@Service
public class HoldService {

    @Autowired
    private HoldRepository holdRepository;

    public List<Hold> getAllHoldsByUser(User user) {
        return holdRepository.findByUser(user);
    }

    public Hold getHoldById(Long id) {
        return holdRepository.findById(id).orElse(null);
    }

    public Hold placeHold(Hold hold) {
        return holdRepository.save(hold);
    }

    public void cancelHold(Long id) {
        holdRepository.deleteById(id);
    }
}
