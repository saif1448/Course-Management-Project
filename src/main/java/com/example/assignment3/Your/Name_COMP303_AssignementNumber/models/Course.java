package com.example.assignment3.Your.Name_COMP303_AssignementNumber.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="course")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String courseCode;
    private String CourseTitle;
    private String couseHours;
    private String deliverCampus;
    private String deliverMethod;

    // DeliverMethod (string, either "online" or "onsite")



}
