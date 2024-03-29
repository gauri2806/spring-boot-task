package com.springboot.task.springboottask.service;

import com.springboot.task.springboottask.entity.Role;
import com.springboot.task.springboottask.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    public User saveUser(User user);

    public List<User> getAllUsers();

    public User getUserById(int id);

    public void addRoleToUser(int userId, int roleId);

    public List<User> getAllUsersWithRoles();

    public Set<Role> getUserRolesById(int id);

    public User updateUser(int id, User updatedUser);
}
