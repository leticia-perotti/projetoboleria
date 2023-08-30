package com.projetoboleria.projetoboleria.model.mapper

import com.projetoboleria.projetoboleria.model.dto.MarcaProdutoDTO
import com.projetoboleria.projetoboleria.model.dto.MarcaProdutoFormDTO
import com.projetoboleria.projetoboleria.model.entity.MarcaProdutoEntity
import com.projetoboleria.projetoboleria.model.enum.QualidadeNivel
import org.springframework.stereotype.Component

@Component
class MarcaProdutoMapper {

    fun marcaProdutoFormDTOtoEntity(marca: MarcaProdutoFormDTO): MarcaProdutoEntity {
        return MarcaProdutoEntity(
            marca.id,
            marca.descricao,
            QualidadeNivel.values()[marca.nivelQualidade]
        )
    }

    fun ajustaMarcaProdutoDTO(marca: MarcaProdutoDTO): MarcaProdutoDTO{
        return MarcaProdutoDTO(
            marca.id, marca.descricao, QualidadeNivel.values()[marca.nivelQualidade.toInt()].toString()
        )
    }


}