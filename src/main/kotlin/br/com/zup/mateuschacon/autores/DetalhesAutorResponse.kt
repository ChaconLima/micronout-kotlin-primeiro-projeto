package br.com.zup.mateuschacon.autores

import java.time.LocalDateTime

class DetalhesAutorResponse(autor: Autor) {

    val id:String = autor.id
    val nome:String = autor.nome
    val email:String = autor.email
    val descricao:String = autor.descricao

    companion object{

        fun paraListaDeRetorno( listaAutores: List<Autor>): Set<DetalhesAutorResponse> =
            listaAutores.map(::DetalhesAutorResponse).toSet()

    }
}
