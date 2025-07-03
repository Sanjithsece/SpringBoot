package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController // Combines @Controller + @ResponseBody
public class Hello {

    @GetMapping
    public String hello() {
        System.out.println("spring boot");
        return "Sri Ram";
    }


//    @PostMapping("/in")
//    public String sanjith(@RequestBody RequestName request) {
//        System.out.println("hi " + request.getName());
//        return "Received: " + request.getName();
//    }
    
@PostMapping("/in")
public String sanjith(@RequestBody  String request) {
    System.out.println("hi " + request);
    return "Received: " + request;
}
}


class RequestName {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
