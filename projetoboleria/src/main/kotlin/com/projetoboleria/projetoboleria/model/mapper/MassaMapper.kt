package com.projetoboleria.projetoboleria.model.mapper

import com.projetoboleria.projetoboleria.model.dto.MassaFormDTO
import com.projetoboleria.projetoboleria.model.dto.MassaReturnDTO
import com.projetoboleria.projetoboleria.model.entity.MassaEntity
import com.projetoboleria.projetoboleria.repository.SaborRepository
import com.projetoboleria.projetoboleria.repository.TexturaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class MassaMapper (
    private val saborRepository: SaborRepository,
    private val texturaRepository: TexturaRepository
){

    fun formDTOtoEntity(massa: MassaFormDTO): MassaEntity{
        return MassaEntity(
            massa.id,
            massa.nome,
            saborRepository.findByIdOrNull(massa.sabor)!!,
            texturaRepository.findByIdOrNull(massa.textura)!!,
            massa.observacao
        )
    }

    fun entityToMassaReturnDTO(massa: MassaEntity): MassaReturnDTO{
        return MassaReturnDTO(
            massa.id!!,
            massa.nome,
            massa.sabor.id!!,
            massa.sabor.descricao,
            massa.textura.id!!,
            massa.textura.descricao,
            massa.observacao
        )
    }
}