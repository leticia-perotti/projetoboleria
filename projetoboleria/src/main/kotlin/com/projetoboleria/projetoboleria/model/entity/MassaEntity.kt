package com.projetoboleria.projetoboleria.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name= "massa")
class MassaEntity (
    id: Int?,
    nome: String,
    sabor: SaborEntity,
    textura: TexturaEntity,
    observacao: String?

): Abstract(
    id,
    nome,
    sabor,
    textura,
    observacao
)