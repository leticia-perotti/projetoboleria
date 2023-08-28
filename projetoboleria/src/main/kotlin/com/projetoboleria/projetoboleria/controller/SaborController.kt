package com.projetoboleria.projetoboleria.controller

import com.projetoboleria.projetoboleria.model.dto.SaborDTO
import com.projetoboleria.projetoboleria.model.entity.SaborEntity
import com.projetoboleria.projetoboleria.service.SaborService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("sabor")
class SaborController (
    private val saborService: SaborService
        ){

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    fun retornaTodosSabores(): List<SaborDTO>?{
        return saborService.retornaTodosSabores()
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun retornaSaborPorId(
        @PathVariable id: Int
    ): SaborDTO{
        return saborService.retornaSaborPorId(id)
    }
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    fun SaborEntity(
        @RequestBody sabor: SaborDTO
    ): SaborEntity{
        return saborService.salvaSabor(sabor)
    }
    //TESTAR
    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    fun editaSabor(
        @RequestBody sabor: SaborDTO
    ): SaborEntity {
        return saborService.editaSabor(sabor)
    }
    //TESTAR
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun excluiSabor(
        @PathVariable id: Int
    ){
        return saborService.excluiSabor(id)
    }

}