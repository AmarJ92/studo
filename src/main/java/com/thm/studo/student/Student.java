package com.thm.studo.student;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @GeneratedValue
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
