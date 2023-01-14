package com.example.corserror.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String phone;

    public Student(int age, String username, String phone) {
        this.age = age;
        this.username = username;
        this.phone = phone;
    }
}
