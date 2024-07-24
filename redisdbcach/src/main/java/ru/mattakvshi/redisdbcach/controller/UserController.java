package ru.mattakvshi.redisdbcach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mattakvshi.redisdbcach.dao.UserRepository;
import ru.mattakvshi.redisdbcach.model.User;
import ru.mattakvshi.redisdbcach.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/redis/save")
    public ResponseEntity<User> saveRedis(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatusCode.valueOf(201));
    }

    @GetMapping("/redis/get")
    public ResponseEntity<User> getRedis(@RequestParam Long id) {
        var user = userService.getUserById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
        return new ResponseEntity<>(user, HttpStatusCode.valueOf(200));
    }

}
