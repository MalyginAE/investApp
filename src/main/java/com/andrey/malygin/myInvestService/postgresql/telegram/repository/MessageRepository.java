package com.andrey.malygin.myInvestService.postgresql.telegram.repository;

import com.andrey.malygin.myInvestService.postgresql.telegram.entities.MessageFromUser;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<MessageFromUser,Long> {
}
