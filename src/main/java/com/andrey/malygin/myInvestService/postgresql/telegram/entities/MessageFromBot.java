//package com.andrey.malygin.myInvestService.postgresql.telegram.entities;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Entity
//@Table(name = "message_to_bot_from_user")
//public class MessageFromBot {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Long id;
//    private String message;
//    private Date date;
//
//    @ManyToOne
//    @JoinColumn(name = "subscriber_id")
//    private User user;
//
//}
