package com.example.assignment3.Your.Name_COMP303_AssignementNumber.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.Course;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.DTO.CourseDTO;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.services.CourseServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequestMapping("/courses")
@RestController
public class CourseController {
    @Autowired
    CourseServices courseServices;

    @PostMapping("/create-new")
    public Course createNewCourse(@RequestBody Course course) {

        return courseServices.addNewCourse(course);
    }

    @GetMapping("/get/{id}")
    public Optional<Course> getCourse(@PathVariable int id) {
        return Optional.ofNullable(courseServices.getById(id)).orElseGet(null);

    }

    @GetMapping("/get/all")
    public List<Course> getAllCourses() {
        return courseServices.getAll();
    }

    @PutMapping("/update/{id}")
    public Course updateCourse(@PathVariable int id, @RequestBody CourseDTO course) {
        return courseServices.modifyCourse(id, course);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, String> deleteCourse(@PathVariable int id) {
        Map<String, String> message = new HashMap<>();

        Course course = courseServices.removeCourse(id);
       
        if (course != null) {
            message.put("message", "Record with " + id + " has been deleted");
            message.put("course", course.toString());
        } else {
            message.put("message", "Record wtih " + id + " not found");
            message.put("course", null);
        }

        return message;

    }

}
