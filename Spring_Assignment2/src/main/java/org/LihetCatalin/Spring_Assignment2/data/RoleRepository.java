package org.LihetCatalin.Spring_Assignment2.data;

import org.LihetCatalin.Spring_Assignment2.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

    public Role findRoleByName(String name);
}
