package ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.dao.UserRepository;
import ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.dto.user.UserDTOForUser;

import java.util.UUID;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTOForUser getUser(UUID id) {
        var user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return null;
        }
        return UserDTOForUser.from(user);
    }

}
