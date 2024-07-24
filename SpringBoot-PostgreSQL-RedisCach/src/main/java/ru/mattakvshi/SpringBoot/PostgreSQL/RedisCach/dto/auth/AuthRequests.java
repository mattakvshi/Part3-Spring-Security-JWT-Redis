package ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.dto.auth;

import lombok.Data;

@Data
public class AuthRequests {

    private String email;

    private String password;

}
