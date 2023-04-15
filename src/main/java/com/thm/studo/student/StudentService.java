package com.thm.studo.student;

import com.thm.studo.exception.NoSuchStudentFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private static final String NO_STUDENT_FOUND_WITH_ID = "No Student found with ID ";
    private final StudentRepository studentRepository;

    public Student findStudentById(int studentId){
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchStudentFoundException(NO_STUDENT_FOUND_WITH_ID + studentId));
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void createStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Student updatedStudent) {
        studentRepository.findById(updatedStudent.getStudentId())
                .orElseThrow(() -> new NoSuchStudentFoundException(NO_STUDENT_FOUND_WITH_ID + updatedStudent.getStudentId()));
        studentRepository.save(updatedStudent);
    }

    public void deleteStudent(int studentId) {
        studentRepository.findById(studentId)
                .orElseThrow(() -> new NoSuchStudentFoundException(NO_STUDENT_FOUND_WITH_ID + studentId));
        studentRepository.deleteById(studentId);
    }
}
