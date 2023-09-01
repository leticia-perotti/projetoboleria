package com.projetoboleria.projetoboleria.model.mapper

import com.projetoboleria.projetoboleria.model.dto.IngredienteDTO
import com.projetoboleria.projetoboleria.model.dto.IngredienteFormDTO
import com.projetoboleria.projetoboleria.model.dto.MarcaProdutoDTO
import com.projetoboleria.projetoboleria.model.entity.IngredienteEntity
import com.projetoboleria.projetoboleria.repository.MarcaProdutoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class IngredienteMapper (
    private val marcaProdutoRepository: MarcaProdutoRepository
){

    fun formDTOtoEntity(ingrediente: IngredienteFormDTO): IngredienteEntity{
        return IngredienteEntity(
            ingrediente.id,
            ingrediente.descricao,
            marcaProdutoRepository.findByIdOrNull(ingrediente.marca)!!
        )
    }

    fun entityToDTO(entity: IngredienteEntity): IngredienteDTO{
        return IngredienteDTO(
            entity.id!!,
            entity.descricao,
            entity.marca.descricao
        )
    }
}