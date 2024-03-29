package com.springboot.task.springboottask.service;

import com.springboot.task.springboottask.entity.Access;
import com.springboot.task.springboottask.repository.AccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessServiceImpl implements AccessService{
    @Autowired
    private AccessRepository accessRepository;
    @Override
    public Access saveAccess(Access access) {
        return accessRepository.save(access);
    }

    @Override
    public List<Access> getAllAccesses() {
        return accessRepository.findAll();
    }

    @Override
    public Access getAccessById(int id) {
        return accessRepository.findById(id).orElse(null);
    }
}
