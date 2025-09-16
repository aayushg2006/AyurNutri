// FileName: src/main/java/com/ayurveda/diet/service/LoginService.java
package com.ayurveda.diet.service;

import com.ayurveda.diet.entity.User;
import com.ayurveda.diet.repository.UserRepository;
import lombok.RequiredArgsConstructor; // <-- Import this
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor // <-- Use constructor injection
public class LoginService {

    private final UserRepository userRepository;

    /**
     * This method is called by your LoginController.
     * It finds the user by email and checks their (plaintext) password.
     */
    public User authenticate(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // WARNING: This is plaintext. Only okay for a hackathon MVP.
            if (user.getPassword() != null && user.getPassword().equals(password)) {
                return user; // Success! Return the user object.
            }
        }

        // If user not found OR password doesn't match, return null.
        return null;
    }
}