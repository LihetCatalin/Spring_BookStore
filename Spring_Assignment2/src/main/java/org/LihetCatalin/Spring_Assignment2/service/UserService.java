package org.LihetCatalin.Spring_Assignment2.service;

import org.LihetCatalin.Spring_Assignment2.models.User;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {

    boolean register(String username, String password);

    User login(String username, String password);
}
