package com.projetoboleria.projetoboleria.controller

import com.projetoboleria.projetoboleria.model.dto.SaborDTO
import com.projetoboleria.projetoboleria.model.dto.UsuarioDto
import com.projetoboleria.projetoboleria.model.dto.UsuarioFormDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("usuario")
class UsuarioController {
    //Atividade EAD

    @GetMapping("")
    fun retornaTodosUsuarioa():
            ResponseEntity<String>{
        return ResponseEntity.ok("Listando usuários...")
    }

    //forma 1 de um response entity com status
    @GetMapping("/{id}")
    fun retornandoUsuarioPorId(
        @PathVariable id: Int
    ): ResponseEntity<String> {
        return ResponseEntity.ok("Retornando usuário de id " + id)
    }

    //forma 2 de um response entity com status
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    fun criandoUsuario(
        @RequestBody usuario: UsuarioDto
    ): String{
        return "Criando usuário de nome " + usuario.nome + " e senha " + usuario.senha
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("")
    fun editandoUsuario(
        @RequestBody usuario: UsuarioFormDTO
    ): String{
        return "Editando usuário de id " + usuario.id + " nome " + usuario.nome + " e senha " + usuario.senha
    }


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    fun excluindoUsuario(
        @PathVariable id: Int
    ): String{
        return "Excluindo usuário de id " + id
    }


}