package com.projetoboleria.projetoboleria.service

import com.projetoboleria.projetoboleria.model.dto.SaborDTO
import com.projetoboleria.projetoboleria.model.entity.SaborEntity
import com.projetoboleria.projetoboleria.model.mapper.SaborMapper
import com.projetoboleria.projetoboleria.repository.SaborRepository
import org.springframework.stereotype.Service

@Service
class SaborService(
    private val saborRepository: SaborRepository,
    private val saborMapper: SaborMapper
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
            saborMapper.saborDTOtoEntity(sabor)
        )
    }

    fun salvaSabor(sabor: SaborDTO): SaborEntity{
        sabor.id = null
        return saborRepository.save(
            saborMapper.saborDTOtoEntity(sabor)
        )
    }
}