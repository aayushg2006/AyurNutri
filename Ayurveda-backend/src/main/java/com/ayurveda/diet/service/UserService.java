// FileName: src/main/java/com/ayurveda/diet/service/UserService.java
package com.ayurveda.diet.service;

import com.ayurveda.diet.dto.UserDTO;
import com.ayurveda.diet.entity.User;
import com.ayurveda.diet.mapper.UserMapper;
import com.ayurveda.diet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // FIX: Renamed 'create' to 'syncSupabaseUser'
    // This is called *after* Supabase signup to copy the user into your public table.
    public UserDTO syncSupabaseUser(UserDTO dto) {
        // We assume the DTO has the userId from Supabase
        User user = userMapper.toEntity(dto);
        // Set the ID manually since it's not auto-generated
        user.setUserId(dto.getUserId()); 
        return userMapper.toDto(userRepository.save(user));
    }

    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream().map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public UserDTO getById(UUID id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}