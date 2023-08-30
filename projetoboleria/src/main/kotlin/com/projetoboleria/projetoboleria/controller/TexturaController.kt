package com.projetoboleria.projetoboleria.controller

import com.projetoboleria.projetoboleria.model.dto.TexturaDTO
import com.projetoboleria.projetoboleria.model.entity.TexturaEntity
import com.projetoboleria.projetoboleria.service.TexturaService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("textura")
class TexturaController (
    private val texturaService: TexturaService
        ){

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    fun retornaTodasAsTexturas(): List<TexturaDTO>?{
        return texturaService.retornaTodasAsTexturas()
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun retornaTexturaPorId(
        @PathVariable id: Int
    ): TexturaDTO{
        return texturaService.retornaTexturaPorId(id)
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    fun salvaTextura(
        @RequestBody textura: TexturaDTO
    ): TexturaEntity{
        return texturaService.salvaTextura(textura)
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    fun editaTextura(
        @RequestBody textura: TexturaDTO
    ): TexturaEntity{
        return texturaService.editaTextura(textura)
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun excluiTextura(
        @PathVariable id: Int
    ){
        texturaService.excluiTextura(id)
    }
}