package com.example.jparelationship.controller;

import com.example.jparelationship.entity.Address;
import com.example.jparelationship.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/getAddresses")
    public List<Address> getAddresses() {
        return addressService.getAddresses();
    }
    @GetMapping("/getAddress/{id}")
    public Address getAddress(@PathVariable Integer id){
        return addressService.getAddress(id);
    }
}
