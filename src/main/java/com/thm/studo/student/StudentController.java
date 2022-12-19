package com.thm.studo.student;

import com.thm.studo.util.StudentMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    public StudentController(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @PostMapping("/addStudent")
    @ResponseBody
    public void createStudent(@RequestBody StudentDto studentDto){
        Student student = studentMapper.convertToEntity(studentDto);
        studentService.createStudent(student);
    }

    @GetMapping("/getStudent/{studentId}")
    public StudentDto getStudent(@PathVariable int studentId){
        Student student = studentService.findStudentById(studentId);
        return studentMapper.convertToDto(student);
    }

    @GetMapping("/getStudents")
    public List<StudentDto> getAllStudents(){
        return studentService.getAllStudents().stream()
                .map(studentMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/updateStudent")
    @ResponseBody
    public void updateStudent(@RequestBody StudentDto studentDto){
        Student updatedStudent = studentMapper.convertToEntity(studentDto);
        studentService.updateStudent(updatedStudent);
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    @ResponseBody
    public void deleteStudent(@PathVariable int studentId){
        studentService.deleteStudent(studentId);
    }
}
