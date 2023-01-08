package com.thm.studo.student;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Optional.of;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentService underTest;

    @Test
    void canGetAllStudents() {
        // when
        underTest.getAllStudents();

        // then
        verify(studentRepository).findAll();
    }

    @Test
    void canGetAllStudentsWithData() {
        // given
        Student student1 = new Student("Amar", "Javid", 12345);
        Student student2 = new Student("Jamila", "Ahmad", 54321);
        Student student3 = new Student("Joana", "Cate", 87654);
        List<Student> studentList = Stream.of(student1, student2, student3).collect(Collectors.toList());

        // when
        when(studentRepository.findAll()).thenReturn(studentList);
        List<Student> allPersistedStudents = underTest.getAllStudents();

        // then
        verify(studentRepository, times(1)).findAll();
        assertEquals(allPersistedStudents, studentList);
    }

    @Test
    void canCreateStudent() {
        // given
        Student student = new Student("Amar", "Javid", 12345);

        // when
        underTest.createStudent(student);

        // then
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
        verify(studentRepository, times(1)).save(studentArgumentCaptor.capture()); // capture the student values
        Student capturedStudent = studentArgumentCaptor.getValue();

        assertThat(capturedStudent).isEqualTo(student);
    }

    @Test
    void canUpdateStudent() {
        // given
        Student student = new Student(1,"Amar", "Javid", 12345);

        when(studentRepository.findById(student.getStudentId())).thenReturn(of(student));

        // when
        Student studentToBeUpdated = underTest.findStudentById(student.getStudentId());
        studentToBeUpdated.setSurname("Anton");
        underTest.updateStudent(studentToBeUpdated);
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
        verify(studentRepository, times(1)).save(studentArgumentCaptor.capture());
        Student capturedStudent = studentArgumentCaptor.getValue();

        // then
        assertThat("Anton").isEqualTo(capturedStudent.getSurname());
    }

    @Test
    void canDeleteStudent() {
        // given
        Student student = new Student(1,"Amar", "Javid", 12345);
        when(studentRepository.findById(student.getStudentId())).thenReturn(of(student));

        // when
        underTest.deleteStudent(student.getStudentId());

        // then
        verify(studentRepository, times(1)).deleteById(student.getStudentId());
    }
}