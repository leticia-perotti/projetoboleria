package com.projetoboleria.projetoboleria.model.entity

import jakarta.persistence.Embeddable
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import java.io.Serializable

@Embeddable
data class BoloRecheioId (
    val bolo: Int,

    @OneToOne
    @JoinColumn(name= "recheio")
    val recheio: RecheioEntity
        ): Serializable