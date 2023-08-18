package com.projetoboleria.projetoboleria.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "textura")
data class TexturaEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    val descricao: String,
        )