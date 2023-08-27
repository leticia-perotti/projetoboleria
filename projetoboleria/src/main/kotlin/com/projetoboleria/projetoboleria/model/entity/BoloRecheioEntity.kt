package com.projetoboleria.projetoboleria.model.entity

import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name = "bolo_recheio")
data class BoloRecheioEntity (
    @EmbeddedId
    val id: BoloRecheioId
        ): Serializable