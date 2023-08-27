package com.projetoboleria.projetoboleria.model.entity

import jakarta.persistence.Embeddable
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import java.io.Serializable

@Embeddable
data class BoloMassaId (
    val bolo: Int,

    @OneToOne
    @JoinColumn(name= "massa")
    val massa: MassaEntity
        ): Serializable