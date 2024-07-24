package ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.model.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import ru.mattakvshi.near.dto.community.UserDTOForCommunity;
import ru.mattakvshi.near.entity.Group;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class GroupDTOForUser {

    @JsonSerialize(using = ToStringSerializer.class)
    private UUID id;

    private String groupName;

    private List<UserDTOForCommunity> members;

    public static GroupDTOForUser from(Group group) {
        GroupDTOForUser groupDTO = new GroupDTOForUser();
        groupDTO.setId(group.getId());
        groupDTO.setGroupName(group.getGroupName());

        groupDTO.setMembers(
                group.getMembers()
                        .stream()
                        .map(UserDTOForCommunity::from)
                        .collect(Collectors.toList())
        );

        return groupDTO;
    }

}
