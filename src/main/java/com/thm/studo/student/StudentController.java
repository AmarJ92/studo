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

    @GetMapping
    public StudentDto getStudent(int studentId){
        Student student = studentService.findStudentById(studentId);
        StudentDto studentDto = studentMapper.convertToDto(student);
        return studentDto;
    }

    @PostMapping("/addStudents")
    @ResponseBody
    public void createStudent(@RequestBody StudentDto studentDto){
        Student student = studentMapper.convertToEntity(studentDto);
        studentService.createStudent(student);
    }

    @PutMapping("/updateStudent")
    @ResponseBody
    public void updateStudent(@RequestBody StudentDto studentDto){
        Student student = studentMapper.convertToEntity(studentDto);
        studentService.updateStudent(student);
    }

    @DeleteMapping("/deleteStudent")
    @ResponseBody
    public void deleteStudent(@RequestBody StudentDto studentDto){
        Student student = studentMapper.convertToEntity(studentDto);
        studentService.deleteStudent(student);
    }
}
