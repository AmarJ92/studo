package com.thm.studo.student;

import com.thm.studo.util.StudentMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    public StudentController(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @PostMapping("/addStudents")
    @ResponseBody
    public void createStudent(@RequestBody StudentDto studentDto){
        Student student = studentMapper.convertToEntity(studentDto);
        studentService.createStudent(student);
    }
}
