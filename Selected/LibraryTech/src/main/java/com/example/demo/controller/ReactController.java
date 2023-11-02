package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LUO, QIUYU
 * @version 1.0
 */

@Controller
public class ReactController {
    @RequestMapping(value = "/**")
    public String redirect() {
        return "forward:/index.html";
    }
}
