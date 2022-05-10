package com.andrey.malygin.myInvestService.postgresql.telegram.repository;

import com.andrey.malygin.myInvestService.postgresql.telegram.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByUserName(String userName);
}
