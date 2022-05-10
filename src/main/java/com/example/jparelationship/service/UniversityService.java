package com.example.jparelationship.service;

import com.example.jparelationship.entity.Address;
import com.example.jparelationship.entity.University;
import com.example.jparelationship.payload.UniversityDTO;
import com.example.jparelationship.repasitory.AddressRepository;
import com.example.jparelationship.repasitory.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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

    public String editUniversity(Integer id, UniversityDTO universityDTO) {
        Optional<University> optionalUniversity = universityRepository.findById(id);
        if (optionalUniversity.isPresent()) {
            University university = optionalUniversity.get();
            university.setName(universityDTO.getName());

            Address address = university.getAddress();
            address.setHome(universityDTO.getHome());
            address.setDistrict(universityDTO.getDistrict());
            address.setCity(universityDTO.getCity());
            address.setStreet(universityDTO.getStreet());
            university.setAddress(address);
            addressRepository.save(address);

            universityRepository.save(university);
            return "university edited";
        }
        return "university not found";


    }

    public University getUniversity(Integer id) {
        Optional<University> optionalUniversity = universityRepository.findById(id);
        return optionalUniversity.orElse(null);

    }

    public String deleteUniversity(Integer id) {
        Optional<University> optionalUniversity = universityRepository.findById(id);
        if (optionalUniversity.isPresent()) {
            universityRepository.deleteById(id);
            return "university deleted";
        }
        return "university not found";

    }

}
