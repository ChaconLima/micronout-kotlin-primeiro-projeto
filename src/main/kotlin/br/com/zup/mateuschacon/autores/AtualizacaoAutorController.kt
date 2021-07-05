package br.com.zup.mateuschacon.autores

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Put
import io.micronaut.validation.Validated
import io.micronaut.http.HttpResponse
import java.util.*
import javax.validation.Valid

@Validated
@Controller(value = "/api/autores/{id}")
class AtualizacaoAutorController(val autorRepository: AutorRepository) {

    @Put
    fun atualiza(@PathVariable id:String, descricao:String ) : HttpResponse<Any>{

        val possivelAutor: Optional<Autor> = this.autorRepository.findById(id)
        if (!possivelAutor.isPresent) {
            return HttpResponse.notFound()
        }

        val autor: Autor = possivelAutor.get()
        autor.descricao = descricao

        val update = this.autorRepository.update(autor)

        val response:DetalhesAutorResponse = DetalhesAutorResponse(update)

        return HttpResponse.ok( response )
    }
}