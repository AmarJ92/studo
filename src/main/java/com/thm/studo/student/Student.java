package com.thm.studo.student;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity(name = "Student")
@Table(name = "STUDENT")
@NoArgsConstructor
public class Student {

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
