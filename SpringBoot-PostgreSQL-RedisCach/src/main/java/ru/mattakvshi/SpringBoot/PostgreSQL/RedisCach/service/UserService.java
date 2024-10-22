package ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.dao.UserRepository;
import ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.dto.user.UserDTOForUser;
import ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.model.base.User;

import java.util.UUID;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Cacheable(value = "getUser", key = "#id")
    public UserDTOForUser getUser(UUID id) {
        var user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return null;
        }
        return UserDTOForUser.from(user);
    }

    @Cacheable(value = "getOriginalUser", key = "#id")
    public String getOriginalUser(UUID id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return null;
        }
        return user.toString();
    }

}
