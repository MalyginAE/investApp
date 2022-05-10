package com.andrey.malygin.investservice.postgresql.telegram.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
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


    //    @OneToOne( cascade = CascadeType.ALL)
//    @JoinColumn(name = "chat_id")
    @JoinColumn(name = "chat_id")
    @OneToOne(fetch = FetchType.EAGER)
    private Chats chat_id;

//    @OneToMany
//    private List<MessageFromUser> messages = new ArrayList<>();

//    public User(String userName) {
//        this.userName = userName;
//    }

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<MessageFromUser> message = new ArrayList<>();

    public User(String userName, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String userName, String firstName, String lastName, Chats chat_id) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.chat_id = chat_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", chat_id=" + chat_id +
                ", message=" + message +
                '}';
    }

    //    public User(String userName, String firstName, String lastName, Chats chat_id, List<MessageFromUser> messages) {
//        this.userName = userName;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.chat_id = chat_id;
//        this.messages = messages;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
