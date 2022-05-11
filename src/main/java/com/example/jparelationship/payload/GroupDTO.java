package com.example.jparelationship.payload;

import com.example.jparelationship.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupDTO {
    private Integer id;

    private String  name;

    private Integer facultyId;
}
