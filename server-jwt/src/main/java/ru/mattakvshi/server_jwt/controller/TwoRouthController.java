package ru.mattakvshi.server_jwt.controller;



//        Сперва создадим наш незамысловатый API. У нас будет 2 роли для пользователей и два эндпойнта:
//
//       /api/hello/user – будет выводить приветственное сообщение для пользователей с ролью "USER"
//       /api/hello/admin – будет выводить приветственное сообщение для пользователей с ролью "ADMIN".


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mattakvshi.server_jwt.dto.JwtAuthentication;
import ru.mattakvshi.server_jwt.service.AuthService;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class TwoRouthController {

    private final AuthService authService;

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("hello/user")
    public ResponseEntity<String> helloUser() {
        final JwtAuthentication authInfo = authService.getAuthInfo();
        return ResponseEntity.ok("Hello user " + authInfo.getPrincipal() + "!");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("hello/admin")
    public ResponseEntity<String> helloAdmin() {
        final JwtAuthentication authInfo = authService.getAuthInfo();
        return ResponseEntity.ok("Hello admin " + authInfo.getPrincipal() + "!");
    }
}
