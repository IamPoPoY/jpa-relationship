package com.example.jparelationship.repasitory;

import com.example.jparelationship.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    boolean existsByName(String name);

    List<Group> findAllByFaculty_University_Id(Integer faculty_university_id);
}
