package com.thm.studo.student;

import com.thm.studo.util.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @PostMapping
    @ResponseBody
    public void createStudent(@RequestBody StudentDto studentDto){
        Student student = studentMapper.convertToEntity(studentDto);
        studentService.createStudent(student);
    }

    @GetMapping("{studentId}")
    public StudentDto getStudent(@PathVariable int studentId){
        Student student = studentService.findStudentById(studentId);
        return studentMapper.convertToDto(student);
    }

    @GetMapping
    public List<StudentDto> getAllStudents(){
        return studentService.getAllStudents().stream()
                .map(studentMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @PutMapping
    @ResponseBody
    public void updateStudent(@RequestBody StudentDto studentDto){
        Student updatedStudent = studentMapper.convertToEntity(studentDto);
        studentService.updateStudent(updatedStudent);
    }

    @DeleteMapping("{studentId}")
    @ResponseBody
    public void deleteStudent(@PathVariable int studentId){
        studentService.deleteStudent(studentId);
    }
}
