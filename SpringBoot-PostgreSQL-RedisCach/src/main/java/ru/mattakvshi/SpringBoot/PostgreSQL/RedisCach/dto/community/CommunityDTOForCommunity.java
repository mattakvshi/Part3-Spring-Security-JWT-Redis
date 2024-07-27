package ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.dto.community;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Data;
import ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.dto.notice.NoticeTemplDTOForOwner;
import ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.model.EmergencyTypes;
import ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.model.base.Community;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class CommunityDTOForCommunity implements Serializable  {

    @JsonSerialize(using = ToStringSerializer.class)
    private UUID id;

    private String communityName;

    private String description;

    private String country;

    private String city;

    private String district;

    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate registrationDate;

    private List<UserDTOForCommunity> subscribers;

    //private List<EmergencyTypes> monitoredEmergencyTypesCount;

    private List<NoticeTemplDTOForOwner> notificationTemplates;

    public static CommunityDTOForCommunity from(Community community) {
        CommunityDTOForCommunity dto = new CommunityDTOForCommunity();
        dto.setId(community.getId());
        dto.setCommunityName(community.getCommunityName());
        dto.setDescription(community.getDescription());
        dto.setCountry(community.getCountry());
        dto.setCity(community.getCity());
        dto.setDistrict(community.getDistrict());
        dto.setRegistrationDate(community.getRegistrationDate());

        dto.setSubscribers(
                community.getSubscribers()
                        .stream()
                        .map(UserDTOForCommunity::from)
                        .collect(Collectors.toList())
        );

        //dto.setMonitoredEmergencyTypesCount(community.getMonitoredEmergencyTypes());

        dto.setNotificationTemplates(
                community.getNotificationTemplates()
                .stream()
                .map(NoticeTemplDTOForOwner::from)
                .collect(Collectors.toList())
        );

        return dto;
    }
}
