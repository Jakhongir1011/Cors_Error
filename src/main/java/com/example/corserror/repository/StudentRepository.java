package com.example.corserror.repository;

import com.example.corserror.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByPhone(String phone);

}
