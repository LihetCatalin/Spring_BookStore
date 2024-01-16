package org.LihetCatalin.Spring_Assignment2.service;

import org.LihetCatalin.Spring_Assignment2.data.RoleRepository;
import org.LihetCatalin.Spring_Assignment2.data.UserRepository;
import org.LihetCatalin.Spring_Assignment2.models.User;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public boolean register(String username, String password) {
        return false;
    }

    @Override
    public User login(String username, String password) {
        return null;
    }
}
