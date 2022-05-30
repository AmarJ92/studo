package com.thm.studo.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private int studentId;
    private String surname;
    private String lastname;
    private int matNumber;

}
