package ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.dto.actions.group;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class GroupRequest {

    private String groupName;

    private List<UUID> members;

}
