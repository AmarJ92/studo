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
    public String createStudent(@RequestBody StudentDto studentDto){
        return "Hello from studo app";
    }
}
