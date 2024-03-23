package com.example.assignment3.Your.Name_COMP303_AssignementNumber.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.Student;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.DTO.StudentDTO;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.repositories.StudentReposirory;

@Service
public class StudentServices {

    @Autowired
    StudentReposirory studentReposirory;

    public Student addNewtStudent(Student student) {
        return studentReposirory.save(student);

    }

    @SuppressWarnings("rawtypes")
    public Optional getById(int id) {
        return studentReposirory.findById(id);

    }

    public List<Student> getAll() {
        return studentReposirory.findAll();

    }

    public Student modifyFirstName(int id, String firstName) {
        Student student = studentReposirory.findById(id).get();
        student.setFirstName(firstName);
        return studentReposirory.save(student);

    }

    public Student modifyLastName(int id, String lastName) {
        Student student = studentReposirory.findById(id).get();
        student.setLastName(lastName);
        return studentReposirory.save(student);
    }

    public Student modifyDob(int id, String dob) {
        Student student = studentReposirory.findById(id).get();
        student.setDob(dob);
        return studentReposirory.save(student);
    }

    public Student modifyGender(int id, String gender) {
        Student student = studentReposirory.findById(id).get();
        student.setAddress(gender);
        return studentReposirory.save(student);
    }

    public Student modifyCountryWasBorn(int id, String countryWasBorn) {
        Student student = studentReposirory.findById(id).get();
        student.setCountryWasBorn(countryWasBorn);
        return studentReposirory.save(student);
    }

    public Student modifyAddress(int id, String address) {
        Student student = studentReposirory.findById(id).get();
        student.setAddress(address);
        return studentReposirory.save(student);
    }

    public Student modifyPhone(int id, String phone) {
        Student student = studentReposirory.findById(id).get();
        student.setPhone(phone);
        return studentReposirory.save(student);
    }

    public Student modifyEmail(int id, String email) {
        Student student = studentReposirory.findById(id).get();
        student.setEmail(email);
        return studentReposirory.save(student);
    }

    public Student modifyStudent(int id, StudentDTO studentDTO) {

        Student student = new Student();

        if (studentDTO.firstName() != null) {
            student = modifyFirstName(id, studentDTO.firstName());
        }
        if (studentDTO.lastName() != null) {
            student = modifyLastName(id, studentDTO.lastName());
        }
        if (studentDTO.dob() != null) {
            student = modifyGender(id, studentDTO.dob());
        }
        if (studentDTO.gender() != null) {
            student = modifyGender(id, studentDTO.gender());
        }
        if (studentDTO.countryWasBorn() != null) {
            student = modifyAddress(id, studentDTO.countryWasBorn());
        }
        if (studentDTO.address() != null) {
            student = modifyAddress(id, studentDTO.address());
        }
        if (studentDTO.phone() != null) {
            student = modifyPhone(id, studentDTO.phone());
        }
        if (studentDTO.email() != null) {
            student = modifyEmail(id, studentDTO.email());
        }
        return student;

    }

}
