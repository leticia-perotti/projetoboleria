package com.projetoboleria.projetoboleria.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "decoracao")
data class DecoracaoEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    val cor: String,
    val tema: String,
    val brilho: Boolean,
    val velas: Boolean,
    val lacoDecorativo: Boolean,
    val placaParabens: Boolean,
    val balaoDecorativo: Boolean
        )