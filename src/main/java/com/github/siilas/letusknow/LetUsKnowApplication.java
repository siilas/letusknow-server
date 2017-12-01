package com.github.siilas.letusknow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class LetUsKnowApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(LetUsKnowApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(LetUsKnowApplication.class);
    }

}
