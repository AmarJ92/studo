package com.thm.studo.student;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/addStudents")
    @ResponseBody
    public String createStudent(@RequestParam String surname,
                                @RequestParam String lastname,
                                @RequestParam int matNumber){
        return "Hello from studo app";
    }
}
