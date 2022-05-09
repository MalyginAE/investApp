package com.andrey.malygin.myInvestService.postgresql.telegram.repository;

import com.andrey.malygin.myInvestService.postgresql.telegram.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends CrudRepository<User,Long> {
}
