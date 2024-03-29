package com.springboot.task.springboottask.service;

import com.springboot.task.springboottask.entity.Access;
import com.springboot.task.springboottask.entity.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    public Role saveRole(Role role);

    public List<Role> getAllRoles();

    public Role getRoleById(int id);
    public void addAccessToRole(int userId, int roleId);

    public List<Role> getAllRolesWithAccesses();

    public Set<Access> getRoleAccessesById(int id);

    public Role updateRole(int id, Role updatedRole);
}
