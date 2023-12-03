package io.mohkeita.school_management.repository;

import io.mohkeita.school_management.enums.UserRole;
import io.mohkeita.school_management.model.User;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User user;

    Faker faker = new Faker(new Locale("fr"));

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setName(faker.name().name());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword("something");
    }

    // JUnit test for save employee operation
    @DisplayName("JUnit test for find User Role operation")
    @Test
    public void givenEmployeeObject_whenFindRole_thenReturnEmployeeCheckRole(){

        //given - precondition or setup
        user.setRole(UserRole.ADMIN);
        User savedUser = userRepository.save(user);


        // when - action or the behaviour that we are going test
        User userWithRole = userRepository.findByRole(savedUser.getRole());


        // then - verify the output
        assertThat(userWithRole).isNotNull();
        assertThat(userWithRole.getId()).isGreaterThan(0);

    }


}
