package com.app.hangerhub.auth.role;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "roles")
@Data
public class UserRole {

    @Id
    private int id;
    private String role;

}
