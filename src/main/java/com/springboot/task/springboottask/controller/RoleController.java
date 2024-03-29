package com.springboot.task.springboottask.controller;

import com.springboot.task.springboottask.entity.Access;
import com.springboot.task.springboottask.entity.Role;
import com.springboot.task.springboottask.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/add")
    public String addRole(@RequestBody Role role){
        roleService.saveRole(role);
        return "Role Added";
    }

    @GetMapping("/all")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRoleById(@PathVariable int id){
        Role role=roleService.getRoleById(id);
        if(role!=null) return ResponseEntity.ok(role);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role not found with id : "+id);
    }

    @PostMapping("/{roleId}/accesses/{accessId}")
    public void addAccessToRole(@PathVariable int roleId, @PathVariable int accessId){
        roleService.addAccessToRole(roleId,accessId);
    }

    @GetMapping("/getAccesses")
    public ResponseEntity<List<Role>> getAllRolesWithAccesses(){
        List<Role> roles= roleService.getAllRolesWithAccesses();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/getAccesses/{id}")
    public ResponseEntity<Set<Access>> getRoleAccessesById(@PathVariable int id){
        Set<Access> accesses = roleService.getRoleAccessesById(id);
        return ResponseEntity.ok(accesses);
    }
}
