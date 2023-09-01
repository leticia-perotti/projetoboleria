package com.projetoboleria.projetoboleria.repository

import com.projetoboleria.projetoboleria.model.dto.IngredienteDTO
import com.projetoboleria.projetoboleria.model.dto.IngredienteFormDTO
import com.projetoboleria.projetoboleria.model.entity.IngredienteEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface IngredienteRepository : JpaRepository<IngredienteEntity, Int>{

    @Query(
        "select new com.projetoboleria.projetoboleria.model.dto.IngredienteDTO(" +
                "   in.id, in.descricao, mar.descricao" +
                ") from IngredienteEntity in" +
                " join MarcaProdutoEntity mar on (mar.id = in.marca.id)"
    )
    fun retornaIngredientesComMarca(): List<IngredienteDTO>?

    @Query(
        "select new com.projetoboleria.projetoboleria.model.dto.IngredienteFormDTO(" +
                " in.id, in.descricao, mar.id, mar.descricao" +
                ") from IngredienteEntity in" +
                " join MarcaProdutoEntity mar on (mar.id = in.marca.id)"
    )
    fun retornaIngredientePorId(
        @Param("id") id: Int
    ): IngredienteFormDTO?
}