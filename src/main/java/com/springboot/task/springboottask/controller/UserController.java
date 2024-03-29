package com.springboot.task.springboottask.controller;

import com.springboot.task.springboottask.entity.Role;
import com.springboot.task.springboottask.entity.User;
import com.springboot.task.springboottask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user){
        userService.saveUser(user);
        return "User Added";
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found with id: " + id);
        } else {
            return ResponseEntity.ok(user);
        }
    }



    @PostMapping("/{userId}/roles/{roleId}")
    public String addRoleToUser(@PathVariable int userId, @PathVariable int roleId) {
        userService.addRoleToUser(userId, roleId);
        return "Added role with id - "+roleId + " to user with id - "+userId;
    }

    @GetMapping("/getRoles")
    public ResponseEntity<List<User>> getAllUsersWithRoles(){
        List<User> users = userService.getAllUsersWithRoles();
        return ResponseEntity.ok(users);
    }

    @GetMapping("getRoles/{id}")
    public ResponseEntity<Set<Role>> getUserRolesById(@PathVariable int id){
        Set<Role> roles=userService.getUserRolesById(id);
        return ResponseEntity.ok(roles);
    }

    @PutMapping("update/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User updatedUser){
        User user = userService.updateUser(id,updatedUser);
        return "Updated user with id : "+id;
    }
}
