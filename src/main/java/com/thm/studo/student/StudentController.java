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

    @GetMapping("/getStudent/{studentId}")
    public StudentDto getStudent(@PathVariable int studentId){
        Student student = studentService.findStudentById(studentId);

        return studentMapper.convertToDto(student);
    }

    @GetMapping("/getStudents")
    public List<StudentDto> getAllStudents(){
        List<Student> allStudents = studentService.getAllStudents();

        return allStudents.stream()
                .map(studentMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/addStudents")
    @ResponseBody
    public void createStudent(@RequestBody StudentDto studentDto){
        Student student = studentMapper.convertToEntity(studentDto);
        studentService.createStudent(student);
    }

    @PutMapping("/updateStudent/{studentId}")
    @ResponseBody
    public void updateStudent(@PathVariable int studentId, @RequestBody StudentDto studentDto){
        Student student = studentMapper.convertToEntity(studentDto);
        studentService.updateStudent(studentId, student);
    }

    @DeleteMapping("/deleteStudent")
    @ResponseBody
    public void deleteStudent(@RequestBody StudentDto studentDto){
        Student student = studentMapper.convertToEntity(studentDto);
        studentService.deleteStudent(student);
    }
}
