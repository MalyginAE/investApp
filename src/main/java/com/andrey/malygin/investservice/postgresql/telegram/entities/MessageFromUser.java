package com.andrey.malygin.investservice.postgresql.telegram.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor

@AllArgsConstructor
@Builder
@Entity
@Table(name = "message_to_bot_from_user")
public class MessageFromUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String message;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "subscriber_id")
    private User user;

    public MessageFromUser(String message, Date date, User user) {
        this.message = message;
        this.date = date;
        this.user = user;
    }
}
