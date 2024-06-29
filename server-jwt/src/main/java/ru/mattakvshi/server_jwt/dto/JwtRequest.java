package ru.mattakvshi.server_jwt.dto;

import lombok.Getter;
import lombok.Setter;

// Создадим класс JwtRequest, который пользователь будет присылать, чтобы получить JWT токен. Он содержит поля: логин пользователя и его пароль.

@Setter
@Getter
public class JwtRequest {

    private String login;
    private String password;

}
