package com.coursecube.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public HelloService(){
        System.out.println("HelloService - DC");
    }
    public void show(){
        System.out.println("HelloService - show()");
    }
}
