package com.thykkannotech.blog.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Posts_Categorias")
public record PostsCategorias(
        @Id
        @ManyToOne
        @JoinColumn(name = "post_id", foreignKey = @ForeignKey(name = "fk_postscategorias_post"))
        Posts post,

        @Id
        @ManyToOne
        @JoinColumn(name = "categoria_id", foreignKey = @ForeignKey(name = "fk_postscategorias_categoria"))
        Categorias categoria
) implements Serializable {}
