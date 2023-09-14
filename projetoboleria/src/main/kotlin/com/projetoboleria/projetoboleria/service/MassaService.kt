package com.projetoboleria.projetoboleria.service

import com.projetoboleria.projetoboleria.model.dto.MassaFormDTO
import com.projetoboleria.projetoboleria.model.dto.MassaReturnDTO
import com.projetoboleria.projetoboleria.model.dto.MassaSimpleReturnDTO
import com.projetoboleria.projetoboleria.model.mapper.MassaMapper
import com.projetoboleria.projetoboleria.repository.MassaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MassaService (
    private val massaRepository: MassaRepository,
    private val massaMapper: MassaMapper
){

    fun retornaMassa(): List<MassaSimpleReturnDTO>?{
        return massaRepository.retornaMassaSimples()
    }
    fun retornaMassaDetalhada(): List<MassaReturnDTO>?{
        return massaRepository.retornaMassasDetalhadas()
    }

    fun retornaMassaPorId(id: Int): MassaReturnDTO?{
        return massaRepository.findByIdOrNull(id)?.let {
            massaMapper.entityToMassaReturnDTO(
                it
            )
        }
    }
    fun salvaMassa(massa: MassaFormDTO): MassaReturnDTO {
        massa.id = null
        val entidade = massaMapper.formDTOtoEntity(massa)
        val entity = massaRepository.save(entidade)
        return massaMapper.entityToMassaReturnDTO(entity)
    }
    fun editaMassa(massa: MassaFormDTO): MassaReturnDTO {
        val entidade = massaMapper.formDTOtoEntity(massa)
        val entity = massaRepository.save(entidade)
        return massaMapper.entityToMassaReturnDTO(entity)
    }

    fun excluiMassa(id: Int){
        massaRepository.deleteById(id)
    }
}