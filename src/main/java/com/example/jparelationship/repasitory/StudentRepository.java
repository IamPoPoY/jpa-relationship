package com.example.jparelationship.repasitory;

import com.example.jparelationship.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
