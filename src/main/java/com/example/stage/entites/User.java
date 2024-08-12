package com.example.stage.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;



    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Kosu> Kosus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Incident> Incidents;

    @ManyToOne
    Admin admin;

    }

