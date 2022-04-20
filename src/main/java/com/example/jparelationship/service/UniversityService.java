package com.example.jparelationship.service;

import com.example.jparelationship.entity.Address;
import com.example.jparelationship.entity.University;
import com.example.jparelationship.payload.UniversityDTO;
import com.example.jparelationship.repasitory.AddressRepository;
import com.example.jparelationship.repasitory.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {
    @Autowired
    UniversityRepository universityRepository;
    @Autowired
    AddressRepository addressRepository;

    public List<University> getAllUniversities() {
        List<University> universities = universityRepository.findAll();
        return universities;
    }


    public String addUniversity(UniversityDTO universityDTO) {
        Address address = new Address();
        address.setCity(universityDTO.getCity());
        address.setDistrict(universityDTO.getDistrict());
        address.setStreet(universityDTO.getStreet());
        address.setHome(universityDTO.getHome());
        Address savedAddress = addressRepository.save(address);
        University university = new University();
        university.setAddress(savedAddress);
        university.setName(universityDTO.getName());
        universityRepository.save(university);
        return "University added";
    }
}
