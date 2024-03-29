package com.springboot.task.springboottask.service;

import com.springboot.task.springboottask.entity.Access;

import java.util.List;

public interface AccessService {
    public Access saveAccess(Access access);
    public List<Access> getAllAccesses();

    public Access getAccessById(int id);
}
