package com.test.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Test11 {
    @PostConstruct
    public void testPostConstruct() {
        System.out.println("testPostConstruct--slh");
    }
}
