package com.projetoboleria.projetoboleria.repository

import com.projetoboleria.projetoboleria.model.entity.MarcaProdutoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MarcaProdutoRepository : JpaRepository<MarcaProdutoEntity, Int>{

}