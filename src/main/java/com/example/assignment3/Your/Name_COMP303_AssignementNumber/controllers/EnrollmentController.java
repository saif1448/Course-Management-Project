package com.example.assignment3.Your.Name_COMP303_AssignementNumber.controllers;
import org.springframework.web.bind.annotation.RestController;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.Enrollment;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.services.EnrollmentServices;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/enrollment")

public class EnrollmentController {
    @Autowired
    EnrollmentServices enrollmentServices;

    @PostMapping("/create")
    public Enrollment createCEnrollment(@RequestBody Enrollment courseEnrollment) {
        return enrollmentServices.insertEnrollment(courseEnrollment);
    }

    @GetMapping("/get/{id}")
    public Enrollment getEnrollment(@PathVariable int id) {
        return enrollmentServices.getById(id);
    }

    @GetMapping("/get/all")
    public List<Enrollment> getAllEnrollment() {
        return enrollmentServices.getAll();
    }

    @PutMapping("/update/{id}")
    public Enrollment updateEnrollment(@PathVariable int id, @RequestBody Enrollment enrollment) {
        return enrollmentServices.modifyEnrollment(id, enrollment);
    }

    @DeleteMapping("/delete/{id}")
     public Map<String, String> deleteEnrollment(@PathVariable int id)
     {
        Map<String, String> message = new HashMap<>();
        if(enrollmentServices.removeEnrollment(id))
        {
            message.put("message", "Record with "+id+" has been deleted");
        }
        else
        {
            message.put("message", "Recoord with "+ id+ " has not found");
        }

        return message;

     }

}
