package com.example.jparelationship.controller;

import com.example.jparelationship.entity.Group;
import com.example.jparelationship.payload.GroupDTO;
import com.example.jparelationship.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupService groupService;


    @GetMapping("/getGroups")
    public List<Group> getGroups() {
        return groupService.getGroups();
    }

    @GetMapping("/getGroup/{Id}")
    public Group getGroupById(@PathVariable Integer id) {
        return groupService.getGroupById(id);
    }

    @GetMapping("/getAllGoupsByFacultyId/{facultyId}")
    public List<Group> getAllGoupsByFacultyId(@PathVariable Integer facultyId) {
        return groupService.getAllGroupsByFacultyId(facultyId);
    }

    @PostMapping("/addGroup")
    public String addGroup(@RequestBody GroupDTO groupDTO) {
        return groupService.addGroup(groupDTO);
    }
    @PutMapping("/editGroup/{id}")
    public Group editGroup(@PathVariable Integer id,@RequestBody GroupDTO groupDTO){
        return groupService.editGroup(id,groupDTO);
    }
    @DeleteMapping("/deleteGroup/{id}")
    public String deleteGroup(@PathVariable Integer id){
        return groupService.deleteGroup(id);
    }
}

