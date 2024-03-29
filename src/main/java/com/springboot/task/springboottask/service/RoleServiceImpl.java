package com.springboot.task.springboottask.service;

import com.springboot.task.springboottask.entity.Access;
import com.springboot.task.springboottask.entity.Role;
import com.springboot.task.springboottask.repository.AccessRepository;
import com.springboot.task.springboottask.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AccessRepository accessRepository;

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(int id) {
        Optional<Role> thisRole= roleRepository.findById(id);
        if(thisRole.isPresent()) return thisRole.get();
        else throw new RuntimeException("No role found with id : "+id);
    }

    @Override
    public void addAccessToRole(int roleId, int accessId) {
        Role role=roleRepository.findById(roleId).orElseThrow(()->new IllegalArgumentException("Role not found with id : "+roleId));
        Access access = accessRepository.findById(accessId).orElseThrow(()->new IllegalArgumentException("Access not found with id : "+accessId));

        role.getAccesses().add(access);
        roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRolesWithAccesses() {
        return roleRepository.findAllWithAccesses();
    }

    @Override
    public Set<Access> getRoleAccessesById(int id) {
        Role role=roleRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("No role found with id : " + id));
        return role.getAccesses();
    }

    @Override
    public Role updateRole(int id, Role updatedRole) {
        Role role = roleRepository.findById(id).orElseThrow(()->new RuntimeException("No role found with id : "+id));
        role.setName(updatedRole.getName());
        role.setDescription(updatedRole.getDescription());
        return role;
    }
}
