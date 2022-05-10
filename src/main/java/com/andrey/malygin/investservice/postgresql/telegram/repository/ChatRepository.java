package com.andrey.malygin.investservice.postgresql.telegram.repository;

import com.andrey.malygin.investservice.postgresql.telegram.entities.Chats;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ChatRepository extends CrudRepository<Chats, Long> {
    Optional<Chats> findByChatId(Long chatId);
}
