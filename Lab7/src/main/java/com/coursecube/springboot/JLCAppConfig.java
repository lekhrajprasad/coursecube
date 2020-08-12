package com.coursecube.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class JLCAppConfig {

    @Bean
    public Hai getHai(){
        return new Hai();
    }
	
}
