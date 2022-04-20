package com.example.jparelationship.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniversityDTO {
    private String name;
    private String city;
    private String district;
    private String street;
    private String home;
}
