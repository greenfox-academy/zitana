package com.greenfoxacademy.springstart.controllers;

import com.greenfoxacademy.springstart.Greeting;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRESTController {
  AtomicLong id = new AtomicLong();

  @RequestMapping(value = "/greeting")
  public Greeting greeting(@RequestParam("name") String name) {
    return new Greeting(id.incrementAndGet(), "Hello " + name + "!");
  }

}
