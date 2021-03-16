package com.jci.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.jci.model.Greeting;
import com.jci.model.Person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

@RestController
public class GreetingController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/")
  public String defaultMessage() {
    return "Welcome to the Spring Boot Application Starter!";
  }

  @GetMapping("/greeting")
  public ResponseEntity<Greeting> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    return new ResponseEntity<>(new Greeting(counter.incrementAndGet(), String.format(template, name)), HttpStatus.OK);
  }

  @PostMapping("/greeting")
  public ResponseEntity<Greeting> greeting(@RequestBody Person person) {
    return new ResponseEntity<Greeting>(
        new Greeting(counter.getAndIncrement(), String.format(template, person.getName())), HttpStatus.OK);
  }
}