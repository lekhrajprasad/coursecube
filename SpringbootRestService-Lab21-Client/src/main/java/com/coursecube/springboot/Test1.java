package com.coursecube.springboot;

import org.springframework.web.client.RestTemplate;

public class Test1 {
    public static void main(String[] args) {
        addAccount();
    }

    private static void addAccount() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/addAccount";
        Account account = new Account("SA", "B-99", 75000);
        String msg = restTemplate.postForObject(url, account, String.class);
        System.out.println(msg);
        System.out.println("Done!!");
    }
}
