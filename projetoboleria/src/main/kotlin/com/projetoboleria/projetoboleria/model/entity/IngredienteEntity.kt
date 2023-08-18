package com.projetoboleria.projetoboleria.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "ingrediente")
data class IngredienteEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    val descricao: String,

    @OneToOne
    @JoinColumn(name = "marca")
    val marca: MarcaProdutoEntity

    )