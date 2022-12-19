package com.thm.studo.student;

import com.thm.studo.exception.NoSuchStudentFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findStudentById(int studentId){
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchStudentFoundException("No Student found with ID " + studentId));
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

    public void deleteStudent(int studentId) {
        studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchStudentFoundException("No Student found with ID " + studentId));
        studentRepository.deleteById(studentId);
    }
}
