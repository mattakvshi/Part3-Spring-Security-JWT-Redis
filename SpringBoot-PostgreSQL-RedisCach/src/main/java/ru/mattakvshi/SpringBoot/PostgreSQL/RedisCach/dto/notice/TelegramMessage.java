package ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.dto.notice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelegramMessage extends NotificationMessage{

    private String phoneNumber;

    private String shortName;
}
