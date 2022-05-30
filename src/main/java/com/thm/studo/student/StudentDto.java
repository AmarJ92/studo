package com.thm.studo.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    private String surname;
    private String lastname;
    private int matNumber;

}
