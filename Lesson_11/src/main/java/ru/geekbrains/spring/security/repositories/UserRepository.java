package ru.geekbrains.spring.security.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.security.entities.User;

import java.util.Optional;

@Repository
@Profile("dao")
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
