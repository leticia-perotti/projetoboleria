package com.projetoboleria.projetoboleria.service

import com.projetoboleria.projetoboleria.model.dto.TexturaDTO
import com.projetoboleria.projetoboleria.model.entity.TexturaEntity
import com.projetoboleria.projetoboleria.model.mapper.TexturaMapper
import com.projetoboleria.projetoboleria.repository.TexturaRepository
import org.springframework.stereotype.Service

@Service
class TexturaService (
    private val texturaRepository: TexturaRepository,
    private val texturaMapper: TexturaMapper
        ){

    fun retornaTodasAsTexturas(): List<TexturaDTO>{
        return texturaRepository.retornaTodasAsTexturas()
    }

    fun retornaTexturaPorId(id: Int): TexturaDTO{
        return texturaRepository.retornaTexturaPorId(id)
    }

    fun salvaTextura(textura: TexturaDTO): TexturaDTO{
        textura.id = null
        val entitidade = texturaRepository.save(
            texturaMapper.texturaDTOtoEntity(textura)
        )

        return texturaMapper.toTexturaDTO(entitidade)
    }

    fun editaTextura(textura: TexturaDTO): TexturaDTO{
        val entitidade = texturaRepository.save(
            texturaMapper.texturaDTOtoEntity(textura)
        )

        return texturaMapper.toTexturaDTO(entitidade)
    }

    fun excluiTextura(id: Int){
        texturaRepository.deleteById(id)
    }
}