package com.example.assignment3.Your.Name_COMP303_AssignementNumber.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.Course;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.CourseMaterial;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.services.CourseMaterialService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/course-material")

public class CourseMaterialController {

    @Autowired
    private CourseMaterialService courseMaterialService;

    @PostMapping("/create-new/{courseId}")
    public ResponseEntity<?> createNewCourse(@PathVariable int courseId,
            @Valid @RequestBody CourseMaterial courseMaterial) {

        return new ResponseEntity<>(courseMaterialService.createCourseMaterialByCourseId(courseMaterial, courseId),
                HttpStatus.CREATED);
    }

    @PostMapping("/create-new")
    public ResponseEntity<?> createNewCourse(@Valid @RequestBody CourseMaterial courseMaterial) {

        return new ResponseEntity<>(courseMaterialService.createCourseMaterial(courseMaterial),
                HttpStatus.CREATED);
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getAllCourses() {
        return new ResponseEntity<>(courseMaterialService.getAll(), HttpStatus.OK);
    }

}
