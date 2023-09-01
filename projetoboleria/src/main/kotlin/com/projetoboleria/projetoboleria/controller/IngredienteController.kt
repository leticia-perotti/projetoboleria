package com.projetoboleria.projetoboleria.controller

import com.projetoboleria.projetoboleria.model.dto.IngredienteDTO
import com.projetoboleria.projetoboleria.model.dto.IngredienteFormDTO
import com.projetoboleria.projetoboleria.model.dto.MarcaProdutoDTO
import com.projetoboleria.projetoboleria.model.dto.MarcaProdutoFormDTO
import com.projetoboleria.projetoboleria.service.IngredienteService
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("ingrediente")
class IngredienteController (
    private val ingredienteService: IngredienteService
){
    //Implementar paginação
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    fun retornaIngredientesComMarca(): List<IngredienteDTO>?{
        return ingredienteService.retornaIngredientesComMarca()
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun retornaMarcaPorId(
        @PathVariable id: Int
    ): IngredienteFormDTO? {
        return ingredienteService.retornaIngredientePorId(id)
    }
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    fun salvaMarca(
        @RequestBody ingrediente: IngredienteFormDTO
    ): IngredienteDTO {
        return ingredienteService.salvaIngrediente(ingrediente)
    }
    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    fun editaMarca(
        @RequestBody marca: IngredienteFormDTO
    ): IngredienteDTO {
        return ingredienteService.editarIngrediente(marca)
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun excluiMarca(
        @PathVariable id: Int
    ){
        return ingredienteService.excluiIngrediente(id)
    }
}