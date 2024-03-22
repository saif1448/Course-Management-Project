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
@Table(name = "enrollment")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String studentId;
    private String courseId;
    private String term;
    private String lateSubPenality;

}
