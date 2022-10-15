package com.thm.studo.student;

import com.thm.studo.exception.NoSuchStudentFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findStudentById(int studentId){
        Optional<Student> studentRepositoryById = studentRepository.findById(studentId);
        studentRepositoryById.orElseThrow(() -> new NoSuchStudentFoundException("No Student found with ID " + studentId));
        return studentRepositoryById.get();
    }

    public void createStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }
}
