package com.projetoboleria.projetoboleria.service

import com.projetoboleria.projetoboleria.model.dto.MarcaProdutoDTO
import com.projetoboleria.projetoboleria.model.dto.MarcaProdutoFormDTO
import com.projetoboleria.projetoboleria.model.dto.SaborDTO
import com.projetoboleria.projetoboleria.model.entity.MarcaProdutoEntity
import com.projetoboleria.projetoboleria.model.enum.QualidadeNivel
import com.projetoboleria.projetoboleria.model.mapper.MarcaProdutoMapper
import com.projetoboleria.projetoboleria.repository.MarcaProdutoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MarcaProdutoService(
    private val marcaProdutoRepository: MarcaProdutoRepository,
    private val marcaProdutoMapper: MarcaProdutoMapper
){
    fun retornaTodasAsMarcas(): List<MarcaProdutoDTO>? {
        return marcaProdutoRepository.retornaTodasMarcasProdutos()?.map {
            marcaProdutoMapper.ajustaMarcaProdutoDTO(it)
        }
    }

    fun retornaMarcaPorId(id: Int): MarcaProdutoDTO?{
        val marca = marcaProdutoRepository.retornaMarcaPorId(id)
        return marca?.let { marcaProdutoMapper.ajustaMarcaProdutoDTO(it) }
    }

    fun salvaMarca(marca: MarcaProdutoFormDTO): MarcaProdutoDTO{
        marca.id = null
        val entidade = marcaProdutoRepository.save(
            marcaProdutoMapper.marcaProdutoFormDTOtoEntity(marca)
        )

        return marcaProdutoMapper.entityToMarcaProdutoDTO(entidade)
    }

    fun editaMarca(marca: MarcaProdutoFormDTO): MarcaProdutoDTO{
        val entidade = marcaProdutoRepository.save(
            marcaProdutoMapper.marcaProdutoFormDTOtoEntity(marca)
        )

        return marcaProdutoMapper.entityToMarcaProdutoDTO(entidade)
    }

    fun excluiMarca(id: Int){
        marcaProdutoRepository.deleteById(id)
    }
}