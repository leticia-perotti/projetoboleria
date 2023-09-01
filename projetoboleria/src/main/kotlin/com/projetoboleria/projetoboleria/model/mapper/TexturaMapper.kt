package com.projetoboleria.projetoboleria.model.mapper

import com.projetoboleria.projetoboleria.model.dto.TexturaDTO
import com.projetoboleria.projetoboleria.model.entity.TexturaEntity
import org.springframework.stereotype.Component

@Component
class TexturaMapper {
    fun texturaDTOtoEntity(textura: TexturaDTO): TexturaEntity{
        return TexturaEntity(
            textura.id, textura.descricao
        )
    }

    fun toTexturaDTO(entity: TexturaEntity): TexturaDTO {
        return TexturaDTO(
            entity.id, entity.descricao
        )
    }
}