package com.example.jparelationship.service;

import com.example.jparelationship.entity.Group;
import com.example.jparelationship.payload.GroupDTO;
import com.example.jparelationship.repasitory.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    public Group getGroupById(Integer id) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        return optionalGroup.orElseGet(Group::new);
    }

    public String addGroup(GroupDTO groupDTO) {
        boolean existsByName = groupRepository.existsByName(groupDTO.getName());
        if (existsByName){
            return "this group allready exist";
        }
        Group group= new Group();
        group.setName(groupDTO.getName());
        groupRepository.save(group);
        return "group added";
    }

    public List<Group> getAllGoupsByFacultyId(Integer facultyId) {
        return groupRepository.findAllByFaculty_University_Id(facultyId);
    }
}
