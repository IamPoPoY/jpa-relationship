package com.example.jparelationship.controller;

import com.example.jparelationship.entity.Faculty;
import com.example.jparelationship.payload.FacultyDTO;
import com.example.jparelationship.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/faculty")

public class FacultyController {
    @Autowired
    FacultyService facultyService;

    @PostMapping("/addFaculty")
    public String addFaculty(@RequestBody FacultyDTO facultyDTO) {
        return facultyService.addFaculty(facultyDTO);
    }

    @PutMapping("/editFaculty/{id}")
    public String editFaculty(@PathVariable Integer id, @RequestBody FacultyDTO facultyDTO) {
        return facultyService.editFaculty(id, facultyDTO);
    }

    @GetMapping("/getFacultyByID/{id}")
    public Faculty getFacultyById(@PathVariable Integer id) {
        return facultyService.getFacultyById(id);
    }
    @GetMapping("/byUniversityId/{universityId}")
    public List<Faculty> getAllFacultiesByUniversityId(@PathVariable Integer universityId){
        return facultyService.getAllFacultiesByUniversityId(universityId);
    }
    @DeleteMapping("/deleteFaculty/{id}")
    public String deleteFaculty(@PathVariable Integer id){
       return facultyService.deleteFaculty(id);
    }


}
