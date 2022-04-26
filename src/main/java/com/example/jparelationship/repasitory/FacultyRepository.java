package com.example.jparelationship.repasitory;

import com.example.jparelationship.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty,Integer> {

}
