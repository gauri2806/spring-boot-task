package com.springboot.task.springboottask.repository;

import com.springboot.task.springboottask.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query("SELECT DISTINCT r FROM Role r JOIN FETCH r.accesses")
    List<Role> findAllWithAccesses();
}
