package com.example.studentendpoint;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    private int id;
    @Column(name = "student_number")
    private String studentNumber;
    @Column(name = "grade")
    private int grade;
}
