package com.matiox.banking_service.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Dato Obligatorio, Numero de Cuenta Unico
    @Column(name = "account_number", nullable = false, unique = true)
    private String accountNumber;
    @Column(name = "balance", nullable = false)
    private BigDecimal balance;
    @Column(name = "owner_name", nullable = false)
    private String owenerName;
    @Column(name = "owner_email", nullable = false)
    private String ownerEmail;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "update_At")
    private LocalDate updateAt;

}
