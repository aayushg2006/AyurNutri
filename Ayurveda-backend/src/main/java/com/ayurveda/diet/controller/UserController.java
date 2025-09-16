// FileName: src/main/java/com/ayurveda/diet/controller/UserController.java
package com.ayurveda.diet.controller;

import com.ayurveda.diet.dto.UserDTO;
import com.ayurveda.diet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    // FIX: Changed endpoint to '/sync' and calls the 'syncSupabaseUser' method
    @PostMapping("/sync")
    public UserDTO syncUser(@RequestBody UserDTO dto) {
        return service.syncSupabaseUser(dto);
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}