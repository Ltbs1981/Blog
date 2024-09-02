package com.thykkannotech.blog.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Comentarios")
public record Comentarios(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        int id,

        @Column(nullable = false, columnDefinition = "TEXT")
        String conteudo,

        @Column(name = "data_comentario", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
        LocalDateTime dataComentario,

        @ManyToOne
        @JoinColumn(name = "usuario_id", nullable = true, foreignKey = @ForeignKey(name = "fk_comentarios_usuario"))
        Usuarios usuario,

        @ManyToOne
        @JoinColumn(name = "post_id", nullable = true, foreignKey = @ForeignKey(name = "fk_comentarios_post"))
        Posts post
) {}
