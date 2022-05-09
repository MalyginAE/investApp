package com.andrey.malygin.myInvestService.postgresql.telegram.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Table(name = "subscribers_telegram_bot")
@Entity
//@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  //  @Column(name = "user_name")
    private String userName;

    private String firstName;

    private String lastName;

//    @JoinColumn(name = "chat_id")
//    @OneToOne()

//    @OneToOne( cascade = CascadeType.ALL)
//    @JoinColumn(name = "chat_id")
//    private Chats chat_id;

//    @OneToMany
//    private List<MessageFromBot> messages = new ArrayList<>();

//    public User(String userName) {
//        this.userName = userName;
//    }


    public User(String userName, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

//    public User(String userName, String firstName, String lastName, Chats chat_id) {
//        this.userName = userName;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.chat_id = chat_id;
//    }

//    public User(String userName, String firstName, String lastName, Chats chat_id, List<MessageFromBot> messages) {
//        this.userName = userName;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.chat_id = chat_id;
//        this.messages = messages;
//    }


}
