package com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.DTO;

public record EnrollmentDTO(String studentId, String courseId, String term, String lateSubPenality) {
    public EnrollmentDTO(String studentId, String courseId, String term, String lateSubPenality) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.term = term;
        this.lateSubPenality = lateSubPenality;
    }

}
