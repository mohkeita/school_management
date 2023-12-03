package io.mohkeita.school_management.repository;

import io.mohkeita.school_management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
