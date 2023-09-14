package com.projetoboleria.projetoboleria.model.entity

import jakarta.persistence.*

@MappedSuperclass
abstract class Abstract(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    val nome: String,

    @OneToOne
    @JoinColumn(name = "sabor")
    val sabor: SaborEntity,

    @OneToOne
    @JoinColumn(name = "textura")
    val textura: TexturaEntity,

    val observacao: String?

)