package com.projetoboleria.projetoboleria.model.mapper

import com.projetoboleria.projetoboleria.model.dto.SaborDTO
import com.projetoboleria.projetoboleria.model.entity.SaborEntity
import org.springframework.stereotype.Component

@Component
class SaborMapper {
    fun saborDTOtoEntity(sabor: SaborDTO): SaborEntity{
        return SaborEntity(
            sabor.id, sabor.descricao
        )
    }

    fun entityToDTO(entidade: SaborEntity): SaborDTO{
        return SaborDTO(
            entidade.id, entidade.descricao
        )
    }
}