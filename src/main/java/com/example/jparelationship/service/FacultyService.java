package com.example.jparelationship.service;

import com.example.jparelationship.entity.Faculty;
import com.example.jparelationship.entity.University;
import com.example.jparelationship.payload.FacultyDTO;
import com.example.jparelationship.repasitory.FacultyRepository;
import com.example.jparelationship.repasitory.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public class FacultyService {
    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    UniversityRepository universityRepository;

    public String addFaculty(FacultyDTO facultyDTO) {
        Faculty faculty=new Faculty();
        faculty.setName(facultyDTO.getName());
        Optional<University> optionalUniversity = universityRepository.findById(facultyDTO.getUniversityId());
        if (optionalUniversity.isPresent()){
            University university = optionalUniversity.get();
            faculty.setUniversity(university);
            facultyRepository.save(faculty);
            return "faculty saved";

        }
        return "faculty already exist";

    }
}
