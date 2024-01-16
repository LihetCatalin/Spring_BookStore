package org.LihetCatalin.Spring_Assignment2.models.UserDTO;

import jakarta.validation.constraints.NotNull;
import org.LihetCatalin.Spring_Assignment2.models.User;

public class UserDTO {

    @NotNull
    private User user;

    public UserDTO(){}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
