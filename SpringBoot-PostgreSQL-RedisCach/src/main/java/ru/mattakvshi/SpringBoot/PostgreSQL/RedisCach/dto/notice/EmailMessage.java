package ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.dto.notice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailMessage extends NotificationMessage{
    private String email;
}
