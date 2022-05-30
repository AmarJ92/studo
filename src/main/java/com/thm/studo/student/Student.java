package com.thm.studo.student;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "Student")
@Table(name = "STUDENT")
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int studentId;
    @Column(name = "SURNAME",
            nullable = false)
    private String surname;
    @Column(name = "LASTNAME",
            nullable = false)
    private String lastname;
    @Column(name = "MATNUMBER",
            nullable = false)
    private int matNumber;

    public Student(String surname, String lastname, int matNumber) {
        this.surname = surname;
        this.lastname = lastname;
        this.matNumber = matNumber;
    }
}
