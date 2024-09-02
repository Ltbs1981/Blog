package com.thykkannotech.blog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Usuarios")
public record Usuarios(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        int id,

        @Column(nullable = false, length = 100)
        String nome,

        @Column(nullable = false, unique = true, length = 100)
        String email,

        @Column(nullable = false, length = 255)
        String senha,

        @Column(length = 20)
        String perfil,

        @Column(length = 6)
        String codigoVerificacao,

        @Column(name = "data_criacao", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
        LocalDateTime dataCriacao,

        @Temporal(TemporalType.DATE)
        Date dataExpiracao,

        @Temporal(TemporalType.TIMESTAMP)
        Date dataAtualizacao
) {
}
