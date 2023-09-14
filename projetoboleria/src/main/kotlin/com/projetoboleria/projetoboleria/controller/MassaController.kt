package com.projetoboleria.projetoboleria.controller

import com.projetoboleria.projetoboleria.model.dto.MassaFormDTO
import com.projetoboleria.projetoboleria.model.dto.MassaReturnDTO
import com.projetoboleria.projetoboleria.model.dto.MassaSimpleReturnDTO
import com.projetoboleria.projetoboleria.service.MassaService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("massa")
class MassaController (
    private val massaService: MassaService
){
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    fun retornaMassa(): List<MassaSimpleReturnDTO>?{
        return massaService.retornaMassa()
    }

    @GetMapping("/detalhada")
    @ResponseStatus(HttpStatus.OK)
    fun retornaMassaDetalhada():
        List<MassaReturnDTO>?{
        return massaService.retornaMassaDetalhada()
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun retornaMassaDelalhadaPorId(
        @PathVariable id: Int
    ): MassaReturnDTO?{
        return massaService.retornaMassaPorId(id)
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    fun salvaMassa(
        @RequestBody massa: MassaFormDTO
    ): MassaReturnDTO{
        return massaService.salvaMassa(massa)
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    fun editaMassa(
        @RequestBody massa: MassaFormDTO
    ): MassaReturnDTO {
        return massaService.editaMassa(massa)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun excluiMassa(
        @PathVariable id: Int
    ){
        return massaService.excluiMassa(id)
    }
}