package com.example.jparelationship.service;

import com.example.jparelationship.entity.Faculty;
import com.example.jparelationship.entity.Group;
import com.example.jparelationship.payload.GroupDTO;
import com.example.jparelationship.repasitory.FacultyRepository;
import com.example.jparelationship.repasitory.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;
    private final FacultyRepository facultyRepository;

    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    public Group getGroupById(Integer id) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        return optionalGroup.orElseGet(Group::new);
    }

    public String addGroup(GroupDTO groupDTO) {
        boolean existsByName = groupRepository.existsByName(groupDTO.getName());
        if (existsByName) {
            return "this group already exist";
        }
        Group group = new Group();
        group.setName(groupDTO.getName());
        Optional<Faculty> optionalFaculty = facultyRepository.findById(groupDTO.getFacultyId());
        if (!optionalFaculty.isPresent()) {
            return "this groups faculty is not found";
        }
        Faculty faculty = optionalFaculty.get();
        group.setFaculty(faculty);
        groupRepository.save(group);
        return "group added";
    }

    public List<Group> getAllGroupsByFacultyId(Integer facultyId) {
        return groupRepository.findAllByFaculty_University_Id(facultyId);
    }

    public Group editGroup(Integer id, GroupDTO groupDTO) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if (!optionalGroup.isPresent()) {
            return new Group();
        }
        Group group = optionalGroup.get();
        group.setName(groupDTO.getName());
        Optional<Faculty> optionalFaculty = facultyRepository.findById(groupDTO.getFacultyId());
        if (!optionalFaculty.isPresent()) {
           return new Group();
        }
        Faculty faculty = optionalFaculty.get();
        group.setFaculty(faculty);
       return groupRepository.save(group);
    }

    public String deleteGroup(Integer id) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if (optionalGroup.isPresent()) {
            groupRepository.deleteById(id);
            return "group deleted";
        }
        return "group isn't deleted or not founded";
    }
}
