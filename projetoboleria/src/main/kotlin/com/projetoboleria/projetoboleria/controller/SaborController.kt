package com.projetoboleria.projetoboleria.controller

import com.projetoboleria.projetoboleria.model.dto.SaborDTO
import com.projetoboleria.projetoboleria.service.SaborService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("sabor")
class SaborController (
    private val saborService: SaborService
        ){

    @GetMapping("/")
    fun retornaTodosSabores(): List<SaborDTO>?{
        return saborService.retornaTodosSabores()
    }

    @GetMapping("/{id}")
    fun retornaSaborPorId(
        @PathVariable id: Int
    ): SaborDTO{
        return saborService.retornaSaborPorId(id)
    }


}