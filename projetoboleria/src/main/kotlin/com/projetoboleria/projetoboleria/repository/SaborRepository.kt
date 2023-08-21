package com.projetoboleria.projetoboleria.repository

import com.projetoboleria.projetoboleria.model.dto.SaborDTO
import com.projetoboleria.projetoboleria.model.entity.SaborEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface SaborRepository: JpaRepository<SaborEntity, Int> {

    @Query(
        "select new com.projetoboleria.projetoboleria.model.dto.SaborDTO(" +
                "   sab.id, sab.descricao" +
                ") from SaborEntity sab"
    )
    fun retornaTodosSabores() : List<SaborDTO>?

    @Query(
        "select new com.projetoboleria.projetoboleria.model.dto.SaborDTO(" +
                "   sab.id, sab.descricao" +
                ") from SaborEntity sab where sab.id = :id"
    )
    fun retornaSaborPorId(@Param("id") id: Int) : SaborDTO
}