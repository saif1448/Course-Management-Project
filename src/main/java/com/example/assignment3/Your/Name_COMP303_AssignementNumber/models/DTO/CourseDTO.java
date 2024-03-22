package com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public record CourseDTO(String courseCode, String courseTitle, String couseHours, String deliverCampus, String deliverMethod) {
    public CourseDTO(String courseCode, String courseTitle, String couseHours, String deliverCampus, String deliverMethod){
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.couseHours = couseHours;
        this.deliverCampus = deliverCampus;
        this.deliverMethod = deliverMethod;
    }
}
