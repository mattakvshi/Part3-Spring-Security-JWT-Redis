package ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.dto.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.dto.community.UserDTOForCommunity;
import ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.dto.notice.NoticeTemplDTOForOwner;
import ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.model.NotificationOptions;
import ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.model.base.User;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class UserDTOForUser implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private UUID id;

    private String firstName;

    private String lastName;

    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birthday;

    private Integer age;

    private String country;

    private String city;

    private String district;

    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate registrationDate;

    //private List<NotificationOptions> selectedOptions;

    private List<UserDTOForCommunity> friends;

    private List<GroupDTOForUser> groups;

    private List<CommunityDTOForUser> subscriptions;

    private List<NoticeTemplDTOForOwner> notificationTemplates;

    public static UserDTOForUser from(User user) {
        UserDTOForUser dto = new UserDTOForUser();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setBirthday(user.getBirthday());
        dto.setAge(user.getAge());
        dto.setCountry(user.getCountry());
        dto.setCity(user.getCity());
        dto.setDistrict(user.getDistrict());
        dto.setRegistrationDate(user.getRegistrationDate());

        //dto.setSelectedOptions(user.getSelectedOptions());

        dto.setFriends(
                user.getFriends()
                .stream()
                .map(UserDTOForCommunity::from)
                .collect(Collectors.toList())
        );

        dto.setGroups(
                user.getGroups()
                        .stream()
                        .map(GroupDTOForUser::from)
                        .collect(Collectors.toList())
        );

        dto.setSubscriptions(
                user.getSubscriptions()
                .stream()
                .map(CommunityDTOForUser::from)
                .collect(Collectors.toList())
        );

        dto.setNotificationTemplates(
                user.getNotificationTemplates()
                .stream()
                .map(NoticeTemplDTOForOwner::from)
                .collect(Collectors.toList())
        );

        return dto;
    }
}