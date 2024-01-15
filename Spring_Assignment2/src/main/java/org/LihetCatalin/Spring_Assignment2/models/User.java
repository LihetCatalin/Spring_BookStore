package org.LihetCatalin.Spring_Assignment2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class User extends AbstractEntity{
    @NotBlank(message = "Username is required!")
    @Size(min = 3, max = 50)
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 12, message = "Password should be at least 12 characters long!")
    private String password;

    @ManyToMany
    private List<Role> roles;

    public User(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", roles=" + roles +
                '}';
    }
}
