package ru.mattakvshi.redisdbcach.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mattakvshi.redisdbcach.dao.UserRepository;
import ru.mattakvshi.redisdbcach.dto.UserRequestBody;
import ru.mattakvshi.redisdbcach.model.User;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(UserRequestBody userRequestBody) {
        User user = User.builder()  //Использую стандартный билдер из ломбока
                .username(userRequestBody.getUsername())
                .age(userRequestBody.getAge())
                .build();
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
