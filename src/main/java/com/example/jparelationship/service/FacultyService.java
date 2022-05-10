package com.example.jparelationship.service;

import com.example.jparelationship.entity.Faculty;
import com.example.jparelationship.entity.University;
import com.example.jparelationship.payload.FacultyDTO;
import com.example.jparelationship.repasitory.FacultyRepository;
import com.example.jparelationship.repasitory.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class FacultyService {
    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    UniversityRepository universityRepository;

    public String addFaculty(FacultyDTO facultyDTO) {
        if (facultyRepository.existsByNameAndUniversityId(facultyDTO.getName(),
                facultyDTO.getUniversityId())) {
            return "faculty already exist ON THIS UNIVERSITY";
        }
        Faculty faculty = new Faculty();
        faculty.setName(facultyDTO.getName());
        Optional<University> optionalUniversity = universityRepository.findById(facultyDTO.getUniversityId());
        if (optionalUniversity.isPresent()) {
            University university = optionalUniversity.get();
            faculty.setUniversity(university);
            facultyRepository.save(faculty);
            return "faculty saved";

        }
        return "university is not found";
    }

    public String editFaculty(Integer id, FacultyDTO facultyDTO) {
        Optional<Faculty> optionalFaculty = facultyRepository.findById(id);
        if (optionalFaculty.isPresent()){
            Faculty faculty = optionalFaculty.get();
            faculty.setName(facultyDTO.getName());
            Optional<University> optionalUniversity = universityRepository.findById(facultyDTO.getUniversityId());
            if (optionalUniversity.isPresent()) {
                University university = optionalUniversity.get();
                faculty.setUniversity(university);
                facultyRepository.save(faculty);
            }
            return "faculty edited";
        }
        return "faculty is not edited or this faculty not found";
    }

    public Faculty getFacultyById(Integer id) {
        Optional<Faculty> optionalFaculty = facultyRepository.findById(id);
        if (optionalFaculty.isPresent()){
            return optionalFaculty.get();
        }
        return new Faculty();

    }

    public List<Faculty> getAllFacultiesByUniversityId(Integer universityId) {
        facultyRepository.findAllByUniversityId(universityId);
        return null;
    }
}
