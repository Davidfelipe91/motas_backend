package com.dbc.motas.persistence.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "invoices")
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "total_amount")
    private Integer totalAmount;

    @Column(name = "status")
    private String status;

    @Column(name = "notes")
    private String notes;

    //    TASK: relation with Product, Service and I don't know what more!




}
