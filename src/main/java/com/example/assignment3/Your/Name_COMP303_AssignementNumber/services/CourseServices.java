package com.example.assignment3.Your.Name_COMP303_AssignementNumber.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.Course;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.DTO.CourseDTO;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.repositories.CourseRepository;

@Service
public class CourseServices {

    @Autowired
    CourseRepository courseRepository;

    public Course addNewCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> getById(int id) {
        return courseRepository.findById(id);
    }

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Course modifyCourseCode(int id, String courseCode) {
        Course course = courseRepository.findById(id).get();
        course.setCourseCode(courseCode);
        return courseRepository.save(course);
    }

    public Course modifyCourseCourseHours(int id, String courseHours) {
        Course course = courseRepository.findById(id).get();
        course.setCouseHours(courseHours);
        return courseRepository.save(course);
    }

    public Course modifyCourseDeliverCampus(int id, String courseDeliverCampus) {
        Course course = courseRepository.findById(id).get();
        course.setCouseHours(courseDeliverCampus);
        return courseRepository.save(course);
    }

    public Course modifyCourseDeliverMethod(int id, String courseDeliverMethod) {
        Course course = courseRepository.findById(id).get();
        course.setDeliverMethod(courseDeliverMethod);
        return courseRepository.save(course);
    }

    public Course modifyCourseTitle(int id, String courseTitle) {
        Course course = courseRepository.findById(id).get();
        course.setCourseTitle(courseTitle);
        return courseRepository.save(course);
    }

    public Course modifyCourse(int id, CourseDTO courseDto) {
        Course course = new Course();
        if (courseDto.courseCode() != null) {
            course = modifyCourseCode(id, courseDto.courseCode());
        }
        if (courseDto.courseTitle() != null) {
            course = modifyCourseTitle(id, courseDto.courseTitle());
        }
        if (courseDto.couseHours() != null) {
            course = modifyCourseCourseHours(id, courseDto.couseHours());
        }
        if (courseDto.deliverCampus() != null) {
            course = modifyCourseDeliverCampus(id, courseDto.deliverCampus());
        }
        if (courseDto.deliverMethod() != null) {
            course = modifyCourseDeliverMethod(id, courseDto.deliverMethod());
        }

        return course;
    }

    public Course removeCourse(int id) {

        Optional<Course> entity = courseRepository.findById(id);

        Course course = entity.orElse(null);
        if (course != null) {
            courseRepository.delete(course);
        }

        return course;
    }

}
