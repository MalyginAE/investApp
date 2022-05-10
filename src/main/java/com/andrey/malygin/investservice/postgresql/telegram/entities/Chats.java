package com.andrey.malygin.investservice.postgresql.telegram.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "chats")
public class Chats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "chat_id")
    private User user;

    private Long chatId;

    public Chats(Long chatId) {
        this.chatId = chatId;
    }
}
