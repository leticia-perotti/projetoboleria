package com.projetoboleria.projetoboleria.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "sabor")
data class SaborEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    val descricao: String
        )