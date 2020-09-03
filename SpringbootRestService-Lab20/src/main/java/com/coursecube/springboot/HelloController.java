package com.coursecube.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping("/hello")
    public String getMessage1(){
        return "getMessage1 - /hello";
    }

    @GetMapping("/hello/{name}")
    public String getMessage2(@PathVariable String name){
        return "getMessage1 - /hello/"+name;
    }

    @GetMapping("/hello/{name}/{email}")
    public String getMessage3(@PathVariable String name, @PathVariable String email){
        return "getMessage1 - /hello/"+name+" => "+email;
    }

    @GetMapping(value = "/hello-json/{name}", produces = "application/json")
    public Hello getMessage4(@PathVariable String name){
        System.out.println("HC-getMessage4()");
        Hello hello=new Hello();
        hello.setName(name);
        String msg="Hello "+name +" !!! - I am getMessage4";
        hello.setMessage(msg);
        return hello;
    }

    @GetMapping(value = "/hello-xml/{name}", produces = "application/xml")
    public Hello getMessage5(@PathVariable String name){
        System.out.println("HC-getMessage4()");
        Hello hello=new Hello();
        hello.setName(name);
        String msg="Hello "+name +" !!! - I am getMessage4";
        hello.setMessage(msg);
        return hello;
    }

}
