package ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.dto.notice;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = EmailMessage.class, name = "Email"),
        @JsonSubTypes.Type(value = TelegramMessage.class, name = "Telegram"),
        @JsonSubTypes.Type(value = PushMessage.class, name = "Mobile_Notification")
})
@Getter
@Setter
public class NotificationMessage {
    private String templateName;

    private String owner;

    private String message;

    private String emergencyType;
}
