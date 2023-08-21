package com.projetoboleria.projetoboleria.service

import com.projetoboleria.projetoboleria.model.dto.SaborDTO
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
}