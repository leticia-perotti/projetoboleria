package com.projetoboleria.projetoboleria.model.entity

import com.projetoboleria.projetoboleria.model.enum.QualidadeNivel
import jakarta.persistence.*

@Entity
@Table(name = "marca_produto")
data class MarcaProdutoEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    val nivelQualidade: QualidadeNivel

        )