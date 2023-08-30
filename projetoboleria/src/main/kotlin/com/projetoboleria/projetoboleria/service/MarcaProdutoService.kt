package com.projetoboleria.projetoboleria.service

import com.projetoboleria.projetoboleria.model.dto.MarcaProdutoDTO
import com.projetoboleria.projetoboleria.model.dto.MarcaProdutoFormDTO
import com.projetoboleria.projetoboleria.model.dto.SaborDTO
import com.projetoboleria.projetoboleria.model.entity.MarcaProdutoEntity
import com.projetoboleria.projetoboleria.model.enum.QualidadeNivel
import com.projetoboleria.projetoboleria.repository.MarcaProdutoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MarcaProdutoService(
    private val marcaProdutoRepository: MarcaProdutoRepository
){
    fun retornaTodasAsMarcas(): List<MarcaProdutoDTO>? {
        return marcaProdutoRepository.findAll().map {
            MarcaProdutoDTO(
                it.id,
                it.descricao,
                it.nivelQualidade.toString()
            )
        }
    }

    fun retornaMarcaPorId(id: Int): MarcaProdutoDTO?{
        val marca = marcaProdutoRepository.findByIdOrNull(id)
        return if (marca !=  null) {
            MarcaProdutoDTO(
                marca.id,
                marca.descricao,
                marca.nivelQualidade.toString()
            )
        }else null

    }

    fun salvaMarca(marca: MarcaProdutoFormDTO): MarcaProdutoEntity{
        return marcaProdutoRepository.save(
            MarcaProdutoEntity(
                null, marca.descricao, QualidadeNivel.values()[marca.nivelQualidade]
            )
        )
    }

    fun editaMarca(marca: MarcaProdutoFormDTO): MarcaProdutoEntity{
        return marcaProdutoRepository.save(
            MarcaProdutoEntity(
                marca.id, marca.descricao, QualidadeNivel.values()[marca.nivelQualidade]
            )
        )
    }

    fun excluiMarca(id: Int){
        marcaProdutoRepository.deleteById(id)
    }
}