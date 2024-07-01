package ru.mattakvshi.server_jwt.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mattakvshi.server_jwt.dto.JwtRequest;
import ru.mattakvshi.server_jwt.dto.JwtResponse;
import ru.mattakvshi.server_jwt.dto.RefreshJwtRequest;
import ru.mattakvshi.server_jwt.service.AuthService;

//Теперь создадим контроллер AuthController.

@Log
@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    //Тут ничего не обычного.

    //Эндпойнт /api/auth/login принимает JwtRequest, а возвращает JwtResponse с токенами.
    //Эндпойнт /api/auth/token  принимает RefreshJwtRequest c единственным полем refreshToken и возвращает JwtResponse с новым access токеном.
    //И наконец эндпойнт /api/auth/refresh  принимает RefreshJwtRequest  и возвращает JwtResponse с новыми токенами.

    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest authRequest) {
        try {
            final JwtResponse token = authService.login(authRequest);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            log.info("Auth error: " + e);
            return ResponseEntity.internalServerError().body(new JwtResponse(null, e.getMessage()));
        }
    }

    @PostMapping("token")
    public ResponseEntity<JwtResponse> getNewAccessToken(@RequestBody RefreshJwtRequest request) {
        try {
            final JwtResponse token = authService.getAccessToken(request.getRefreshToken());
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            log.info("Auth error: " + e);
            return ResponseEntity.internalServerError().body(new JwtResponse(null, e.getMessage()));
        }
    }

    //Также для большой безопасности мы защитим /api/auth/refresh и будем принимать на него запросы только с валидным access токеном.
    // Для этого нам нужно создать класс конфигурации для настройки Spting Security.

    @PostMapping("refresh")
    public ResponseEntity<JwtResponse> getNewRefreshToken(@RequestBody RefreshJwtRequest request) {
        try {
            final JwtResponse token = authService.refresh(request.getRefreshToken());
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            log.info("Auth error: " + e);
            return ResponseEntity.internalServerError().body(new JwtResponse(null, e.getMessage()));
        }
    }

}