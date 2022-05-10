package com.andrey.malygin.investservice.postgresql.telegram.repository;

import com.andrey.malygin.investservice.postgresql.telegram.entities.MessageFromUser;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<MessageFromUser,Long> {
}
