package com.example.jparelationship.controller;

import com.example.jparelationship.entity.Subject;
import com.example.jparelationship.payload.SubjectDTO;
import com.example.jparelationship.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/subjects")

public class SubectController {
    @Autowired
    SubjectService subjectService;

    @PostMapping("/addSubject")
    public String addSubject(@RequestBody SubjectDTO subjectDTO) {
        return subjectService.addSubjject(subjectDTO);
    }


    @GetMapping("/getSubjects")
    public List<Subject> getSubject() {
        return subjectService.getSubjects();
    }

    @GetMapping("/getsubject/{id}")
    public Subject getSubject(@PathVariable Integer id){
        return subjectService.getSubject(id);
    }


    @PutMapping("/editSubject/{id}")
    public String editSubject(@PathVariable Integer id, @RequestBody SubjectDTO subjectDTO) {
        return subjectService.editSubject(id, subjectDTO);
    }


    @DeleteMapping("/deleteSubect/{id}")
    public String deleteSubect(@PathVariable Integer id){
        return subjectService.deleteSubect(id);
    }

}
