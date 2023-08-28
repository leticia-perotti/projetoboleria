package com.projetoboleria.projetoboleria.service

import com.projetoboleria.projetoboleria.model.dto.SaborDTO
import com.projetoboleria.projetoboleria.model.entity.SaborEntity
import com.projetoboleria.projetoboleria.repository.SaborRepository
import org.springframework.stereotype.Service

@Service
class SaborService(
    private val saborRepository: SaborRepository
) {
    fun retornaTodosSabores(): List<SaborDTO>? {
        return saborRepository.retornaTodosSabores()
    }

    fun retornaSaborPorId(id: Int): SaborDTO {
        return saborRepository.retornaSaborPorId(id)
    }

    fun excluiSabor(id: Int){
        saborRepository.deleteById(id)
    }

    fun editaSabor(sabor: SaborDTO): SaborEntity{
        return saborRepository.save(
            SaborEntity(
                sabor.id, sabor.descricao
            )
        )
    }

    fun salvaSabor(sabor: SaborDTO): SaborEntity{
        return saborRepository.save(
            SaborEntity(
                null, sabor.descricao
            )
        )
    }
}