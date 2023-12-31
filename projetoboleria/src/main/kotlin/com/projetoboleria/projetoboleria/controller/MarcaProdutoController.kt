package com.projetoboleria.projetoboleria.controller

import com.projetoboleria.projetoboleria.model.dto.MarcaProdutoDTO
import com.projetoboleria.projetoboleria.model.dto.MarcaProdutoFormDTO
import com.projetoboleria.projetoboleria.model.dto.SaborDTO
import com.projetoboleria.projetoboleria.model.entity.MarcaProdutoEntity
import com.projetoboleria.projetoboleria.model.entity.SaborEntity
import com.projetoboleria.projetoboleria.repository.MarcaProdutoRepository
import com.projetoboleria.projetoboleria.service.MarcaProdutoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("marca-produto")
class MarcaProdutoController (
    private val marcaProdutoService: MarcaProdutoService
        ){
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    fun retornaTodasAsMarcas(): List<MarcaProdutoDTO>?{
        return marcaProdutoService.retornaTodasAsMarcas()
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun retornaMarcaPorId(
        @PathVariable id: Int
    ): MarcaProdutoDTO? {
        return marcaProdutoService.retornaMarcaPorId(id)
    }
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    fun salvaMarca(
        @RequestBody marca: MarcaProdutoFormDTO
    ): MarcaProdutoDTO {
        return marcaProdutoService.salvaMarca(marca)
    }
    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    fun editaMarca(
        @RequestBody marca: MarcaProdutoFormDTO
    ): MarcaProdutoDTO {
        return marcaProdutoService.editaMarca(marca)
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun excluiMarca(
        @PathVariable id: Int
    ){
        return marcaProdutoService.excluiMarca(id)
    }
}