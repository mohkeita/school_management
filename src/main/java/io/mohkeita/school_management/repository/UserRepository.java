package io.mohkeita.school_management.repository;

import io.mohkeita.school_management.enums.UserRole;
import io.mohkeita.school_management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByRole(UserRole admin);

    Optional<User> findFirstByEmail(String email);
}
