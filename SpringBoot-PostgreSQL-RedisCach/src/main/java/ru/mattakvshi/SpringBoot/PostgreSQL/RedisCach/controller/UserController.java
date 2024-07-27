package ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.dao.UserRepository;
import ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.dto.user.UserDTOForUser;
import ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.model.base.User;
import ru.mattakvshi.SpringBoot.PostgreSQL.RedisCach.service.UserService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v2")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/get")
    public ResponseEntity<UserDTOForUser> getUser(@RequestParam UUID id) {
        var user = userService.getUser(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
        return new ResponseEntity<>(user, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/user/original")
    public ResponseEntity<String> getOriginalUser(@RequestParam UUID id) {
        var user = userService.getOriginalUser(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
        return new ResponseEntity<>(user, HttpStatusCode.valueOf(200));
    }


}
