// FileName: src/main/java/com/ayurveda/diet/mapper/UserMapper.java
package com.ayurveda.diet.mapper;

import com.ayurveda.diet.entity.User;
import com.ayurveda.diet.dto.UserDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDto(User entity);

    // --- THIS IS THE FIX ---
    // This tells MapStruct to ignore the 'password' field when
    // converting a DTO to an Entity, which removes the warning.
    @Mapping(target = "password", ignore = true)
    User toEntity(UserDTO dto);
}