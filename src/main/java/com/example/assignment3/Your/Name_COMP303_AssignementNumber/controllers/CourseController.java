package com.example.assignment3.Your.Name_COMP303_AssignementNumber.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment3.Your.Name_COMP303_AssignementNumber.commonModels.ErrorResponse;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.Course;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.DTO.CourseDTO;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.services.CourseServices;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequestMapping("/courses")
@RestController
public class CourseController {
    @Autowired
    CourseServices courseServices;

    @PostMapping("/create-new")
    public ResponseEntity<?> createNewCourse(@Valid @RequestBody Course course) {

        // return courseServices.addNewCourse(course);
        return new ResponseEntity<>(courseServices.addNewCourse(course), HttpStatus.CREATED);
    }

    @GetMapping(path = "/get/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> getCourse(@PathVariable int id) {
        // return Optional.ofNullable(courseServices.getById(id)).orElseGet(null);
        Course course = courseServices.getById(id).orElse(null);

        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            Map<String, String> errorResponse = new HashMap<String, String>();
            errorResponse.put("error", "Course was not found fot that ID");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(path = "/get/json/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCourseJson(@PathVariable int id) {
        // return Optional.ofNullable(courseServices.getById(id)).orElseGet(null);
        Course course = courseServices.getById(id).orElse(null);

        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            Map<String, String> errorResponse = new HashMap<String, String>();
            errorResponse.put("error", "Course was not found fot that ID");

            Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
            HttpStatus status = HttpStatus.BAD_REQUEST;
            int httpErrorCode = status.value();
            String httpError = status.toString();
            List<Map<String, String>> errorList = new ArrayList<>();

            errorList.add(errorResponse);

            ErrorResponse erResponse = new ErrorResponse().builder().timestamp(timestamp)
                                        .httpError(httpError)
                                        .httpErrorCode(httpErrorCode)
                                        .errorList(errorList).build();

            return new ResponseEntity<>(erResponse, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getAllCourses() {
        return new ResponseEntity<>(courseServices.getAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody CourseDTO course) {
        return new ResponseEntity<>(courseServices.modifyCourse(id, course), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {
        Map<String, String> message = new HashMap<>();

        boolean isDeleted = courseServices.removeCourse(id);
        HttpStatus status = null;
        if (isDeleted) {
            message.put("message", "Record with " + id + " has been deleted");
            message.put("course id:", id+"");
            status = HttpStatus.ACCEPTED;

        } else {
            message.put("message", "Record wtih " + id + " not found");
            message.put("course", null);
            status = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(message, status);

    }

    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ResponseEntity<?>
    // handleMethodArgumentValidException(MethodArgumentNotValidException exception)
    // {
    // var errors = new HashMap<String, String>();
    // exception.getBindingResult().getAllErrors()
    // .forEach(e -> {
    // var fieldName = ((FieldError) e).getField();
    // var errorMessage = e.getDefaultMessage();
    // errors.put(fieldName, errorMessage);
    // });
    // return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    // }

    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ResponseEntity<?>
    // handleInvalidArgumentsForCourse(MethodArgumentNotValidException exception) {

    // Map<String, String> errors = new HashMap<String, String>();

    // for (var error : exception.getBindingResult().getAllErrors()) {
    // String fieldName = ((FieldError) error).getField();
    // String errorMessage = error.getDefaultMessage();
    // errors.put(fieldName, errorMessage);
    // }
    // return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

    // }

}
