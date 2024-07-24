package ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.dto.actions.group;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class GroupFindRequest {
    @JsonSerialize(using = ToStringSerializer.class)
    private UUID id;

    private String groupName;

    private List<UUID> members;
}
