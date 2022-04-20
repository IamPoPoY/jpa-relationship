package com.example.jparelationship.repasitory;

import com.example.jparelationship.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {
}
