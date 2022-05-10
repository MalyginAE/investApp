package com.andrey.malygin.investservice.postgresql.telegram.repository;

import com.andrey.malygin.investservice.postgresql.telegram.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByUserName(String userName);
    Optional<User> findByFirstName(String firstName);
    Optional<User> findByLastName(String lastName);

}
