package com.thm.studo.util;

import com.thm.studo.student.Student;
import com.thm.studo.student.StudentDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    private ModelMapper modelMapper;

    public StudentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Student convertToEntity(StudentDto studentDto){
        return modelMapper.map(studentDto, Student.class);
    }

    public StudentDto convertToDto(Student student){
        return modelMapper.map(student, StudentDto.class);
    }
}
