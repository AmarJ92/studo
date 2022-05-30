package com.thm.studo.student;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student){
        studentRepository.save(student);
    }
}
