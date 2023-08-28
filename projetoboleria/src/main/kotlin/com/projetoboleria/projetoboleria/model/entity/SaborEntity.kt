package com.projetoboleria.projetoboleria.model.entity

import jakarta.persistence.*
import lombok.NoArgsConstructor

@Entity
@Table(name = "sabor")
@NoArgsConstructor
data class SaborEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    val descricao: String
        ) {

}