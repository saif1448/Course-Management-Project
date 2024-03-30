package com.example.assignment3.Your.Name_COMP303_AssignementNumber.commonModels;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ErrorResponse {
    private Timestamp timestamp;
    private int httpErrorCode;
    private String httpError;
    private List<Map<String, String>> errorList;
}
