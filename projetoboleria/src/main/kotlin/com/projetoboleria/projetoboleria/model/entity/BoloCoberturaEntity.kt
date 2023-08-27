package com.projetoboleria.projetoboleria.model.entity

import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.io.Serializable

@Entity
@Table(name = "bolo_cobertura")
data class BoloCoberturaEntity (
    @EmbeddedId
    val id: BoloCoberturaId
        ): Serializable