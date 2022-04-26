package com.example.jparelationship.controller;

import com.example.jparelationship.payload.FacultyDTO;
import com.example.jparelationship.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/faculty")

public class FacultyController {
    @Autowired
    FacultyService facultyService;



    @PostMapping("/addFaculty")
    public String addFaculty(@RequestBody FacultyDTO facultyDTO){
      return facultyService.addFaculty(facultyDTO);
    }



}
