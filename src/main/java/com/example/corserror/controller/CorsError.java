package com.example.corserror.controller;

import com.example.corserror.entity.Student;
import com.example.corserror.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class CorsError {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/login")
    public String CorsErrorMethod(){
         return "Success";
    }


   @PostMapping("/addStident")
   public HttpEntity<?> addStudent(@RequestBody Student student){
       boolean phone = studentRepository.existsByPhone(student.getPhone());
       if (phone){
           return ResponseEntity.status(407).body("This phone is available");
       }
       Student student1 = new Student(student.getAge(), student.getUsername(),student.getPhone());
        Student save = studentRepository.save(student1);
        return ResponseEntity.ok("addStudent");
   }

   @GetMapping("getStudent")
   HttpEntity<?> getStudent(){
       List<Student> all = studentRepository.findAll();
       return ResponseEntity.status(201).body(all);
   }

     // age
     @GetMapping("getStudentAge")
     HttpEntity<?> getStudentAge(){
         List<Student> all = studentRepository.findAll();

         return ResponseEntity.status(201).body(all);
     }



}
