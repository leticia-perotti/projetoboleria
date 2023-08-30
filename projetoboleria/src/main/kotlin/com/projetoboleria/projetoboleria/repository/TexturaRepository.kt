package com.projetoboleria.projetoboleria.repository

import com.projetoboleria.projetoboleria.model.dto.TexturaDTO
import com.projetoboleria.projetoboleria.model.entity.TexturaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface TexturaRepository: JpaRepository<TexturaEntity, Int> {

    @Query(
        "select new com.projetoboleria.projetoboleria.model.dto.TexturaDTO(" +
                "   tex.id, tex.descricao" +
                ")" +
                " from TexturaEntity tex"
    )
    fun retornaTodasAsTexturas(): List<TexturaDTO>

    @Query(
        "select new com.projetoboleria.projetoboleria.model.dto.TexturaDTO(" +
                " tex.id, tex.descricao) " +
                " from TexturaEntity tex" +
                " where tex.id = :id"
    )
    fun retornaTexturaPorId(@Param("id") id: Int): TexturaDTO
}