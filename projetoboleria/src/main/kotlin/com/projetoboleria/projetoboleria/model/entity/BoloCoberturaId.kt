package com.projetoboleria.projetoboleria.model.entity

import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import java.io.Serializable

@Embeddable
data class BoloCoberturaId (
    val bolo: Int,

    @OneToOne
    @JoinColumn(name = "cobertura")
    val cobertura: CoberturaEntity
        ): Serializable