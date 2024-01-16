package org.LihetCatalin.Spring_Assignment2.data;

import org.LihetCatalin.Spring_Assignment2.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    public boolean existsByUsernameAndPassword(String username, String password);

    public User findByUsernameAndPassword(String username, String password);
}
