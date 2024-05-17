package com.example.assignment3.Your.Name_COMP303_AssignementNumber.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "lab_room")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class LabRoom {

    @Id
    @Column(name = "id")
    String id;
    
    @NotNull
    @Column(name = "building_name", nullable = false, length = 250, unique = true)
    String buildingName;

    @OneToOne
    @JoinColumn(name = "course_id")
    @JsonBackReference
    Course course;
    
}
