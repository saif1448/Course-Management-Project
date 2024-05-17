package com.example.assignment3.Your.Name_COMP303_AssignementNumber.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.Course;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.LabRoom;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.services.LabRoomService;

import jakarta.validation.Valid;

@RequestMapping("/labroom")
@RestController
public class LabRoomController {

    @Autowired
    LabRoomService labRoomService;

    @PostMapping("/create-new")
    public ResponseEntity<?> createNewLabroom(@RequestBody LabRoom labroom) {

        return new ResponseEntity<>(labRoomService.save(labroom), HttpStatus.CREATED);
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getAllLabroom() {
        return new ResponseEntity<>(labRoomService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getLabroomJson(@PathVariable String id) {
        // return Optional.ofNullable(courseServices.getById(id)).orElseGet(null);
        LabRoom labRoom = labRoomService.getById(id).orElse(null);

        if (labRoom != null) {
            return new ResponseEntity<>(labRoom, HttpStatus.OK);
        } else {
            Map<String, String> errorResponse = new HashMap<String, String>();
            errorResponse.put("error", "Course was not found fot that ID");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(path = "/getb/{buildingName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getLabroomByBName(@PathVariable String buildingName) {
        // return Optional.ofNullable(courseServices.getById(id)).orElseGet(null);
        LabRoom labRoom = labRoomService.getByBuildingName(buildingName).orElse(null);

        if (labRoom != null) {
            return new ResponseEntity<>(labRoom, HttpStatus.OK);
        } else {
            Map<String, String> errorResponse = new HashMap<String, String>();
            errorResponse.put("error", "Course was not found fot that ID");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

    }

}
