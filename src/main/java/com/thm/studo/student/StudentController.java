package com.thm.studo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class StudentController {

    @GetMapping("/students")
    public String hello(){
        return "Hello from studo app";
    }
}
