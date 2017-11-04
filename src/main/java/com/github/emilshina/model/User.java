package com.github.emilshina.model;

import lombok.Data;

/**
 * The user model.
 */

@Data
public class User {

    private final long phoneNumber;
    private final String password;
    private final String userName;
}
