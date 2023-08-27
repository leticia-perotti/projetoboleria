package com.projetoboleria.projetoboleria.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.Table

@Entity
@Table(name = "recheio")
class RecheioEntity (
    id: Int,
    nome: String,
    sabor: SaborEntity,
    textura: TexturaEntity,
    observacao: String

        ): Abstract(
    id,
    nome,
    sabor,
    textura,
    observacao
        )