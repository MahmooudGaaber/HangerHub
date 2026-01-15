package com.app.hangerhub.auth.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserModel {

    @Id
    private int id;
    private String username;
    private String password;
}
