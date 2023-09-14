package com.projetoboleria.projetoboleria.model.dto


data class MassaFormDTO (
    var id: Int?,
    val nome: String,
    val sabor: Int,
    val textura: Int,
    val observacao: String?
)