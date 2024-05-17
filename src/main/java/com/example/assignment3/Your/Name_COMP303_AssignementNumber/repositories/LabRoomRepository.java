package com.example.assignment3.Your.Name_COMP303_AssignementNumber.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assignment3.Your.Name_COMP303_AssignementNumber.models.LabRoom;
import java.util.List;
import java.util.Optional;



@Repository
public interface LabRoomRepository extends JpaRepository<LabRoom, String>{

    public Optional<LabRoom> findByBuildingNameContains(String buildingName);    
}
