package com.oscar.nicholas.api;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogTestApi {

    @GetMapping("/log")
    public String log() {

        String name = "Oscar";
        String email = "oscar@1s2w.com";
        log.info("info --- log");
        log.warn("warn --- warn");
        log.error("error --- error");
//        log.debug("debug --- debug");
//        log.trace("trace --- trace");
        log.info("name : {},email : {}", name, email);
        return "logtest";
    }
}
