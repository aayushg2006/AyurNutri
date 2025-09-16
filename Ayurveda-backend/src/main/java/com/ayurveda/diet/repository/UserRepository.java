// FileName: src/main/java/com/ayurveda/diet/repository/UserRepository.java
package com.ayurveda.diet.repository;

import com.ayurveda.diet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

    List<User> findByRole(String role);

    boolean existsByEmail(String email);
    
    // --- THIS IS THE FIX ---
    // The method name MUST match the field names in the User.java class.
    // The field is 'password', not 'passwordHash'.
    Optional<User> findByEmailAndPassword(String email, String password);
}