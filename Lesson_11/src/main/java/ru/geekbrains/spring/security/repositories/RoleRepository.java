package ru.geekbrains.spring.security.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.security.entities.Role;

@Repository
@Profile("dao")
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
