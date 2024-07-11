package com.example.stage.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class Incident implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIncident;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String description;
    private Date date;
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="incident")
    private Set<Notification> Notifications;
    @ManyToOne
    User user;


}
