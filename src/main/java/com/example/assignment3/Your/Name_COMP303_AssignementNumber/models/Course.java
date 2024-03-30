package com.example.assignment3.Your.Name_COMP303_AssignementNumber.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "course")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @NotBlank
    @Pattern(regexp = "[A-Z]{2}\\d{4}")
    private String courseCode;
    @NotNull
    @NotBlank(message = "Course Title cannot be empty or blank")
    private String CourseTitle;
    @NotNull
    @NotBlank
    private String couseHours;
    @NotNull
    @NotBlank
    private String deliverCampus;
    @NotNull
    @NotBlank
    private String deliverMethod;

}
