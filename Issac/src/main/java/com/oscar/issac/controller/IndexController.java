package com.oscar.issac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/exception")
    public String testException() {
        throw new RuntimeException("測試異常");
    }
}