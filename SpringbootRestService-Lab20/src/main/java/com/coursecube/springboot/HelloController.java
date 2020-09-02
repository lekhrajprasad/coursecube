package com.coursecube.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping("/hello")
    public String getMessage1(){
        return "getMessage1 - /hello";
    }


}
