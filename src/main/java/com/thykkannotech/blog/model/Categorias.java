package com.thykkannotech.blog.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Categorias")
public record Categorias(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        int id,

        @Column(nullable = false, unique = true, length = 100)
        String nome
) {}
