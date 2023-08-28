package com.projetoboleria.projetoboleria.service

import com.projetoboleria.projetoboleria.model.dto.TexturaDTO
import com.projetoboleria.projetoboleria.model.entity.TexturaEntity
import com.projetoboleria.projetoboleria.repository.TexturaRepository
import org.springframework.stereotype.Service

@Service
class TexturaService (
    private val texturaRepository: TexturaRepository
        ){

    fun retornaTodasAsTexturas(): List<TexturaDTO>{
        return texturaRepository.retornaTodasAsTexturas()
    }

    fun retornaTexturaPorId(id: Int): TexturaDTO{
        return texturaRepository.retornaTexturaPorId(id)
    }

    fun salvaTextura(textura: TexturaDTO): TexturaEntity{
        return texturaRepository.save(
            TexturaEntity(
            null, textura.descricao
            )
        )
    }

    fun editaTextura(textura: TexturaDTO): TexturaEntity{
        return texturaRepository.save(
            TexturaEntity(
                textura.id, textura.descricao
            )
        )
    }

    fun excluiTextura(id: Int){
        texturaRepository.deleteById(id)
    }
}