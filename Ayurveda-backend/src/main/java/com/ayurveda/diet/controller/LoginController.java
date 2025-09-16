package com.ayurveda.diet.controller;

import com.ayurveda.diet.dto.LoginRequestDTO;
import com.ayurveda.diet.dto.LoginResponseDTO;
import com.ayurveda.diet.entity.User;
import com.ayurveda.diet.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
        User user = loginService.authenticate(request.getEmail(), request.getPassword());

        if (user != null) {
            // ✅ success
            return ResponseEntity.ok(
                    new LoginResponseDTO(
                            true,
                            "Login successful",
                            user.getRole(),
                            user.getUserId().toString()));
        } else {
            // ❌ failure
            return ResponseEntity.status(401).body(
                    new LoginResponseDTO(
                            false,
                            "Invalid email or password",
                            null,
                            null));
        }
    }
}
