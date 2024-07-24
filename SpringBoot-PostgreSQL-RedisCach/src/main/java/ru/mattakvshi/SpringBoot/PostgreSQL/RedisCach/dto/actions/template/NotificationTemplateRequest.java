package ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.dto.actions.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.mattakvshi.near.entity.EmergencyTypes;

@Data
@AllArgsConstructor
public class NotificationTemplateRequest {

    private String templateName;

    private String message;

    private EmergencyTypes emergencyType;

}
