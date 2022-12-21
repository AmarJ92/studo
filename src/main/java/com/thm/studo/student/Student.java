package com.thm.studo.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity(name = "Student")
@Table(name = "STUDENT")
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    public Student(String surname, String lastname, int matNumber) {
        this.surname = surname;
        this.lastname = lastname;
        this.matNumber = matNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STUDENT_ID")
    private int studentId;

    @NotNull
    @Column(name = "SURNAME")
    private String surname;

    @NotNull
    @Column(name = "LASTNAME")
    private String lastname;

    @NotNull
    @Column(name = "MATNUMBER")
    private int matNumber;
}
