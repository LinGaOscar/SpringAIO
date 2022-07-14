package com.oscar.issac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/exception")
    public String testException() {
        throw new RuntimeException("測試異常");
    }
}