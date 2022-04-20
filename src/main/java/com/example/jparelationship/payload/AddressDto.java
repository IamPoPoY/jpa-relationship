package com.example.jparelationship.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AddressDto {
    private Integer id;
    private String city;
    private String district;
    private String street;
    private String home;
}
