package com.springboot.task.springboottask.service;

import com.springboot.task.springboottask.entity.Role;
import com.springboot.task.springboottask.entity.User;
import com.springboot.task.springboottask.repository.RoleRepository;
import com.springboot.task.springboottask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void addRoleToUser(int userId, int roleId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id : "+userId));
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found with id : "+roleId));
        user.getRoles().add(role);
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsersWithRoles() {
        return userRepository.findAllWithRoles();
    }

    @Override
    public Set<Role> getUserRolesById(int id) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("No user found with id : "+id));
        return user.getRoles();
    }

    @Override
    public User updateUser(int id, User updatedUser) {
        User user=userRepository.findById(id).orElseThrow(()->new RuntimeException("No user found with id : "+id));
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setNumber(updatedUser.getNumber());
        return userRepository.save(user);
    }
}
