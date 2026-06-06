package in.ac.nitw.placement_portal.controller;

import in.ac.nitw.placement_portal.dto.AuthResponse;
import in.ac.nitw.placement_portal.dto.LoginForm;
import in.ac.nitw.placement_portal.dto.RegisterForm;
import in.ac.nitw.placement_portal.usecase.AuthUseCase;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Slf4j
@Validated
public class AuthController {

    @Autowired
    private AuthUseCase authUseCase;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterForm form) {
        log.info("Register request for email: {}", form.getEmail());
        return ResponseEntity.ok(authUseCase.register(form));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginForm form) {
        log.info("Login request for email: {}", form.getEmail());
        return ResponseEntity.ok(authUseCase.login(form));
    }
}
