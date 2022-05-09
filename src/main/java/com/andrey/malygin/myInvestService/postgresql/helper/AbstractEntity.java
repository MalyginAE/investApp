package com.andrey.malygin.myInvestService.postgresql.helper;

import javax.persistence.*;

@Entity
public abstract class AbstractEntity {

    //TODO почитать и сделать рефактооринг
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    public AbstractEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
