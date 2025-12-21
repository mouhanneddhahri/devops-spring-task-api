package com.example.devopsspringtaskapi;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HelloControllerTest {

    @Autowired
    private HelloController controller;

    @Test
    public void testHello() {
        String response = controller.hello();
        assertEquals("Hello DevOps!", response);
    }
}