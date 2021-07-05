package br.com.zup.mateuschacon.autores


import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.validation.Valid


@Validated
@Controller(value = "/api/autores")
class CadastraAutorController(val autorRepository: AutorRepository) {

    @Post
    fun cadastra(@Body @Valid request: NovoAutorRequest): HttpResponse<Any> =
        request .paraAutor()
                .let(this.autorRepository::save)
                .run{
                    val uri = UriBuilder.of("/autores/{id}")
                                        .expand(mutableMapOf(Pair("id",this.id)))
                    HttpResponse.created(uri)
                }

}