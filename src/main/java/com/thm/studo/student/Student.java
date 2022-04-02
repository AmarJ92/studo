package com.thm.studo.student;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Id;

@AllArgsConstructor
@Data
public class Student {

    @Id
    private int studentId;
    private String surname;
    private String lastname;
    private int matNumber;
}
