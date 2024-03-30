package com.example.assignment3.Your.Name_COMP303_AssignementNumber.controllers;
import org.springframework.web.bind.annotation.RestController;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.Enrollment;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.DTO.EnrollmentDTO;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.services.EnrollmentServices;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/enrollment")

public class EnrollmentController {
    @Autowired
    EnrollmentServices enrollmentServices;

    @PostMapping("/create")
    public Enrollment createNewEnrollment(@Valid @RequestBody Enrollment enrollment) {
        return enrollmentServices.addNewEnrollment(enrollment);
    }

    @GetMapping("/get/{id}")
    public Optional<Enrollment> getEnrollment(@PathVariable int id) {
        return Optional.ofNullable(enrollmentServices.getById(id)).orElseGet(null);
    }

    @GetMapping("/get/all")
    public List<Enrollment> getAllEnrollment() {
        return enrollmentServices.getAll();
    }

    @PutMapping("/update/{id}")
    public Enrollment updateEnrollment(@PathVariable int id, @RequestBody EnrollmentDTO enrollmentDTO) {
        return enrollmentServices.modifyEnrollment(id, enrollmentDTO);
    }

    // @DeleteMapping("/delete/{id}")
    //  public Map<String, String> deleteEnrollment(@PathVariable int id)
    //  {
    //     Map<String, String> message = new HashMap<>();
    //     if(enrollmentServices.removeEnrollment(id))
    //     {
    //         message.put("message", "Record with "+id+" has been deleted");
    //     }
    //     else
    //     {
    //         message.put("message", "Recoord with "+ id+ " has not found");
    //     }

    //     return message;

    //  }

}
