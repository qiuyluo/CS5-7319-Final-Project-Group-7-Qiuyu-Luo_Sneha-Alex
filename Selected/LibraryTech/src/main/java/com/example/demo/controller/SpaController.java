package com.example.demo.controller;

/**
 * @author LUO, QIUYU
 * @version 1.0
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpaController {

    @RequestMapping({"/", "/search/**", "/profile", "/book/**"})
    public String forwardToIndex() {
        return "forward:/index.html";
    }
}
