package com.example.jparelationship.service;

import com.example.jparelationship.entity.Address;
import com.example.jparelationship.repasitory.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class AddressService {
    private final AddressRepository addressRepository;

    public List<Address> getAddresses() {
        List<Address> all = addressRepository.findAll();
        if (!all.isEmpty()) {
            return all;
        }
        return new ArrayList<>();
    }

    public Address getAddress(Integer id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        return optionalAddress.orElseGet(Address::new);
    }
    }