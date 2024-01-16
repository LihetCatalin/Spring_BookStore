package org.LihetCatalin.Spring_Assignment2.service;

import org.LihetCatalin.Spring_Assignment2.models.Role;

import java.util.List;

public interface RoleService {

    public Role findByName(String name);

    public Role findById(Integer id);

    public List<Role> findAll();
}
