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

    fun editaSabor(sabor: SaborDTO): SaborDTO{
        val sabor = saborRepository.save(
            saborMapper.saborDTOtoEntity(sabor)
        )
        return saborMapper.entityToDTO(sabor)
    }

    fun salvaSabor(sabor: SaborDTO): SaborDTO{
        sabor.id = null
        val sabor = saborRepository.save(
            saborMapper.saborDTOtoEntity(sabor)
        )

        return saborMapper.entityToDTO(sabor)
    }
}