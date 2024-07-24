package ru.mattakvshi.redisdbcach.dto;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserRequestBody implements Serializable {

    private String username;
    private int age;
}
