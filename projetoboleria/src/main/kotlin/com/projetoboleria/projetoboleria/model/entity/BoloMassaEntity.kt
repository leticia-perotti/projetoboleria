package com.projetoboleria.projetoboleria.model.entity

import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name = "bolo_massa")
data class BoloMassaEntity (
    @EmbeddedId
    val id: BoloMassaId
        ): Serializable