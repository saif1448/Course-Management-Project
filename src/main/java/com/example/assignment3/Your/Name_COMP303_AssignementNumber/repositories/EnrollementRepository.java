package com.example.assignment3.Your.Name_COMP303_AssignementNumber.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.Enrollment;

@Repository
public interface EnrollementRepository extends JpaRepository< Enrollment, Integer> {

    
}
