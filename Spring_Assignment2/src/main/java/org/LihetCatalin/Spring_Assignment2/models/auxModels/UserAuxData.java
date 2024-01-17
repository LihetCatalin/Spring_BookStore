package org.LihetCatalin.Spring_Assignment2.models.auxModels;

import jakarta.persistence.Entity;

public class UserAuxData {

    private int idToUpdate;
    private int idRole;

    public UserAuxData() {
    }

    public int getIdToUpdate() {
        return idToUpdate;
    }

    public void setIdToUpdate(int idToUpdate) {
        this.idToUpdate = idToUpdate;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }
}
