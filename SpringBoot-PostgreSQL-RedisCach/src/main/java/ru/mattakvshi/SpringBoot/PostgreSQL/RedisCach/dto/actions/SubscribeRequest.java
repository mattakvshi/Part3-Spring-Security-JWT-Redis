package ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.dto.actions;

import lombok.Getter;

import java.util.UUID;

@Getter
public class SubscribeRequest {

    private UUID communityId;
}
