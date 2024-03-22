package com.example.assignment3.Your.Name_COMP303_AssignementNumber.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.Student;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.services.StudentServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/student")


public class StudentController {
    @Autowired
    StudentServices studentServices;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentServices.insertStudent(student);
    }

    @GetMapping("/get/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentServices.getById(id);
    }

    @GetMapping("/get/all")
    public List<Student> getAllStudent() {
        return studentServices.getAll();
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentServices.modifyStudent(id, student);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, String> deleteStudent(@PathVariable int id)
    {
        Map<String, String> message = new HashMap<>();
        if(studentServices.removeStudent(id))
        {
            message.put("message", "Record with "+ id + " has been deleted");
        }
        else
        {
            message.put("message", "Record with " + id +" has not found");
        }
        return message;
    }


}
