package com.example.jparelationship.repasitory;

import com.example.jparelationship.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group,Integer> {
}
