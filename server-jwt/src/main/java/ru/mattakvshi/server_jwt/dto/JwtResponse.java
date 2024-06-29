package ru.mattakvshi.server_jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

//Создадим еще один объект JwtResponse, который будет содержать access и refresh токены. Этот объект мы будем возвращать в ответ.

@Getter
@AllArgsConstructor
public class JwtResponse {

    private final String type = "Bearer";
    private String accessToken;
    private String refreshToken;

}
