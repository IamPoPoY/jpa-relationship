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

    @GetMapping("/getAllUniversities")
    public List<University> getUniversity() {

        return universityService.getAllUniversities();
    }

    @PostMapping("/addUniversity")
    public String addUniversity(@RequestBody UniversityDTO universityDTO) {
        return universityService.addUniversity(universityDTO);
    }

    @PutMapping("/editUniversity/{id}")
    public String editUniversity(@PathVariable Integer id,@RequestBody UniversityDTO universityDTO){
        return universityService.editUniversity(id,universityDTO);
    }
    @GetMapping("/getUniversity/{id}")
    public University getUniversity(@PathVariable Integer id){
        return universityService.getUniversity(id);
    }
    @DeleteMapping("/deleteUniversity/{id}")
    public String deleteUniversity(@PathVariable Integer id){
        return universityService.deleteUniversity(id);
    }


}
