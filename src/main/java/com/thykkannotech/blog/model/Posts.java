package com.thykkannotech.blog.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Posts")
public record Posts(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        int id,

        @Column(nullable = false, length = 200)
        String titulo,

        @Column(nullable = false, columnDefinition = "TEXT")
        String conteudo,

        @Column(name = "data_publicacao", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
        LocalDateTime dataPublicacao,

        @ManyToOne
        @JoinColumn(name = "usuario_id", nullable = true, foreignKey = @ForeignKey(name = "fk_posts_usuario"))
        Usuarios usuario
) {}
