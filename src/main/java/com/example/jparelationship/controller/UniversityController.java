package com.example.jparelationship.controller;

import com.example.jparelationship.entity.University;
import com.example.jparelationship.payload.UniversityDTO;
import com.example.jparelationship.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/university"))

public class UniversityController {
    @Autowired
    UniversityService universityService;

    @GetMapping
    public List<University> getUniversity() {

        return universityService.getAllUniversities();
    }

    @PostMapping
    public String addUniversity(@RequestBody UniversityDTO universityDTO) {
        return universityService.addUniversity(universityDTO);
    }

}
