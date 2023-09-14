package com.projetoboleria.projetoboleria.repository

import com.projetoboleria.projetoboleria.model.dto.MassaReturnDTO
import com.projetoboleria.projetoboleria.model.dto.MassaSimpleReturnDTO
import com.projetoboleria.projetoboleria.model.entity.MassaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MassaRepository : JpaRepository<MassaEntity, Int>{

    @Query(
        "select new com.projetoboleria.projetoboleria.model.dto.MassaReturnDTO(" +
                "ma.id, ma.nome, ma.sabor.id," +
                "ma.sabor.descricao,  ma.textura.id, ma.textura.descricao," +
                "ma.observacao" +
                ") from MassaEntity ma"
    )
    fun retornaMassasDetalhadas(): List<MassaReturnDTO>?

    @Query(
        "select new com.projetoboleria.projetoboleria.model.dto.MassaSimpleReturnDTO(" +
                " ma.id, ma.nome" +
                ") from MassaEntity ma"
    )
    fun retornaMassaSimples(): List<MassaSimpleReturnDTO>?
}