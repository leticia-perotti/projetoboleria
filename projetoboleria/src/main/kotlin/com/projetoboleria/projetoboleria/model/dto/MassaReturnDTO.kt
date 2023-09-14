package com.projetoboleria.projetoboleria.model.dto

data class MassaReturnDTO (
    val id: Int,
    val nome: String,
    val sabor: Int,
    val saborDesc: String,
    val textura: Int,
    val texturaDesc: String,
    val observacao: String?
)