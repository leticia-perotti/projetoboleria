package com.projetoboleria.projetoboleria.service

import com.projetoboleria.projetoboleria.model.dto.IngredienteDTO
import com.projetoboleria.projetoboleria.model.dto.IngredienteFormDTO
import com.projetoboleria.projetoboleria.model.mapper.IngredienteMapper
import com.projetoboleria.projetoboleria.repository.IngredienteRepository
import org.springframework.stereotype.Service

@Service
class IngredienteService(
    private val ingredienteRepository: IngredienteRepository,
    private val ingredienteMapper: IngredienteMapper
) {

    fun retornaIngredientesComMarca(): List<IngredienteDTO>?{
        return ingredienteRepository.retornaIngredientesComMarca()
    }

    fun retornaIngredientePorId(id: Int): IngredienteFormDTO?{
        return ingredienteRepository.retornaIngredientePorId(id)
    }

    fun salvaIngrediente(ingrediente: IngredienteFormDTO): IngredienteDTO{
        ingrediente.id = null
        val entidade = ingredienteRepository.save(
            ingredienteMapper.formDTOtoEntity(ingrediente)
        )

        return ingredienteMapper.entityToDTO(entidade)
    }
    fun editarIngrediente(ingrediente: IngredienteFormDTO): IngredienteDTO{
        val entidade = ingredienteRepository.save(
            ingredienteMapper.formDTOtoEntity(ingrediente)
        )

        return ingredienteMapper.entityToDTO(entidade)
    }

    fun excluiIngrediente(id: Int){
        ingredienteRepository.deleteById(id)
    }
}