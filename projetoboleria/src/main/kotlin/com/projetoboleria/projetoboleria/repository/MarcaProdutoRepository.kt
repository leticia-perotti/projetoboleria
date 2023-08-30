package com.projetoboleria.projetoboleria.repository

import com.projetoboleria.projetoboleria.model.dto.MarcaProdutoDTO
import com.projetoboleria.projetoboleria.model.entity.MarcaProdutoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface MarcaProdutoRepository : JpaRepository<MarcaProdutoEntity, Int>{
    @Query(
        "select new com.projetoboleria.projetoboleria.model.dto.MarcaProdutoDTO(" +
                " mar.id, mar.descricao, cast(mar.nivelQualidade as text)" +
                ") from MarcaProdutoEntity mar"
    )
    fun retornaTodasMarcasProdutos(): List<MarcaProdutoDTO>?

    @Query(
        "select new com.projetoboleria.projetoboleria.model.dto.MarcaProdutoDTO(" +
                " mar.id, mar.descricao, cast(mar.nivelQualidade as text)" +
                ") from MarcaProdutoEntity mar " +
                " where mar.id = :id"
    )
    fun retornaMarcaPorId(@Param("id") id: Int): MarcaProdutoDTO?
}