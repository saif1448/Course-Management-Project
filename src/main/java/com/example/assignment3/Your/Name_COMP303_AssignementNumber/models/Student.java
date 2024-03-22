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
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private int id;
    private String firstName;
    private String lastName;
    private String dob;
    private String gender;
    private String countryWasBorn;
    private String address;
    private String phone;
    private String email;
    
}
