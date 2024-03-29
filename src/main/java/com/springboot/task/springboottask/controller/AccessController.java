package com.springboot.task.springboottask.controller;

import com.springboot.task.springboottask.entity.Access;
import com.springboot.task.springboottask.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accesses")
public class AccessController {
    @Autowired
    private AccessService accessService;

    @PostMapping("/add")
    public String addAccess(@RequestBody Access access){
        accessService.saveAccess(access);
        return "Access Added";
    }
}
