package br.com.zup.mateuschacon.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller(value = "/api/autores")
class BuscaAutoresController(private val autorRepository: AutorRepository) {

    @Get
    fun lista(): HttpResponse<Set<DetalhesAutorResponse>> =
        HttpResponse.ok(
            this.autorRepository.findAll()
                                .let(DetalhesAutorResponse::paraListaDeRetorno)
        )

}