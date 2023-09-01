package com.projetoboleria.projetoboleria.model.dto

data class IngredienteFormDTO (
    var id: Int?,
    val descricao: String,
    val marca: Int,
    val marcaDesc: String? = null
)