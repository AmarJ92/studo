package com.thm.studo.student;

import com.thm.studo.exception.NoSuchStudentFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findStudentById(int studentId){
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        studentOptional.orElseThrow(() -> new NoSuchStudentFoundException("No Student found with ID " + studentId));
        return studentOptional.get();
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void createStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Student updatedStudent) {
        studentRepository.findById(updatedStudent.getStudentId())
                .orElseThrow(() -> new NoSuchStudentFoundException("No Student found with ID " + updatedStudent.getStudentId()));
        studentRepository.save(updatedStudent);
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }
}
