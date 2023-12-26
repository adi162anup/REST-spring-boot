package com.adi.moviedemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    @GetMapping("/movies")
    public String testStatus() {
        return "All good";
    }
}
