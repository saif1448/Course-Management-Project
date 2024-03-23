package com.example.assignment3.Your.Name_COMP303_AssignementNumber.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.Enrollment;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.DTO.EnrollmentDTO;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.repositories.EnrollementRepository;

@Service
public class EnrollmentServices {
    @Autowired
    EnrollementRepository enrollementRepository;

    public Enrollment addNewEnrollment(Enrollment enrollment) {
        return enrollementRepository.save(enrollment);
    }

    public Optional<Enrollment> getById(int id) {
        return enrollementRepository.findById(id);
    }

    public List<Enrollment> getAll() {
        return enrollementRepository.findAll();

    }

    public Enrollment modifyStudentId(int id, String studentId) {
        Enrollment enrollment = enrollementRepository.findById(id).get();
        enrollment.setStudentId(studentId);
        return enrollementRepository.save(enrollment);

    }

    public Enrollment modifyCourseId(int id, String courseId) {
        Enrollment enrollment = enrollementRepository.findById(id).get();
        enrollment.setCourseId(courseId);
        return enrollementRepository.save(enrollment);
    }

    public Enrollment modifyTerm(int id, String term) {
        Enrollment enrollment = enrollementRepository.findById(id).get();
        enrollment.setTerm(term);
        return enrollementRepository.save(enrollment);
    }

    public Enrollment modifyLatePenality(int id, String lateSubPenality) {
        Enrollment enrollment = enrollementRepository.findById(id).get();
        enrollment.setLateSubPenality(lateSubPenality);
        return enrollementRepository.save(enrollment);
    }

    public Enrollment modifyEnrollment(int id, EnrollmentDTO enrollmentDTO) {

        Enrollment enrollment = new Enrollment();
        if (enrollmentDTO.studentId() != null) {
            enrollment = modifyStudentId(id, enrollmentDTO.studentId());
        }
        if (enrollmentDTO.courseId() != null) {
            enrollment = modifyCourseId(id, enrollmentDTO.courseId());
        }
        if (enrollmentDTO.term() != null) {
            enrollment = modifyTerm(id, enrollmentDTO.term());
        }
        if (enrollmentDTO.lateSubPenality() != null) {
            enrollment = modifyLatePenality(id, enrollmentDTO.lateSubPenality());
        }
        return enrollment;

    }
}
