package com.example.assignment3.Your.Name_COMP303_AssignementNumber.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.Course;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.CourseMaterial;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.DTO.CourseMaterialDTO;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.repositories.CourseMaterialRepository;

import lombok.RequiredArgsConstructor;

@Service
// @RequiredArgsConstructor
public class CourseMaterialService {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Autowired
    private CourseServices courseServices;

    public CourseMaterial createCourseMaterialByCourseId(CourseMaterial material, int courseId) {

        Course parentCourse = courseServices.getById(courseId).get();
        material.setCourse(parentCourse);
        return courseMaterialRepository.save(material);
    }

    public CourseMaterial createCourseMaterial(CourseMaterial material) {
        return courseMaterialRepository.save(material);
    }

    public Optional<CourseMaterial> getById(int id) {
        return courseMaterialRepository.findById(id);
    }

    public List<CourseMaterial> getAll() {
        return courseMaterialRepository.findAll();
    }

    public CourseMaterial modifyCourseMaterial(int id, CourseMaterialDTO courseMaterialDTO) {

        CourseMaterial existingMaterial = courseMaterialRepository.findById(id).get();
        if (courseMaterialDTO.getAuthorName() != null) {
            existingMaterial.setAuthorName(courseMaterialDTO.getAuthorName());
        }
        if (courseMaterialDTO.getMaterialName() != null) {
            existingMaterial.setMaterialName(courseMaterialDTO.getMaterialName());
        }
        if (courseMaterialDTO.getMaterialType() != null) {
            existingMaterial.setMaterialType(courseMaterialDTO.getMaterialType());
        }
        courseMaterialRepository.save(existingMaterial);
        return existingMaterial;
    }

    public CourseMaterial removeCourseMaterialById(int id) {

        Optional<CourseMaterial> entity = courseMaterialRepository.findById(id);
        CourseMaterial courseMaterial = entity.orElse(null);
        if (courseMaterial != null) {
            courseMaterialRepository.delete(courseMaterial);
        }
        return courseMaterial;

    }

}
