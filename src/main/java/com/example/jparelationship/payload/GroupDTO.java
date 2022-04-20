package com.example.jparelationship.payload;

import com.example.jparelationship.entity.Faculty;
import com.example.jparelationship.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupDTO {
    private Integer id;

    private String  name;

    private Faculty faculty;

    private List<Student> students;

}
