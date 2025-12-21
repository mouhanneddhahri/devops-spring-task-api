package com.example.devopsspringtaskapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloController {

    private final List<String> tasks = new ArrayList<>();
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String hello() {
        log.info("Hello endpoint called");
        return "Hello DevOps!";
    }

    @GetMapping("/tasks")
    public List<String> getTasks() {
        return tasks;
    }

    @PostMapping("/tasks")
    public void addTask(@RequestBody String task) {
        log.info("Adding task: {}", task);
        tasks.add(task);
    }
}
