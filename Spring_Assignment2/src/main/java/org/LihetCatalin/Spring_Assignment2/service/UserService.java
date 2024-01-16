package org.LihetCatalin.Spring_Assignment2.service;

import org.LihetCatalin.Spring_Assignment2.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    boolean register(String username, String password);

    User login(String username, String password);

    List<User> findAll();

    Optional<User> findById(Integer id);
    boolean existsById(Integer id);

    void saveUser(User user);

    void removeById(Integer id);

    void removeAll();

    String hashPassword(String password);
}
