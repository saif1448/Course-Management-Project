package com.example.assignment3.Your.Name_COMP303_AssignementNumber.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.Enrollment;

@Service
public class EnrollmentServices {
    List<Enrollment> enrollmentList = new ArrayList<>();

    public Enrollment insertEnrollment(Enrollment enrollment) {
        enrollmentList.add(enrollment);
        return enrollment;
    }

    public Enrollment getById(int id) {
        for (Enrollment enrollment : enrollmentList) {
            if (enrollment.getId() == id) {
                return enrollment;
            }
        }
        return null;
    }

    public List<Enrollment> getAll() {
        return enrollmentList;
    }

    public Enrollment modifyEnrollment(int id, Enrollment enrollment) {
        for (int i = 0; i < enrollmentList.size(); i++) {

            if (enrollmentList.get(i).getId() == id) {
                enrollmentList.set(i, enrollment);
                return enrollmentList.get(i);
            }
        }
        return null;

    }

    public boolean removeEnrollment(int id) {
        if(getById(id)!= null)
        {
            enrollmentList.remove(getById(id));
            return true;
        }
        else
        {
            return false;
        }
      
     
    }


}
