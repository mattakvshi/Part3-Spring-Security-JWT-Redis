package ru.mattakvshi.redisdbcach.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.UUID;

@Data
@RedisHash(value = "Users") //Сущность в рамках Redis как NoSQL базы данных
public class User implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String username;
}
