package com.example.assignment3.Your.Name_COMP303_AssignementNumber.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.Course;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.LabRoom;
import com.example.assignment3.Your.Name_COMP303_AssignementNumber.repositories.LabRoomRepository;

@Service
public class LabRoomService {

    @Autowired
    LabRoomRepository labRoomRepository;

    public LabRoom save(LabRoom entity){
        return labRoomRepository.save(entity);
    }

    public List<LabRoom> getAll(){
        return labRoomRepository.findAll();
    }

    public Optional<LabRoom> getById(String id){
        return labRoomRepository.findById(id);
    }

    public Optional<LabRoom> getByBuildingName(String buildingName){
        return labRoomRepository.findByBuildingNameContains(buildingName);
    }

    

    
}
