package com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.DTO;

public record StudentDTO(String firstName, String lastName, String dob, String gender,
        String countryWasBorn, String address, String phone, String email) {
public StudentDTO(String firstName, String lastName, String dob, String gender, String countryWasBorn,
            String address, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.countryWasBorn = countryWasBorn;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

}
