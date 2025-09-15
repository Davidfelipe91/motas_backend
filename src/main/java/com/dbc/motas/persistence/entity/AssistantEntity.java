package com.dbc.motas.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "assistants")
public class AssistantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

}
