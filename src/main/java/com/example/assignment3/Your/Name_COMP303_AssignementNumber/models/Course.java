package com.example.assignment3.Your.Name_COMP303_AssignementNumber.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "course")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
// @JacksonXmlRootElement(localName = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @JsonIgnore
    private int id;
    @NotNull
    @NotBlank
    @Pattern(regexp = "[A-Z]{2}\\d{4}")
    private String courseCode;
    @NotNull
    @NotBlank(message = "Course Title cannot be empty or blank")
    @JacksonXmlProperty(localName = "Title")
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

    @OneToMany(mappedBy = "course",
    cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<CourseMaterial> courseMaterials;

    @OneToOne(mappedBy = "course",  cascade = CascadeType.ALL)
    @JsonManagedReference
    LabRoom labRoom;

}
