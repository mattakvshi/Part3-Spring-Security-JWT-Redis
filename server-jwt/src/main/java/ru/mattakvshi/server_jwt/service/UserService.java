package ru.mattakvshi.server_jwt.service;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mattakvshi.server_jwt.entity.Role;
import ru.mattakvshi.server_jwt.entity.User;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

//Далее создадим UserService, у него будет только один метод, который возвращает пользователя по логину.
//Пользователи будут заранее создаваться в конструкторе.

//Так как моя цель - это реализация работы JWT, то я умышленно упрощаю архитектуру приложения,
//и опускаю такие неважные детали, как добавление новых пользователей и шифрование паролей.



@Service
@RequiredArgsConstructor
public class UserService {

    public final List<User> users;

    public UserService() {
        this.users = List.of(
                new User("anton", "1234", "Антон", "Иванов", Collections.singleton(Role.USER)),
                new User("ivan", "12345", "Сергей", "Петров", Collections.singleton(Role.ADMIN))
        );
    }

    public Optional<User> getByLogin(@NonNull String login) {
        return users.stream()
                .filter(user -> login.equals(user.getLogin()))
                .findFirst();
    }



}
