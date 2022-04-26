package com.example.jparelationship.service;

import com.example.jparelationship.entity.Subject;
import com.example.jparelationship.payload.SubjectDTO;
import com.example.jparelationship.repasitory.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public String addSubjject(SubjectDTO subjectDTO) {
        boolean existsByName = subjectRepository.existsByName(subjectDTO.getName());
        if (!existsByName) {
            Subject subject = new Subject();
            subject.setName(subjectDTO.getName());
            subjectRepository.save(subject);
            return "subject edded";
        }
        return "subject already exists";
    }

    public List<Subject> getSubjects() {
        List<Subject> subjectList = subjectRepository.findAll();
        return subjectList;

    }


    public String editSubject(Integer id, SubjectDTO subjectDTO) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isPresent()) {
            Subject subject = optionalSubject.get();
            subject.setName(subjectDTO.getName());
            subjectRepository.save(subject);
            return "subject edited";
        }
        return "subject not found";
    }

    public Subject getSubject(Integer id) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isPresent()) {
            Subject subject = optionalSubject.get();
            return subject;
        }
        Subject subject = new Subject();
        return subject;
    }

    public String deleteSubect(Integer id) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isPresent()) {
            subjectRepository.deleteById(id);
            return "Subject deleted";
        }
        return "Subject not found";
    }
}
