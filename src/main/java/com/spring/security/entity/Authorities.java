package com.spring.security.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "authorities")
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String authority;

    public Authorities() {

    }

    public Authorities(String username,String authority) {
        this.username = username;
        this.authority = authority;
    }

}
