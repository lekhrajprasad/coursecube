package com.coursecube.springboot;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        //addAccount();
        //getAccount();
        //deposit();
        //withdrawBal();
        //deleteAccount();
        //getAllAccount();
        //getPdf();
        downloadFile();
    }

    private static void addAccount() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/account/add";
        Account account = new Account("SA", "B-99", 75000);
        String msg = restTemplate.postForObject(url, account, String.class);
        System.out.println(msg);
        System.out.println("Done!!");
    }

    private static void getAccount(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/account/get/101";
        Account account = restTemplate.getForObject(url, Account.class);
        System.out.println(account);
    }

    private static void deposit(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/account/deposit";
        TxInfo txInfo = new TxInfo(101,10000);
        restTemplate.put(url, txInfo);
    }

    private static void withdrawBal(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/account/withdraw";
        TxInfo txInfo = new TxInfo(101,1);
        restTemplate.put(url, txInfo);
    }

    private static void deleteAccount(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/account/delete/149";
        restTemplate.delete(url);
    }

    private static void getAllAccount(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/account/get/all";
        List<Map<String,String>> maps = restTemplate.getForObject(url, List.class);
        maps.forEach(System.out::println);

        maps.forEach(e->System.out.println(e.get("atype")));
    }

    private static void getPdf(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/account/getpdf";
        ResponseEntity<InputStreamResource> account = restTemplate.getForEntity(url, InputStreamResource.class);
        System.out.println(account.getBody());
    }

    public static void downloadFile(){     // This method will download file using RestTemplate
        RestTemplateBuilder restTemplate  = new RestTemplateBuilder();
        String url = "http://localhost:8080/account/getpdf";
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<byte[]> response = restTemplate.build()
                    .exchange(url, HttpMethod.GET, entity, byte[].class);
            //Files.write(Paths.get("demo1.pdf"), response.getBody());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
